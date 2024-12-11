package org.devolpex.backend.reservation;

import java.time.LocalDate;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import org.devolpex.backend.client.ClientDTO;

@Builder
public record ReservationREQ(

    @NotNull(message = "Le client ne peut pas être nul")
    ClientDTO client,

    @NotNull(message = "L'ID de la chambre ne peut pas être nul")
    Long chambreId,

    @NotNull(message = "La date de début ne peut pas être nulle")
    @Future(message = "La date de début doit être dans le futur")
    LocalDate dateDebut,

    @NotNull(message = "La date de fin ne peut pas être nulle")
    @Future(message = "La date de fin doit être dans le futur")
    LocalDate dateFin,

    @Size(max = 255, message = "Les préférences ne peuvent pas dépasser 255 caractères")
    String preferences
) {
    
}