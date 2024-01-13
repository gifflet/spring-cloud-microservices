package dev.gifflet.springcloudmicroservices.creditassessments.controller;

import dev.gifflet.springcloudmicroservices.creditassessments.dto.AssessmentDataDto;
import dev.gifflet.springcloudmicroservices.creditassessments.dto.CustomerCardsDto;
import dev.gifflet.springcloudmicroservices.creditassessments.dto.CustomerEvaluationResponseDto;
import dev.gifflet.springcloudmicroservices.creditassessments.service.CreditAssessmentService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Performs a customer credit assessment based on the provided assessment data.
     *
     * @param  assessmentData  the data used for the credit assessment
     * @return                 the response containing the evaluation result
     */
    @PostMapping
    public ResponseEntity<CustomerEvaluationResponseDto> assessCustomerCredit(@RequestBody AssessmentDataDto assessmentData) {
        return ResponseEntity.ok().body(getCreditAssessmentService().assessCustomerCredit(assessmentData.getCpf(), assessmentData.getIncome()));
    }
}
