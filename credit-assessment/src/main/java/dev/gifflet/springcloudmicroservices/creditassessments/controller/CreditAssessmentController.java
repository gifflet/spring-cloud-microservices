package dev.gifflet.springcloudmicroservices.creditassessments.controller;

import dev.gifflet.springcloudmicroservices.creditassessments.dto.CustomerCardsDto;
import dev.gifflet.springcloudmicroservices.creditassessments.service.CreditAssessmentService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit-assessments")
@RequiredArgsConstructor
public class CreditAssessmentController {

    @Getter(AccessLevel.PRIVATE)
    private final CreditAssessmentService creditAssessmentService;

    /**
     * Retrieves the customer cards based on the provided CPF.
     *
     * @param  cpf  the customer's CPF
     * @return      the customer cards associated with the CPF
     */
    @GetMapping(value = "/customer-cards", params = "cpf")
    public ResponseEntity<CustomerCardsDto> getCustomerCards(@RequestParam("cpf") String cpf) {
        return ResponseEntity.ok().body(getCreditAssessmentService().getCustomerCards(cpf));
    }
}
