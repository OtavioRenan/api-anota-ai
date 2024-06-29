package com.otaviomenezes.apianotaai.infra.adapters.repositories;

import com.otaviomenezes.apianotaai.domain.Category;
import com.otaviomenezes.apianotaai.domain.ports.repositories.CategoryRepositoryPort;
import com.otaviomenezes.apianotaai.infra.adapters.entities.CategoryEntity;
import com.otaviomenezes.apianotaai.infra.adapters.mongo.CategoryMongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryRepository implements CategoryRepositoryPort {
    private final CategoryMongoRepository repository;

    public CategoryRepository(CategoryMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void delete(Category category) {
        repository.delete(new CategoryEntity(category));
    }

    @Override
    public List<Category> findAll() {
        return toCategory(repository.findAll());
    }

    @Override
    public Category findById(String id) {
        return repository.findById(id).orElse(new CategoryEntity()).toCategory();
    }

    @Override
    public List<Category> findByOwnerId(String ownerId) {
        return toCategory(repository.findByOwnerId(ownerId));
    }

    @Override
    public Category save(Category category) {
        return repository.save(new CategoryEntity(category)).toCategory();
    }

    private List<Category> toCategory(List<CategoryEntity> categories) {
        return categories.stream().map(CategoryEntity::toCategory).toList();
    }
}