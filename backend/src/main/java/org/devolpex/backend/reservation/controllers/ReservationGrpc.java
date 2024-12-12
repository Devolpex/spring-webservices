package org.devolpex.backend.reservation.controllers;

import java.util.List;

import org.devolpex.backend.reservation.ReservationGrpcMapper;
import org.devolpex.backend.reservation.ReservationMapperImpl;
import org.devolpex.backend.reservation.ReservationServiceImpl;
import org.devolpex.backend.reservation.dto.ReservationDTO;
import org.devolpex.backend.stubs.main.ReservationServiceGrpc;
import org.devolpex.backend.stubs.reservation.DeleteReservationREQ;
import org.devolpex.backend.stubs.reservation.GetReservationByIdREQ;
import org.devolpex.backend.stubs.reservation.GetReservationByIdRES;
import org.devolpex.backend.stubs.reservation.GetReservationPageREQ;
import org.devolpex.backend.stubs.reservation.GetReservationPageRES;
import org.devolpex.backend.stubs.reservation.GetReservationsListREQ;
import org.devolpex.backend.stubs.reservation.GetReservationsListRES;
import org.devolpex.backend.stubs.reservation.Reservation;
import org.devolpex.backend.stubs.reservation.ReservationPage;
import org.devolpex.backend.stubs.reservation.ReservationREQ;
import org.devolpex.backend.stubs.reservation.ReservationRES;
import org.devolpex.backend.stubs.reservation.UpdateReservationREQ;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@Slf4j
public class ReservationGrpc extends ReservationServiceGrpc.ReservationServiceImplBase {

    private ReservationServiceImpl service;
    private ReservationGrpcMapper grpcMapper;

    @Override
    public void fetchReservationList(GetReservationsListREQ req,
            StreamObserver<GetReservationsListRES> res) {
        try {
            List<Reservation> reservations = service.findAll()
                    .stream()
                    .map(grpcMapper::toProto)
                    .toList();
            res.onNext(GetReservationsListRES.newBuilder()
                    .addAllReservations(reservations)
                    .build());
            res.onCompleted();
        } catch (Exception e) {
            // log.error("Error fetching reservations", e);
            res.onError(e);
        }
    }

    /**
     * Fetch a page of reservations
     */
    @Override
    public void fetchReservationPage(
            GetReservationPageREQ req,
            StreamObserver<GetReservationPageRES> res) {
        try {
            // Create the Pageable object
            Pageable pageable = PageRequest.of(
                    req.getPage() - 1,
                    req.getSize(),
                    Sort.Direction.fromString(req.getOrderBy().toUpperCase()),
                    req.getSortBy());
            // Fetch the page
            Page<ReservationDTO> page = service.findAll(pageable);

            // Convert the page to a proto page
            ReservationPage grpcPage = grpcMapper.mapToProtoPage(page);

            // Send the response
            res.onNext(GetReservationPageRES.newBuilder()
                    .setReservationPage(grpcPage)
                    .build());
            res.onCompleted();
        } catch (Exception e) {
            // log.error("Error fetching reservation page", e);
            res.onError(e);
        }
    }

    /**
     * Fetch a reservation by ID
     */
    @Override
    public void fetchReservationById(GetReservationByIdREQ req,
            StreamObserver<GetReservationByIdRES> res) {
        try {
            ReservationDTO reservationDTO = service.findById(req.getId());
            res.onNext(GetReservationByIdRES.newBuilder()
                    .setReservation(grpcMapper.toProto(reservationDTO))
                    .build());
            res.onCompleted();
        } catch (Exception e) {
            // log.error("Error fetching reservation by ID", e);
            res.onError(e);
        }
    }

    /**
     * Create a reservation
     */
    @Override
    public void createReservation(ReservationREQ req,
            StreamObserver<ReservationRES> res) {
        try {
            org.devolpex.backend.reservation.ReservationREQ reservationREQ = grpcMapper.mapToReservationReq(req);
            ReservationDTO reservationDTO = service.create(reservationREQ);
            res.onNext(ReservationRES.newBuilder()
                    .setReservation(grpcMapper.toProto(reservationDTO))
                    .build());
            res.onCompleted();
        } catch (Exception e) {
            // log.error("Error creating reservation", e);
            res.onError(e);
        }
    }

    /**
     * Update a reservation
     */
    @Override
    public void updateReservation(UpdateReservationREQ req,
            StreamObserver<ReservationRES> res) {
        try {
            org.devolpex.backend.reservation.ReservationREQ reservationREQ = grpcMapper
                    .mapToReservationReq(req.getReservation());
            ReservationDTO reservationDTO = service.update(req.getId(), reservationREQ);
            res.onNext(ReservationRES.newBuilder()
                    .setReservation(grpcMapper.toProto(reservationDTO))
                    .build());
            res.onCompleted();
        } catch (Exception e) {
            // log.error("Error updating reservation", e);
            res.onError(e);
        }

    }

    /**
     * Delete a reservation
     */
    @Override
    public void deleteReservation(DeleteReservationREQ req,
            StreamObserver<Empty> res) {
        try {
            service.delete(req.getId());
            // Send an empty response upon successful deletion
            res.onNext(Empty.newBuilder().build());
            res.onCompleted();
        } catch (Exception e) {
            // log.error("Error deleting reservation", e);
            res.onError(e);
        }
    }

}
