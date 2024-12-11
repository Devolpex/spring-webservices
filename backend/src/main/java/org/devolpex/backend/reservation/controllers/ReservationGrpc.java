package org.devolpex.backend.reservation.controllers;

import java.util.List;

import org.devolpex.backend.reservation.ReservationGrpcMapper;
import org.devolpex.backend.reservation.ReservationMapperImpl;
import org.devolpex.backend.reservation.ReservationServiceImpl;
import org.devolpex.backend.stubs.main.ReservationServiceGrpc;
import org.devolpex.backend.stubs.reservation.GetReservationsListREQ;
import org.devolpex.backend.stubs.reservation.GetReservationsListRES;
import org.devolpex.backend.stubs.reservation.Reservation;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
@Slf4j
public class ReservationGrpc extends ReservationServiceGrpc.ReservationServiceImplBase {

    private final ReservationServiceImpl service;
    private final ReservationGrpcMapper grpcMapper;

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
            log.error("Error fetching reservations", e);
            res.onError(e);
        }
    }

}
