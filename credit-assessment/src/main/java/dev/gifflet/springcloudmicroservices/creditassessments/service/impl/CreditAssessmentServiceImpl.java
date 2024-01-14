package dev.gifflet.springcloudmicroservices.creditassessments.service.impl;

import dev.gifflet.springcloudmicroservices.creditassessments.client.CardResourceClient;
import dev.gifflet.springcloudmicroservices.creditassessments.client.ClientResourceClient;
import dev.gifflet.springcloudmicroservices.creditassessments.dto.*;
import dev.gifflet.springcloudmicroservices.creditassessments.exception.CardIssuanceException;
import dev.gifflet.springcloudmicroservices.creditassessments.exception.ClientNotFoundException;
import dev.gifflet.springcloudmicroservices.creditassessments.exception.CommunicationErrorException;
import dev.gifflet.springcloudmicroservices.creditassessments.mqueue.CardIssuanceRequestPublisher;
import dev.gifflet.springcloudmicroservices.creditassessments.service.CreditAssessmentService;
import feign.FeignException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreditAssessmentServiceImpl implements CreditAssessmentService {

    @Getter(AccessLevel.PRIVATE)
    private final ClientResourceClient clientResourceClient;

    @Getter(AccessLevel.PRIVATE)
    private final CardResourceClient cardResourceClient;

    @Getter(AccessLevel.PRIVATE)
    private final CardIssuanceRequestPublisher cardIssuanceRequestPublisher;

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

    @Override
    public CustomerEvaluationResponseDto assessCustomerCredit(String cpf, Long income) {
        try {
            ResponseEntity<CustomerDto> clientResponse = getClientResourceClient().findByCpf(cpf);
            ResponseEntity<List<CardDto>> cardsResponse = getCardResourceClient().getCardsWithIncomeLowerThan(income);

            List<ApprovedCardDto> approvedCards = cardsResponse.getBody().stream()
                    .map(card -> mapCardDtoToApprovedCardDto(clientResponse.getBody(), card))
                    .toList();

            return new CustomerEvaluationResponseDto(approvedCards);
        } catch (FeignException.FeignClientException e) {
            if(e.status() == 404) {
                throw new ClientNotFoundException();
            }
            throw new CommunicationErrorException(e.status(), e.getMessage());
        }
    }

    private ApprovedCardDto mapCardDtoToApprovedCardDto(CustomerDto customerDto, CardDto cardDto) {
        BigDecimal creditLimit = cardDto.getCreditLimit();
        BigDecimal customerAge = new BigDecimal(customerDto.getAge());

        BigDecimal approvedCreditLimit = customerAge.divide(BigDecimal.valueOf(10)).multiply(creditLimit);

        return ApprovedCardDto.builder()
                .name(cardDto.getName())
                .brand(cardDto.getBrand())
                .creditLimit(approvedCreditLimit)
                .build();
    }

    @Override
    public CardRequestProtocolDto requestCardIssuance(CardIssuanceRequestDataDto cardIssuanceRequest) {
        try {
            cardIssuanceRequestPublisher.requestCard(cardIssuanceRequest);
            return new CardRequestProtocolDto(UUID.randomUUID().toString());
        } catch (Exception e) {
            throw new CardIssuanceException(e.getMessage());
        }
    }
}
