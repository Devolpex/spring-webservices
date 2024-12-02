package org.devolpex.backend.chambre;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chambres")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type; // Exemple: simple, double, etc.

    @Column(nullable = false)
    private Double prix; // Prix par nuit

    @Column(nullable = false)
    private Boolean disponible; // Statut de disponibilité
}