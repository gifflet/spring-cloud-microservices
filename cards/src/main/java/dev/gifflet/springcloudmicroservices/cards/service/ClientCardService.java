package dev.gifflet.springcloudmicroservices.cards.service;

import dev.gifflet.springcloudmicroservices.cards.domain.ClientCard;

import java.util.List;

public interface ClientCardService {

    List<ClientCard> getByCpf(String cpf);
}
