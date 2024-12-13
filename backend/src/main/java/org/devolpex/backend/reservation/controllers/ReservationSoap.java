package org.devolpex.backend.reservation.controllers;

import java.util.List;

import org.devolpex.backend.reservation.ReservationREQ;
import org.devolpex.backend.reservation.ReservationServiceImpl;
import org.devolpex.backend.reservation.dto.ReservationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.validation.Valid;

@Component
@WebService(serviceName = "ReservationService")
@RequiredArgsConstructor
public class ReservationSoap {

    private ReservationServiceImpl service;

    @WebMethod
    public List<ReservationDTO> fetchReservationList() {
        return service.findAll();
    }

    @WebMethod
    public ReservationDTO fetchReservationById(@WebParam(name="id") Long id) {
        return service.findById(id);
    }

    @WebMethod
    public ReservationDTO createReservation(@Valid ReservationREQ reservation) {
        return service.create(reservation);
    }

    @WebMethod
    public ReservationDTO updateReservation(@WebParam(name="id") Long id,@Valid ReservationREQ reservation) {
        return service.update(id, reservation);
    }

    @WebMethod
    public void deleteReservation(@WebParam(name="id") Long id) {
        service.delete(id);
    }

    @WebMethod
    public Page<ReservationDTO> fetchReservationPage(@WebParam(name="page") Integer page, @WebParam(name="size") Integer size, @WebParam(name="sortBy") String sortBy, @WebParam(name="orderBy") String orderBy) {
        Pageable pageable = PageRequest.of(page - 1, size, Direction.valueOf(orderBy.toUpperCase()), sortBy);
        return service.findAll(pageable);
    }

}
