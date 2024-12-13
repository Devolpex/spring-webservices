package org.devolpex.backend.client;

import org.devolpex.backend.client.dto.ChambreDTO;
import org.devolpex.backend.client.dto.ClientDTO;
import org.devolpex.backend.client.dto.ReservationDTO;
import org.devolpex.backend.client.http.ClientXMLREQ;
import org.devolpex.backend.reservation.Reservation;
import org.devolpex.backend.utils.IMapper;
import org.springframework.stereotype.Component;

@Component
public class ClientMapperImpl implements IMapper<Client, ClientDTO, ClientREQ> {

    @Override
    public ClientDTO toDTO(Client entity) {
        if (entity == null) {
            return null;
        }
        return ClientDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .email(entity.getEmail())
                .telephone(entity.getTelephone())
                // reservaiton is empty
                .reservations(entity.getReservations() == null
                        ? null
                        : entity.getReservations().stream().map(this::mapToReservationDTO).toList())
                .build();
    }

    @Override
    public Client toEntity(ClientREQ req) {
        return Client.builder()
                .nom(req.nom())
                .prenom(req.prenom())
                .email(req.email())
                .telephone(req.telephone())
                .build();
    }

    private ReservationDTO mapToReservationDTO(Reservation entity) {
        ChambreDTO chambre = ChambreDTO.builder()
                .id(entity.getChambre().getId())
                .type(entity.getChambre().getType())
                .disponible(entity.getChambre().getDisponible())
                .prix(entity.getChambre().getPrix())
                .build();
        return ReservationDTO.builder()
                .id(entity.getId())
                .dateDebut(entity.getDateDebut())
                .dateFin(entity.getDateFin())
                .preferences(entity.getPreferences())
                .chambre(chambre)
                .build();
    }

    /**
     * Method to transform form XML request to default request object (record)
     */

    public ClientREQ toRequest(ClientXMLREQ xml) {
        return ClientREQ.builder()
                .nom(xml.getNom())
                .prenom(xml.getPrenom())
                .email(xml.getEmail())
                .telephone(xml.getTelephone())
                .build();
    }

}
