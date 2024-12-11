package org.devolpex.backend.client.controllers;


import lombok.AllArgsConstructor;
import org.devolpex.backend.client.ClientREQ;
import org.devolpex.backend.client.ClientServiceImpl;
import org.devolpex.backend.reservation.dto.ClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/clients")
public class ClientRest {

    private final ClientServiceImpl clientService;

    // Create a new client
    @PostMapping("/create")
    public  ResponseEntity<ClientDTO> createClient(@RequestBody ClientREQ req) {
        return ResponseEntity.ok(clientService.create(req));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody ClientREQ req) {
        return ResponseEntity.ok(clientService.update(id, req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findById(id));
    }

}
