package com.otaviomenezes.apianotaai.domain.ports.interfaces;

import com.otaviomenezes.apianotaai.domain.dtos.ProductDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ProductServicePort {
    ResponseEntity<ProductDTO> delete(String id);

    ResponseEntity<List<ProductDTO>> findAll(Map<String, String> inputs);

    ResponseEntity<ProductDTO> findById(String id);

    ResponseEntity<ProductDTO> insert(ProductDTO product);

    ResponseEntity<ProductDTO> update(ProductDTO product, String id);
}
