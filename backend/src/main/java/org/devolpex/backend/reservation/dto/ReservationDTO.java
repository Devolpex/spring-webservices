package org.devolpex.backend.reservation.dto;

import java.time.LocalDate;

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