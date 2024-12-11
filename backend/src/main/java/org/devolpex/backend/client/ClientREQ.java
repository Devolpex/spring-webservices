package org.devolpex.backend.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.springframework.format.annotation.NumberFormat;

@Builder
public record ClientREQ(
        @NotNull(message = "Le nom ne peut pas être nul")
        String nom,
        @NotNull(message = "Le prénom ne peut pas être nul")
        String prenom,
        @NotNull(message = "L'email ne peut pas être nul")
        @Email(message = "L'email doit être valide")
        String email,
        @NotNull(message = "Le téléphone ne peut pas être nul")
        String telephone) {
}
