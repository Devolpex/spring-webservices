package org.devolpex.backend.chambre;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ChambreDTO {

    private Long id;
    private String type;
    private Double prix;
    private Boolean disponible;

}