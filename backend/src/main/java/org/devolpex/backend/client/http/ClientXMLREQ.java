package org.devolpex.backend.client.http;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
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
public class ClientXMLREQ {
    @NotNull(message = "Le nom ne peut pas être nul")
    private String nom;
    @NotNull(message = "Le prénom ne peut pas être nul")
    private String prenom;
    @NotNull(message = "L'email ne peut pas être nul")
    @Email(message = "L'email doit être valide")
    private String email;
    @NotNull(message = "Le téléphone ne peut pas être nul")
    private String telephone;
}
