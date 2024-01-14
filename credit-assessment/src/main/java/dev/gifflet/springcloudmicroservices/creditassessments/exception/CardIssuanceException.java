package dev.gifflet.springcloudmicroservices.creditassessments.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class CardIssuanceException extends ResponseStatusException {

    public CardIssuanceException(String reason) {
        super(INTERNAL_SERVER_ERROR, reason);
    }
}
