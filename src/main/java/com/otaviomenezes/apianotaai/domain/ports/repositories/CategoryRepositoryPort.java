package com.otaviomenezes.apianotaai.domain.ports.repositories;

import com.otaviomenezes.apianotaai.domain.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryRepositoryPort {
    void delete(Category category);

    List<Category> findAll();

    Category findById(String id);

    List<Category> findWithParams(String fields, String ownerId);

    Page<Category> findWithParams(String fields, String ownerId, int pageNumber, int pageSize);

    Category save(Category category);
}