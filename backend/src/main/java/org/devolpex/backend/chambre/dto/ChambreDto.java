package org.devolpex.backend.chambre.dto;

import java.util.List;

import org.devolpex.backend.chambre.dto.ReservationDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChambreDto {
    private Long id;
    private String type;
    private Double prix;
    private Boolean disponible;
    private List<ReservationDto> reservations;
}
