package org.devolpex.backend.client.controllers;

import java.util.List;

import org.devolpex.backend.client.ClientGrpcMapper;
import org.devolpex.backend.client.ClientREQ;
import org.devolpex.backend.client.ClientServiceImpl;
import org.devolpex.backend.client.dto.ClientDTO;
import org.devolpex.backend.stubs.client.ClientPRT;
import org.devolpex.backend.stubs.client.ClientPagePRT;
import org.devolpex.backend.stubs.client.ClientServiceGrpc;
import org.devolpex.backend.stubs.client.CreateClientREQ;
import org.devolpex.backend.stubs.client.DeleteClientREQ;
import org.devolpex.backend.stubs.client.FetchClientByIdREQ;
import org.devolpex.backend.stubs.client.FetchClientByIdRES;
import org.devolpex.backend.stubs.client.FetchListClientsREQ;
import org.devolpex.backend.stubs.client.FetchListClientsRES;
import org.devolpex.backend.stubs.client.FetchPageClientsREQ;
import org.devolpex.backend.stubs.client.FetchPageClientsRES;
import org.devolpex.backend.stubs.client.UpdateClientREQ;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@Slf4j
@RequiredArgsConstructor
public class ClientGRPC extends ClientServiceGrpc.ClientServiceImplBase {

    private final ClientServiceImpl service;
    private final ClientGrpcMapper grpcMapper;

    // Fetch list of clients
    @Override
    public void fetchListClients(FetchListClientsREQ req, StreamObserver<FetchListClientsRES> res) {
        try {

            List<ClientPRT> clients = service.findAll()
                    .stream()
                    .map(grpcMapper::toProto)
                    .toList();
            res.onNext(FetchListClientsRES.newBuilder()
                    .addAllClients(clients)
                    .build());
            res.onCompleted();
        } catch (Exception e) {
            log.error("Error fetching clients", e);
            res.onError(e);
        }
    }

    // Fetch a page of clients
    public void fetchPageClients(FetchPageClientsREQ req, StreamObserver<FetchPageClientsRES> res) {
        try {
            // Create the Pageable object
            Pageable pageable = PageRequest.of(
                    req.getPage() - 1,
                    req.getSize(),
                    Sort.Direction.fromString(req.getOrderBy().toUpperCase()),
                    req.getSortBy());
            // Get data from the service
            Page<ClientDTO> page = service.findAll(pageable);
            ClientPagePRT grpcPage = grpcMapper.mapToProtoPage(page);
            // Send the response
            res.onNext(FetchPageClientsRES.newBuilder()
                    .setData(grpcPage)
                    .build());
            res.onCompleted();
        } catch (Exception e) {
            log.error("Error fetching clients", e);
            res.onError(e);
        }
    }

    // Fetch a client by ID
    @Override
    public void fetchClientById(FetchClientByIdREQ req, StreamObserver<FetchClientByIdRES> res) {
        try {
            ClientDTO client = service.findById(req.getId());
            res.onNext(FetchClientByIdRES.newBuilder()
                    .setClient(grpcMapper.toProto(client))
                    .build());
            res.onCompleted();
        } catch (Exception e) {
            log.error("Error fetching client", e);
            res.onError(e);
        }
    }

    // Create a new client
    @Override
    public void createClient(CreateClientREQ req, StreamObserver<ClientPRT> res) {
        try {
            ClientREQ clientREQ = grpcMapper.fromProto(req.getClient());
            ClientDTO clientDTO = service.create(clientREQ);
            res.onNext(grpcMapper.toProto(clientDTO));
            res.onCompleted();
        } catch (Exception e) {
            log.error("Error creating client", e);
            res.onError(e);
        }
    }

    // Update a client
    @Override
    public void updateClient(UpdateClientREQ req, StreamObserver<ClientPRT> res) {
        try {
            ClientREQ clientREQ = grpcMapper.fromProto(req.getClient());
            ClientDTO clientDTO = service.update(req.getId(), clientREQ);
            res.onNext(grpcMapper.toProto(clientDTO));
            res.onCompleted();
        } catch (Exception e) {
            log.error("Error updating client", e);
            res.onError(e);
        }
    }

    // Delete a client
    @Override
    public void deleteClient(DeleteClientREQ req, StreamObserver<Empty> res) {
        try {
            service.delete(req.getId());
            res.onNext(Empty.newBuilder().build());
            res.onCompleted();
        } catch (Exception e) {
            log.error("Error deleting client", e);
            res.onError(e);
        }
    }

}
