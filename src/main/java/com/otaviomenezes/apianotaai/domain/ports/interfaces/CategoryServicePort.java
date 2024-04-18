package com.otaviomenezes.apianotaai.domain.ports.interfaces;

import com.otaviomenezes.apianotaai.domain.dtos.CategoryDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface CategoryServicePort {
    ResponseEntity<CategoryDTO> delete(String id);

    ResponseEntity<List<CategoryDTO>> findAll(Map<String, String> inputs);

    ResponseEntity<CategoryDTO> findById(String id);

    ResponseEntity<CategoryDTO> insert(CategoryDTO category);

    ResponseEntity<CategoryDTO> update(CategoryDTO category, String id);
}