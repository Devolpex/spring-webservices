package org.devolpex.backend.client.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private List<ReservationDTO> reservations;
}
