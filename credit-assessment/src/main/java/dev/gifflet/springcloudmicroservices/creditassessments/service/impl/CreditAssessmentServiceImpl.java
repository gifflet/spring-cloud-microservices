package dev.gifflet.springcloudmicroservices.creditassessments.service.impl;

import dev.gifflet.springcloudmicroservices.creditassessments.client.CardResourceClient;
import dev.gifflet.springcloudmicroservices.creditassessments.client.ClientResourceClient;
import dev.gifflet.springcloudmicroservices.creditassessments.dto.CardDto;
import dev.gifflet.springcloudmicroservices.creditassessments.dto.CustomerDto;
import dev.gifflet.springcloudmicroservices.creditassessments.dto.CustomerCardsDto;
import dev.gifflet.springcloudmicroservices.creditassessments.exception.ClientNotFoundException;
import dev.gifflet.springcloudmicroservices.creditassessments.exception.CommunicationErrorException;
import dev.gifflet.springcloudmicroservices.creditassessments.service.CreditAssessmentService;
import feign.FeignException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditAssessmentServiceImpl implements CreditAssessmentService {

    @Getter(AccessLevel.PRIVATE)
    private final ClientResourceClient clientResourceClient;

    @Getter(AccessLevel.PRIVATE)
    private final CardResourceClient cardResourceClient;

    @Override
    public CustomerCardsDto getCustomerCards(String cpf) {
        try {
            ResponseEntity<CustomerDto> clientResponse = getClientResourceClient().findByCpf(cpf);
            ResponseEntity<List<CardDto>> cardsResponse = getCardResourceClient().findByCpf(cpf);
            return CustomerCardsDto.builder()
                    .customer(clientResponse.getBody())
                    .cards(cardsResponse.getBody())
                    .build();
        } catch (FeignException.FeignClientException e) {
            if(e.status() == 404) {
                throw new ClientNotFoundException();
            }
            throw new CommunicationErrorException(e.status(), e.getMessage());
        }
    }
}
