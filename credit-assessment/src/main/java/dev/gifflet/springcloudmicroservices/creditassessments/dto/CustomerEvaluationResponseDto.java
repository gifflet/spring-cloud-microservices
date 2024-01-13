package dev.gifflet.springcloudmicroservices.creditassessments.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEvaluationResponseDto {

    private List<ApprovedCardDto> cards;
}
