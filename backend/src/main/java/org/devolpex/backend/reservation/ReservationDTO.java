package org.devolpex.backend.reservation;

import java.time.LocalDate;

import org.devolpex.backend.chambre.ChambreDTO;
import org.devolpex.backend.client.ClientDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReservationDTO {

    private Long id;
    private ClientDTO client;
    private ChambreDTO chambre;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String preferences;
}