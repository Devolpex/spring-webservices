package org.devolpex.backend.client.controllers;

import java.util.List;

import org.devolpex.backend.client.ClientMapperImpl;
import org.devolpex.backend.client.ClientREQ;
import org.devolpex.backend.client.ClientServiceImpl;
import org.devolpex.backend.client.dto.ClientDTO;
import org.devolpex.backend.client.http.ClientXMLREQ;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.RequiredArgsConstructor;

@Component
@WebService(serviceName = "ClientSOAP")
@RequiredArgsConstructor
public class ClientSOAP {

    private final ClientServiceImpl service;
    private final ClientMapperImpl mapper;

    // Fetch list of clients
    @WebMethod
    public List<ClientDTO> fetchList() {
        return service.findAll();
    }

    // Fetch page of clients
    // @WebMethod
    // public Page<ClientDTO> fetchPage(
    //         @WebParam(name = "page") Integer page,
    //         @WebParam(name = "size") Integer size,
    //         @WebParam(name = "sortBy") String sortBy,
    //         @WebParam(name = "orderBy") String orderBy) {

    //     // Default values for optional parameters
    //     if (sortBy == null || sortBy.isEmpty()) {
    //         sortBy = "id";
    //     }
    //     if (orderBy == null || orderBy.isEmpty()) {
    //         orderBy = "desc";
    //     }

    //     // Build Pageable object
    //     Pageable pageable = PageRequest.of(
    //             page - 1,
    //             size,
    //             Sort.Direction.fromString(orderBy.toUpperCase()),
    //             sortBy);

    //     return service.findAll(pageable);
    // }

    // Fetch client by id
    @WebMethod
    public ClientDTO fetchById(@WebParam(name = "id") Long id) {
        return service.findById(id);
    }

    // Create client
    @WebMethod
    public ClientDTO createClient(@WebParam(name = "client") ClientXMLREQ xml) {
        ClientREQ req = mapper.toRequest(xml);
        return service.create(req);
    }

    // Update client
    @WebMethod
    public ClientDTO updateClient(@WebParam(name = "id") Long id, @WebParam(name = "client") ClientXMLREQ xml) {
        ClientREQ req = mapper.toRequest(xml);
        return service.update(id, req);
    }

    // Delete client
    @WebMethod
    public Boolean deleteClient(@WebParam(name = "id") Long id) {
        service.delete(id);
        return true;
    }

}
