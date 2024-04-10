package com.otaviomenezes.apianotaai.domain.exceptions;

import org.springframework.http.HttpStatus;

public class ProductNotFound extends RuntimeException {
    private final HttpStatus statusCode;

    public ProductNotFound() {
        super("Produto não encontrado.");
        statusCode = HttpStatus.NOT_FOUND;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}