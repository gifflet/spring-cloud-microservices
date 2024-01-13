package dev.gifflet.springcloudmicroservices.creditassessments.service;

import dev.gifflet.springcloudmicroservices.creditassessments.dto.CustomerCardsDto;

public interface CreditAssessmentService {

    public CustomerCardsDto getCustomerCards(String cpf);
}
