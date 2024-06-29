package com.otaviomenezes.apianotaai.controllers;

import com.otaviomenezes.apianotaai.domain.dtos.ProductDTO;
import com.otaviomenezes.apianotaai.domain.ports.interfaces.ProductServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/product")
public class ProductController {
    private final ProductServicePort service;

    public ProductController(ProductServicePort service) {
        this.service = service;
    }

    @DeleteMapping
    public ResponseEntity<ProductDTO> delete(String id) {
        return service.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(@RequestParam Map<String, String> inputs) {
        return service.findAll(inputs);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO product) {
        return service.insert(product);
    }

    @PutMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO product, String id) {
        return service.update(product, id);
    }
}