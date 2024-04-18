package com.otaviomenezes.apianotaai.domain.ports.repositories;

import com.otaviomenezes.apianotaai.domain.Category;

import java.util.List;

public interface CategoryRepositoryPort {
    void delete(Category category);

    List<Category> findAll();

    Category findById(String id);

    List<Category> findByOwnerId(String ownerId);

    Category save(Category category);
}