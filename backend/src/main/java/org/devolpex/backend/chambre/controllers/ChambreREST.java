package org.devolpex.backend.chambre.controllers;

import java.util.List;

import org.devolpex.backend.chambre.ChambreServiceImpl;
import org.devolpex.backend.chambre.dto.ChambreDto;
import org.devolpex.backend.chambre.dto.ChambreReq;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ChambreREST {

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

    @GetMapping("/chambres/page")
    public ResponseEntity<Page<ChambreDto>> findAllChambrePage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "desc") String orderBy) {
        Pageable pageable = PageRequest.of(page - 1, size, Direction.valueOf(orderBy.toUpperCase()), sortBy);
        Page<ChambreDto> chambres = chambreService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(chambres);
    }
    
}