package dev.gifflet.springcloudmicroservices.cards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientCardResponse {

    private String name;

    private String brand;

    private BigDecimal creditLimit;
}
