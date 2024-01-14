package dev.gifflet.springcloudmicroservices.creditassessments.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.gifflet.springcloudmicroservices.creditassessments.dto.CardIssuanceRequestDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardIssuanceRequestPublisher {

    private final RabbitTemplate rabbitTemplate;

    private final Queue queueCardIssuance;

    public void requestCard(CardIssuanceRequestDataDto cardIssuanceRequest) throws JsonProcessingException {
        rabbitTemplate.convertAndSend(queueCardIssuance.getName(), cardIssuanceRequestToString(cardIssuanceRequest));
    }

    private String cardIssuanceRequestToString(CardIssuanceRequestDataDto cardIssuanceRequest) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(cardIssuanceRequest);
    }
}
