package com.otaviomenezes.apianotaai.domain.exceptions;

import org.springframework.http.HttpStatus;

public class CategoryNotFoundException extends RuntimeException {
    private static final HttpStatus statusCode = HttpStatus.NOT_FOUND;

    public CategoryNotFoundException() {
        super("Categoria não encontrada.");
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}