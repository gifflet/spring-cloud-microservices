package dev.gifflet.springcloudmicroservices.creditassessments.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardIssuanceRequestDataDto {

    private long cardId;

    private String cpf;

    private String address;

    private BigDecimal creditLimit;
}
