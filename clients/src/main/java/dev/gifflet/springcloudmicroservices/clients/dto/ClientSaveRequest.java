package dev.gifflet.springcloudmicroservices.clients.dto;

import lombok.Data;

@Data
public class ClientSaveRequest {

    private String cpf;

    private String name;

    private Integer age;
}
