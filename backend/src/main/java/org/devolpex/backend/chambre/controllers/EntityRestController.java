package org.devolpex.backend.chambre.controllers;

import java.util.List;

import org.devolpex.backend.chambre.Chambre;
import org.devolpex.backend.chambre.dto.*;
import org.devolpex.backend.chambre.ChambreRepository;
import org.devolpex.backend.chambre.ChambreServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.api.Http;
import com.google.rpc.context.AttributeContext;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
class EntityRestController {

    private final ChambreServiceImpl chambreService;

    @PostMapping("/chambre")
    public ResponseEntity<ChambreDto> createChambre(@RequestBody ChambreReq chambre) {
        return ResponseEntity.status(HttpStatus.CREATED).body(chambreService.create(chambre));
    }

    @GetMapping("/chambre/{id}")
    public ResponseEntity<ChambreDto> findChambreById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(chambreService.findById(id));
    }
    
    @GetMapping("/chambres")
    public ResponseEntity<List<ChambreDto>> findAllChambres() {
        return ResponseEntity.status(HttpStatus.OK).body(chambreService.findAll());
    }

    @DeleteMapping("/chambre/{id}")
    public ResponseEntity<Void> deleteChambre(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/chambre/{id}")
    public ResponseEntity<ChambreDto> updateChambre(@PathVariable Long id, @RequestBody ChambreReq chambre) {
        return  ResponseEntity.status(HttpStatus.OK).body(chambreService.update(id, chambre));
    }

    
}