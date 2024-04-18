package com.otaviomenezes.apianotaai.domain.ports.repositories;

import com.otaviomenezes.apianotaai.domain.Product;

import java.util.List;

public interface ProductRepositoryPort {
    void delete(Product product);

    List<Product> findAll();

    Product findById(String id);

    List<Product> findByOwnerId(String ownerId);

    Product save(Product product);
}