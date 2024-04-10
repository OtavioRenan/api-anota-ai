package com.otaviomenezes.apianotaai.infra.adapters.repositories;

import com.otaviomenezes.apianotaai.domain.Category;
import com.otaviomenezes.apianotaai.domain.ports.repositories.CategoryRepositoryPort;
import com.otaviomenezes.apianotaai.infra.adapters.entities.CategoryEntity;
import com.otaviomenezes.apianotaai.infra.adapters.mongo.CategoryMongoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public List<Category> findWithParams(String fields, String ownerId) {
        return toCategory(repository.findWithParams(fields, ownerId));
    }

    @Override
    public Page<Category> findWithParams(String fields, String ownerId, int pageNumber, int pageSize) {
        return repository.findWithParams(fields, ownerId, PageRequest.of(pageNumber, pageSize)).map(CategoryEntity::toCategory);
    }

    @Override
    public Category save(Category category) {
        return repository.save(new CategoryEntity(category)).toCategory();
    }

    private List<Category> toCategory(List<CategoryEntity> categories) {
        return categories.stream().map(CategoryEntity::toCategory).collect(Collectors.toList());
    }
}