package org.devolpex.backend.chambre.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String preferences;

}
