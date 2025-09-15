package org.devolpex.backend.chambre;

import java.util.List;

import org.devolpex.backend.reservation.Reservation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chambre")
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

    @OneToMany(mappedBy = "chambre")
    private List<Reservation> reservations;
}