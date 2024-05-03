package com.otaviomenezes.apianotaai.infra.configs;

import com.otaviomenezes.apianotaai.domain.exceptions.CategoryNotFoundException;
import com.otaviomenezes.apianotaai.domain.exceptions.ProductNotFoundException;
import com.otaviomenezes.apianotaai.domain.exceptions.RequiredFieldException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CategoryNotFoundException.class)
    public ErrorResponse handleNoRecordFoundException(CategoryNotFoundException ex) {
        return ErrorResponse.create(ex, ex.getStatusCode(), ex.getMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponse handleNoRecordFoundException(ProductNotFoundException ex) {
        return ErrorResponse.create(ex, ex.getStatusCode(), ex.getMessage());
    }

    @ExceptionHandler(RequiredFieldException.class)
    public ErrorResponse handleNoRecordFoundException(RequiredFieldException ex) {
        return ErrorResponse.create(ex, ex.getStatusCode(), ex.getMessage());
    }
}
