package org.devolpex.backend.client;

import lombok.RequiredArgsConstructor;

import org.devolpex.backend.client.dto.ClientDTO;
import org.devolpex.backend.utils.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ClientServiceImpl implements IService<ClientDTO, ClientREQ> {

    private final ClientRepository clientRepository;
    private final ClientMapperImpl clientMapper;


    @Override
    public ClientDTO create(ClientREQ req) {
        Client client = clientMapper.toEntity(req);
        clientRepository.findByEmail(client.getEmail()).ifPresent(c -> {
            throw new RuntimeException("Client already exists");
        });
        client = clientRepository.save(client); 
        return clientMapper.toDTO(client);
    }

    @Override
    public ClientDTO update(Long id, ClientREQ req) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        client = clientMapper.toEntity(req);
        client.setId(id);  // Ensure the ID is set before saving
        client = clientRepository.save(client);
        return clientMapper.toDTO(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        return clientMapper.toDTO(client);
    }

    @Override
    public List<ClientDTO> findAll() {
        return clientRepository.findAll().stream().map(clientMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<ClientDTO> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable).map(clientMapper::toDTO);
    }
}
