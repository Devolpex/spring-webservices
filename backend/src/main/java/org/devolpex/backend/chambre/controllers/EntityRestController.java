package org.devolpex.backend.chambre.controllers;

import java.util.List;

import org.devolpex.backend.chambre.Chambre;
import org.devolpex.backend.chambre.ChambreRepository;
import org.devolpex.backend.chambre.dto.ChambreDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/hotel")
class EntityRestController {
    
    @Autowired
    private ChambreRepository chambreRepositorie;

    @PostMapping("/chambre")
    public Chambre createChambre(@RequestBody Chambre chambre) {
        return chambreRepositorie.save(chambre);
    }

    @GetMapping("/chambre/{id}")
    public Chambre findChambreById(@PathVariable Long id) {
        return chambreRepositorie.findById(id).orElse(null);
    }
    
    @GetMapping("/chambres")
    public List<Chambre> findAllChambres() {
        return chambreRepositorie.findAll();
    }

    @DeleteMapping("/chambre/{id}")
    public void deleteChambre(@PathVariable Long id) {
        chambreRepositorie.deleteById(id);
    }

    @PutMapping("/chambre/{id}")
    public Chambre updateChambre(@PathVariable Long id, @RequestBody ChambreDto chambre) {
        Chambre existingChambre = chambreRepositorie.findById(id).orElse(null);
        existingChambre.setType(chambre.getType());
        existingChambre.setPrix(chambre.getPrix());
        existingChambre.setDisponible(chambre.getDisponible());
        existingChambre.setReservations(chambre.getReservations());
        return chambreRepositorie.save(existingChambre);
    }
}