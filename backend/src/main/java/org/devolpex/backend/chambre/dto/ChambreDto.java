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
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ChambreDto {
    private Long id;
    private String type;
    private Double prix;
    private Boolean disponible;
    private List<ReservationDto> reservations;
}
