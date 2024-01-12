package dev.gifflet.springcloudmicroservices.cards.dto;

import dev.gifflet.springcloudmicroservices.cards.domain.CardBrand;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardSaveRequest {

    private String name;
    private CardBrand brand;
    private BigDecimal income;
    private BigDecimal creditLimit;
}
