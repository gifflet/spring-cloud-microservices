package dev.gifflet.springcloudmicroservices.creditassessments.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class CommunicationErrorException extends ResponseStatusException {

    public CommunicationErrorException(Integer status, String message) {
        super(HttpStatusCode.valueOf(status), message);
    }
}
