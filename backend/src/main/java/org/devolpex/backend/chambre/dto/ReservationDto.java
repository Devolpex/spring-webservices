package org.devolpex.backend.chambre.dto;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ReservationDto {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String preferences;
}
