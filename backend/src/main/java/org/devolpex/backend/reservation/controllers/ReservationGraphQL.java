package org.devolpex.backend.reservation.controllers;

import java.util.List;

import org.devolpex.backend.reservation.ReservationDTO;
import org.devolpex.backend.reservation.ReservationREQ;
import org.devolpex.backend.reservation.ReservationServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReservationGraphQL {

    private final ReservationServiceImpl service;

    @QueryMapping
    public List<ReservationDTO> getReservationsList() {
        return service.findAll();
    }

    @QueryMapping
    public ReservationDTO getReservation(@Argument Long id) {
        return service.findById(id);
    }

    /**
     * Query Mapping to get reservation in page
     */
    @QueryMapping
    public Page<ReservationDTO> getPaginatedReservations(
            @Argument Integer page,
            @Argument Integer size,
            @Argument String sortBy,
            @Argument String orderBy) {
        // Default values for optional parameters
        if (sortBy == null || sortBy.isEmpty()) {
            sortBy = "id";
        }
        if (orderBy == null || orderBy.isEmpty()) {
            orderBy = "desc";
        }

        // Build Pageable object
        Pageable pageable = PageRequest.of(
                page - 1,
                size,
                Sort.Direction.fromString(orderBy.toUpperCase()),
                sortBy);

        return service.findAll(pageable);
    }

    /**
     * Mutation Mapping to create a reservation
     */
    @MutationMapping
    public ReservationDTO createReservation(@Argument ReservationREQ input) {
        return service.create(input);
    }

    /**
     * Mutation Mapping to update a reservation
     */
    @MutationMapping
    public ReservationDTO updateReservation(@Argument Long id, @Argument ReservationREQ input) {
        return service.update(id, input);
    }

    /**
     * Mutation Mapping to delete a reservation
     */
    @MutationMapping
    public Boolean deleteReservation(@Argument Long id) {
        service.delete(id);
        return true;
    }

}
