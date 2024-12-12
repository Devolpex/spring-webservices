package org.devolpex.backend.reservation.controllers;

import java.util.List;

import org.devolpex.backend.reservation.ReservationREQ;
import org.devolpex.backend.reservation.ReservationServiceImpl;
import org.devolpex.backend.reservation.dto.ReservationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ReservationREST {

    private ReservationServiceImpl service;

    // Create a new reservation
    @PostMapping("/api/reservation")
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationREQ req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(req));
    }

    // Get all reservations in list
    @GetMapping("/api/reservation/list")
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    // Get all reservations in page
    @GetMapping("/api/reservation/page")
    public ResponseEntity<Page<ReservationDTO>> getAllReservationsPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "desc") String orderBy) {
        // Create a new Pageable object
        Pageable pageable = PageRequest.of(page - 1, size, Direction.valueOf(orderBy.toUpperCase()), sortBy);
        Page<ReservationDTO> reservations = service.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(reservations);
    }

    // Get a reservation by its ID
    @GetMapping("/api/reservation/{id}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    // Delete a reservation by its ID
    @DeleteMapping("/api/reservation/{id}")
    public ResponseEntity<Void> deleteReservationById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    // Update a reservation by its ID
    @PutMapping("/api/reservation/{id}")
    public ResponseEntity<ReservationDTO> updateReservationById(@PathVariable Long id, @RequestBody ReservationREQ req) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, req));
    }
}
