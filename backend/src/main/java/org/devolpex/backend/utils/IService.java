package org.devolpex.backend.utils;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService <DTO,REQ> {

    DTO create(REQ req);

    DTO update(Long id, REQ req);

    void delete(Long id);

    DTO findById(Long id);

    List<DTO> findAll();

    Page<DTO> findAll(Pageable pageable);


}
