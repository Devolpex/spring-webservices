package org.devolpex.backend.reservation;

import org.devolpex.backend.chambre.ChambreDTO;
import org.devolpex.backend.client.ClientDTO;
import org.devolpex.backend.utils.IMapper;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapperImpl implements IMapper<Reservation, ReservationDTO, ReservationREQ> {

    @Override
    public ReservationDTO toDTO(Reservation entity) {
        ClientDTO client = ClientDTO.builder()
                .id(entity.getClient().getId())
                .nom(entity.getClient().getNom())
                .prenom(entity.getClient().getPrenom())
                .email(entity.getClient().getEmail())
                .telephone(entity.getClient().getTelephone())
                .build();

        ChambreDTO chambre = ChambreDTO.builder()
                .id(entity.getChambre().getId())
                .type(entity.getChambre().getType())
                .prix(entity.getChambre().getPrix())
                .build();
        return ReservationDTO.builder()
                .id(entity.getId())
                .client(client)
                .chambre(chambre)
                .dateDebut(entity.getDateDebut())
                .dateFin(entity.getDateFin())
                .preferences(entity.getPreferences())
                .build();
    }

    @Override
    public Reservation toEntity(ReservationREQ req) {
        return null;
        // return Reservation.builder()
        // .client(req.getClient())
        // .chambre(req.getChambre())
        // .dateDebut(req.getDateDebut())
        // .dateFin(req.getDateFin())
        // .preferences(req.getPreferences())
        // .build();
    }

    @Override
    public Reservation toEntity(Reservation entity, ReservationREQ req) {
        return null;
        // entity.setClient(req.getClient());
        // entity.setChambre(req.getChambre());
        // entity.setDateDebut(req.getDateDebut());
        // entity.setDateFin(req.getDateFin());
        // entity.setPreferences(req.getPreferences());
        // return entity;
    }

}
