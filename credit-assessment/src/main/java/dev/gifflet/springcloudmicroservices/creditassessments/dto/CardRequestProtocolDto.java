package dev.gifflet.springcloudmicroservices.creditassessments.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CardRequestProtocolDto {

    private final String protocol;
}
