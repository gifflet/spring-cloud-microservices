package dev.gifflet.springcloudmicroservices.creditassessments.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerCardsDto {

    private CustomerDto customer;

    private List<CardDto> cards;
}
