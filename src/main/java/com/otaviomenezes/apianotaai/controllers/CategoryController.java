package com.otaviomenezes.apianotaai.controllers;

import com.otaviomenezes.apianotaai.domain.dtos.CategoryDTO;
import com.otaviomenezes.apianotaai.domain.ports.interfaces.CategoryServicePort;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryServicePort service;

    public CategoryController(CategoryServicePort service) {
        this.service = service;
    }

    @DeleteMapping
    public ResponseEntity<CategoryDTO> delete(String id) {
        return service.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(@RequestParam Map<String, String> inputs) {
        return service.findAll(inputs);
    }

    @GetMapping("/page/{pageNumber}/{pageSize}")
    public ResponseEntity<Page<CategoryDTO>> findAll(@RequestParam Map<String, String> inputs, @PathVariable int pageNumber, @PathVariable int pageSize) {
        return service.findAll(inputs, pageNumber, pageSize);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO category) {
        return service.insert(category);
    }

}
