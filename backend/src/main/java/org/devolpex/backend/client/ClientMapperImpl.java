package org.devolpex.backend.client;

import org.devolpex.backend.utils.IMapper;
import org.springframework.stereotype.Component;

@Component
public class ClientMapperImpl implements IMapper<Client, ClientDTO, ClientREQ>{

    @Override
    public ClientDTO toDTO(Client entity) {
        return ClientDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .email(entity.getEmail())
                .telephone(entity.getTelephone())
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

//    @Override
//    public Client toEntity(Client entity, ClientREQ req) {
//        entity.setNom(req.getNom());
//        entity.setPrenom(req.getPrenom());
//        entity.setEmail(req.getEmail());
//        entity.setTelephone(req.getTelephone());
//        return entity;
//    }

}
