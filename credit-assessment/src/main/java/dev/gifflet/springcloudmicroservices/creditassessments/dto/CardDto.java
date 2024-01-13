package dev.gifflet.springcloudmicroservices.creditassessments.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardDto {

    private String name;

    private String brand;

    private BigDecimal creditLimit;
}
