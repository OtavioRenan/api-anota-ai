package com.otaviomenezes.apianotaai.domain.ports.interfaces;

import com.otaviomenezes.apianotaai.domain.dtos.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface CategoryServicePort {
    ResponseEntity<CategoryDTO> delete(String id);

    ResponseEntity<List<CategoryDTO>> findAll(Map<String, String> inputs);

    ResponseEntity<Page<CategoryDTO>> findAll(Map<String, String> inputs, int pageNumber, int pageSize);

    ResponseEntity<CategoryDTO> findById(String id);

    ResponseEntity<CategoryDTO> insert(CategoryDTO category);

    ResponseEntity<CategoryDTO> update(CategoryDTO category, String id);
}