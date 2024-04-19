package com.otaviomenezes.apianotaai.domain.validations;

import com.otaviomenezes.apianotaai.domain.Category;
import com.otaviomenezes.apianotaai.domain.exceptions.RequiredFieldException;

import java.util.Objects;

public class Required {
    public String check(String value) {
        if(Objects.isNull(value) || value.isEmpty() || value.isBlank())
            throw new RequiredFieldException();

        return value;
    }

    public Long check(Long value) {
        if(Objects.isNull(value))
            throw new RequiredFieldException();

        return value;
    }

    public Category check(Category value) {
        if(Objects.isNull(value))
            throw new RequiredFieldException();

        return value;
    }
}