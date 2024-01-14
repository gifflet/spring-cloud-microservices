package dev.gifflet.springcloudmicroservices.creditassessments.service;

import dev.gifflet.springcloudmicroservices.creditassessments.dto.CardIssuanceRequestDataDto;
import dev.gifflet.springcloudmicroservices.creditassessments.dto.CardRequestProtocolDto;
import dev.gifflet.springcloudmicroservices.creditassessments.dto.CustomerCardsDto;
import dev.gifflet.springcloudmicroservices.creditassessments.dto.CustomerEvaluationResponseDto;

public interface CreditAssessmentService {

    public CustomerCardsDto getCustomerCards(String cpf);

    public CustomerEvaluationResponseDto assessCustomerCredit(String cpf, Long income);

    public CardRequestProtocolDto requestCardIssuance(CardIssuanceRequestDataDto cardIssuanceRequest);
}
