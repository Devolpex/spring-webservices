package org.devolpex.backend.reservation;

import java.time.format.DateTimeFormatter;

import org.devolpex.backend.reservation.dto.ChambreDTO;
import org.devolpex.backend.reservation.dto.ClientDTO;
import org.devolpex.backend.reservation.dto.ReservationDTO;
import org.devolpex.backend.stubs.chambre.Chambre;
import org.devolpex.backend.stubs.client.Client;
import org.devolpex.backend.stubs.reservation.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationGrpcMapper {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    // Convert a ReservationDTO to a Reservation Proto
    public Reservation toProto(ReservationDTO dto) {
        return Reservation.newBuilder()
                .setId(dto.getId())
                .setClient(this.toProto(dto.getClient()))
                .setChambre(this.toProto(dto.getChambre()))
                .setDateDebut(dto.getDateDebut().format(DATE_FORMATTER))
                .setDateFin(dto.getDateFin().format(DATE_FORMATTER))
                .setPreferences(dto.getPreferences() == null ? "" : dto.getPreferences())
                .build();
    }

    // Private method to convert a ClientDTO to a Client Proto
    private Client toProto(ClientDTO clientDTO) {
        if (clientDTO == null) {
            return null;
        }
        return Client.newBuilder()
                .setId(clientDTO.getId())
                .setNom(clientDTO.getNom())
                .setPrenom(clientDTO.getPrenom())
                .setEmail(clientDTO.getEmail())
                .setTelephone(clientDTO.getTelephone())
                .build();
    }

    // Private method to convert a ChambreDTO to a Chambre Proto
    private Chambre toProto(ChambreDTO dto) {
        if (dto == null) {
            return null;
        }
        return Chambre.newBuilder()
                .setId(dto.getId())
                .setType(dto.getType())
                .setPrix(dto.getPrix().floatValue())
                .setDisponible(dto.getDisponible())
                .build();
    }

}
