package org.devolpex.backend.chambre.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChambreReq {
    @NotNull(message="Le type de la chambre est obligatoire")
    private String type;
    
    @NotNull(message="Le prix de la chambre est obligatoire")
    private Double prix;

    @NotNull(message="La disponibilité de la chambre est obligatoire")
    private Boolean disponible;
}
