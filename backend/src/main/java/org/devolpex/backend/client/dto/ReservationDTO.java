package org.devolpex.backend.client.dto;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
public class ReservationDTO {

    private Long id;

    @XmlElement(name = "chambre")
    private ChambreDTO chambre;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String preferences;
}