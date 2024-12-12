package org.devolpex.backend.client;

import org.devolpex.backend.client.dto.ChambreDTO;
import org.devolpex.backend.client.dto.ClientDTO;
import org.devolpex.backend.client.dto.ReservationDTO;
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
                .reservations(entity.getReservations().stream().map(this::mapToReservationDTO).toList())
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
    // @Override
    // public Client toEntity(Client entity, ClientREQ req) {
    // entity.setNom(req.getNom());
    // entity.setPrenom(req.getPrenom());
    // entity.setEmail(req.getEmail());
    // entity.setTelephone(req.getTelephone());
    // return entity;
    // }

}
