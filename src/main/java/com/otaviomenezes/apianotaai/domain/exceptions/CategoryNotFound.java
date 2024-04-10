package com.otaviomenezes.apianotaai.domain.exceptions;

import org.springframework.http.HttpStatus;

public class CategoryNotFound extends RuntimeException {
    private final HttpStatus statusCode;

    public CategoryNotFound() {
        super("Categoria não encontrada.");
        statusCode = HttpStatus.NOT_FOUND;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
