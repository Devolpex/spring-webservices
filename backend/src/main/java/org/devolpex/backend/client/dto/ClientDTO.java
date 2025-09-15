package org.devolpex.backend.client.dto;

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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;

    @XmlElementWrapper(name = "reservations")
    @XmlElement(name = "reservation")
    private List<ReservationDTO> reservations;

}
