package org.devolpex.backend.chambre.dto;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
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

    @XmlElementWrapper(name = "reservations")
    @XmlElement(name = "reservation")
    private List<ReservationDto> reservations;
}
