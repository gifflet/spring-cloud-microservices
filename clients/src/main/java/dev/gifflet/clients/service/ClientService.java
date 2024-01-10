package dev.gifflet.clients.service;

import dev.gifflet.clients.domain.Client;

import java.util.Optional;

public interface ClientService {

    Client save (Client client);

    Client findByCpf(String cpf);
}
