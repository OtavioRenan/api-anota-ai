package com.otaviomenezes.apianotaai.domain.exceptions;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends RuntimeException {
    private static final HttpStatus statusCode = HttpStatus.NOT_FOUND;

    public ProductNotFoundException() {
        super("Produto não encontrado.");
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}