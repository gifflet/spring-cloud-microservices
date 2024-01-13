package dev.gifflet.springcloudmicroservices.creditassessments.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ApprovedCardDto {

    private String name;

    private String brand;

    private BigDecimal creditLimit;
}
