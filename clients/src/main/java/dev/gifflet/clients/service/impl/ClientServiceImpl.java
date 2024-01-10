package dev.gifflet.clients.service.impl;

import dev.gifflet.clients.domain.Client;
import dev.gifflet.clients.repository.ClientRepository;
import dev.gifflet.clients.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findByCpf(String cpf) {
        return clientRepository.findByCpf(cpf)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
