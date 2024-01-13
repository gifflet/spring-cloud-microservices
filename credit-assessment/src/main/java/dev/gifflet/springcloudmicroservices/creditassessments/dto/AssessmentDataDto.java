package dev.gifflet.springcloudmicroservices.creditassessments.dto;

import lombok.Data;

@Data
public class AssessmentDataDto {

    private String cpf;

    private Long income;
}
