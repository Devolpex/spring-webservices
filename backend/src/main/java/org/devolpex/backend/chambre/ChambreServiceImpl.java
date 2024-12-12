package org.devolpex.backend.chambre;

import java.util.List;

import org.devolpex.backend.chambre.dto.ChambreDto;
import org.devolpex.backend.chambre.dto.ChambreReq;
import org.devolpex.backend.handler.OwnException;
import org.devolpex.backend.utils.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChambreServiceImpl implements IService<ChambreDto,ChambreReq>{
    private final ChambreRepository chambreRepository;
    private final ChambreMapperImpl chambreMapper;

    @Override
    public ChambreDto create(ChambreReq req) {
        Chambre chambre = chambreMapper.toEntity(req);
        return chambreMapper.toDTO(chambreRepository.save(chambre));               
    }

    @Override
    public ChambreDto update(Long id, ChambreReq req) {
        Chambre chambre = chambreRepository.findById(id)
                .orElseThrow(() -> {
                    // log.error("Chambre non trouvée.");
                    return new OwnException("Chambre non trouvée.", HttpStatus.NOT_FOUND);
                });
        return chambreMapper.toDTO(chambreRepository.save(chambre));
    }

    @Override
    public void delete(Long id) {
        chambreRepository.findById(id)
                .ifPresentOrElse(chambreRepository::delete, () -> {
                    // log.error("Réservation non trouvée.");
                    throw new OwnException("Chambre non trouvée.", HttpStatus.NOT_FOUND);
                });
    }

    @Override
    public ChambreDto findById(Long id) {
        return chambreRepository.findById(id)
                .map(chambreMapper::toDTO)
                .orElseThrow(() -> {
                    // log.error("Chambre non trouvée.");
                    return new OwnException("Chambre non trouvée.", HttpStatus.NOT_FOUND);
                });
    }

    @Override
    public List<ChambreDto> findAll() {
        return chambreRepository.findAll().stream()
                .map(chambreMapper::toDTO)
                .toList();
    }

    @Override
    public Page<ChambreDto> findAll(Pageable pageable) {
        return chambreRepository.findAll(pageable)
                .map(chambreMapper::toDTO);
    }
}
