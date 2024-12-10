package org.devolpex.backend.utils;

public interface IMapper<E, DTO, REQ> {

    DTO toDTO(E entity);

    E toEntity(REQ req);

    E toEntity(E entity, REQ req);

}
