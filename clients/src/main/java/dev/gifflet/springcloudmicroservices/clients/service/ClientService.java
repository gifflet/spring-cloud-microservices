package dev.gifflet.springcloudmicroservices.clients.service;

import dev.gifflet.springcloudmicroservices.clients.domain.Client;

public interface ClientService {

    Client save (Client client);

    Client findByCpf(String cpf);

    Boolean existsByCpf(String cpf);
}
