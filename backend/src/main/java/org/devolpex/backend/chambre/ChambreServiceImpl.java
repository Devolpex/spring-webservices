package org.devolpex.backend.chambre;

import java.util.List;

import org.devolpex.backend.chambre.dto.ChambreDTO;
import org.devolpex.backend.chambre.dto.ChambreReq;
import org.devolpex.backend.utils.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ChambreServiceImpl implements IService<ChambreDTO,ChambreReq>{

    @Override
    public ChambreDTO create(ChambreReq req) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ChambreDTO update(Long id, ChambreReq req) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ChambreDTO findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ChambreDTO> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Page<ChambreDTO> findAll(Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
