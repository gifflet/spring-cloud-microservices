package dev.gifflet.springcloudmicroservices.creditassessments.exception;

import org.springframework.web.server.ResponseStatusException;

public class ClientNotFoundException extends ResponseStatusException {

    public ClientNotFoundException() {
        super(org.springframework.http.HttpStatus.NOT_FOUND, "Client not found");
    }
}
