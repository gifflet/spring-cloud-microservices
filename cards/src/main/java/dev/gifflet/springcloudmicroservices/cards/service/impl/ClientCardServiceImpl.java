package dev.gifflet.springcloudmicroservices.cards.service.impl;

import dev.gifflet.springcloudmicroservices.cards.domain.ClientCard;
import dev.gifflet.springcloudmicroservices.cards.repository.ClientCardRepository;
import dev.gifflet.springcloudmicroservices.cards.service.ClientCardService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCardServiceImpl implements ClientCardService {

    @Getter(AccessLevel.PRIVATE)
    private final ClientCardRepository clientCardRepository;

    @Override
    public List<ClientCard> getByCpf(String cpf) {
        return getClientCardRepository().findByCpf(cpf);
    }
}
