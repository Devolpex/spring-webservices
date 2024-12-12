package org.devolpex.backend.chambre;

import java.util.List;

import org.devolpex.backend.chambre.dto.ChambreDto;
import org.devolpex.backend.chambre.dto.ChambreReq;
import org.devolpex.backend.utils.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ChambreServiceImpl implements IService<ChambreDto,ChambreReq>{

    @Override
    public ChambreDto create(ChambreReq req) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ChambreDto update(Long id, ChambreReq req) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ChambreDto findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ChambreDto> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Page<ChambreDto> findAll(Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
