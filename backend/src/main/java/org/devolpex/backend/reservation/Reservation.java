package org.devolpex.backend.reservation;

import java.time.LocalDate;

import org.devolpex.backend.chambre.Chambre;
import org.devolpex.backend.client.Client;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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
    private LocalDate dateDebut; // Date de début de séjour

    @Column(nullable = false)
    private LocalDate dateFin; // Date de fin de séjour

    @Column
    private String preferences; // Préférences spécifiques pour la réservation
}
