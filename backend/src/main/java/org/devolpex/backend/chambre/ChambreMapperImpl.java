package org.devolpex.backend.chambre;

import org.devolpex.backend.chambre.dto.ChambreDto;
import org.devolpex.backend.chambre.dto.ChambreReq;
import org.devolpex.backend.utils.IMapper;
import org.springframework.stereotype.Component;

@Component
public class ChambreMapperImpl implements IMapper<Chambre, ChambreDto, ChambreReq>{
    @Override
    public ChambreDto toDTO(Chambre entity) {
        return ChambreDto.builder()
                .id(entity.getId())
                .type(entity.getType())
                .prix(entity.getPrix())
                .disponible(entity.getDisponible())
                .build();
    }

    @Override
    public Chambre toEntity(ChambreReq req) {
        return Chambre.builder()
                .type(req.getType())
                .prix(req.getPrix())
                .disponible(req.getDisponible())
                .build();
    }

    public Chambre toEntity(Chambre entity, ChambreReq req) {
        entity.setType(req.getType());
        entity.setPrix(req.getPrix());
        entity.setDisponible(req.getDisponible());
        return entity;
    }
}
