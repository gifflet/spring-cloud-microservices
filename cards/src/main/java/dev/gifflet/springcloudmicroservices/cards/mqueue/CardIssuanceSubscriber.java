package dev.gifflet.springcloudmicroservices.cards.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.gifflet.springcloudmicroservices.cards.domain.Card;
import dev.gifflet.springcloudmicroservices.cards.domain.ClientCard;
import dev.gifflet.springcloudmicroservices.cards.dto.CardIssuanceRequestDataDto;
import dev.gifflet.springcloudmicroservices.cards.dto.ClientCardResponse;
import dev.gifflet.springcloudmicroservices.cards.repository.CardRepository;
import dev.gifflet.springcloudmicroservices.cards.repository.ClientCardRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardIssuanceSubscriber {

    @Getter(AccessLevel.PRIVATE)
    private final CardRepository cardRepository;

    @Getter(AccessLevel.PRIVATE)
    private final ClientCardRepository clientCardRepository;

    @RabbitListener(queues = "${mq.queues.card-issuance}")
    public void receiveCardIssuanceEvent(@Payload String payload) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            CardIssuanceRequestDataDto cardIssuanceRequest = objectMapper.readValue(payload, CardIssuanceRequestDataDto.class);
            Card card = getCardRepository().findById(cardIssuanceRequest.getCardId()).orElseThrow();

            getClientCardRepository().save(ClientCard.builder()
                    .card(card)
                    .cpf(cardIssuanceRequest.getCpf())
                    .creditLimit(cardIssuanceRequest.getCreditLimit())
                    .build());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}