package org.devolpex.backend.reservation;

import java.util.Date;

import org.apache.cxf.spring.boot.autoconfigure.CxfProperties.Metrics.Client;
import org.devolpex.backend.chambre.Chambre;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client; // Référence au client associé

    @ManyToOne
    @JoinColumn(name = "chambre_id", nullable = false)
    private Chambre chambre; // Référence à la chambre réservée

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDebut; // Date de début de séjour

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateFin; // Date de fin de séjour

    @Column
    private String preferences; // Préférences spécifiques pour la réservation
}
