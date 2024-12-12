package org.devolpex.backend.client.controllers;

import java.util.List;

import org.devolpex.backend.client.ClientREQ;
import org.devolpex.backend.client.ClientServiceImpl;
import org.devolpex.backend.client.dto.ClientDTO;
import org.springframework.stereotype.Controller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ClientGraphQL {

    private final ClientServiceImpl service;

    @QueryMapping
    public List<ClientDTO> fetchListClients() {
        return service.findAll();
    }

    @QueryMapping
    public ClientDTO fetchClientById(@Argument Long id) {
        return service.findById(id);
    }

    @QueryMapping
    public Page<ClientDTO> fetchPaginatedClients(
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

    @MutationMapping
    public ClientDTO createClient(@Argument ClientREQ input) {
        return service.create(input);
    }

    @MutationMapping
    public ClientDTO updateClient(@Argument Long id, @Argument ClientREQ input) {
        return service.update(id, input);
    }

    @MutationMapping
    public Boolean deteClient(@Argument Long id) {
        service.delete(id);
        return true;
    }

}
