package com.otaviomenezes.apianotaai.domain.exceptions;

import org.springframework.http.HttpStatus;

public class RequiredFieldException extends RuntimeException {

    private static final HttpStatus statusCode = HttpStatus.CONFLICT;

    public RequiredFieldException() {
        super("Algum campo obrigatório não foi preenchido.");
    }

    public RequiredFieldException(String message) {
        super(message);
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

}
