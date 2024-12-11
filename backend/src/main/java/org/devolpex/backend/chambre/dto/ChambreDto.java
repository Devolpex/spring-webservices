package org.devolpex.backend.chambre.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChambreDTO {
    private String type;
    private Double prix;
    private Boolean disponible;
    private List<ReservationDTO> reservations;
}
