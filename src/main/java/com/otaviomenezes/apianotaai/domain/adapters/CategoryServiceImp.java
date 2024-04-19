package com.otaviomenezes.apianotaai.domain.adapters;

import com.otaviomenezes.apianotaai.domain.Category;
import com.otaviomenezes.apianotaai.domain.dtos.CategoryDTO;
import com.otaviomenezes.apianotaai.domain.exceptions.CategoryNotFoundException;
import com.otaviomenezes.apianotaai.domain.ports.interfaces.CategoryServicePort;
import com.otaviomenezes.apianotaai.domain.ports.repositories.CategoryRepositoryPort;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CategoryServiceImp implements CategoryServicePort {
    private final CategoryRepositoryPort repository;

    private static final String[] FIELDS = {"ownerId"};

    public CategoryServiceImp(CategoryRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<CategoryDTO> delete(String id) {
        repository.delete(findCategoryById(id));

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> findAll(Map<String, String> inputs) {
        List<Category> categories;

        if(checkInputs(inputs)) {
            categories = repository.findByOwnerId(inputs.get(FIELDS[0]));
        } else {
            categories = repository.findAll();
        }

        return ResponseEntity.ok().body(toCategoryDTO(categories));
    }

    @Override
    public ResponseEntity<CategoryDTO> findById(String id) {
        return ResponseEntity.ok().body(findCategoryById(id).toCategoryDTO());
    }

    @Override
    public ResponseEntity<CategoryDTO> insert(CategoryDTO category) {
        Category insert = new Category(category);

        insert = repository.save(insert);

        return ResponseEntity.ok().body(insert.toCategoryDTO());
    }

    @Override
    public ResponseEntity<CategoryDTO> update(CategoryDTO category, String id) {
        Category update = new Category(category);
        update.setId(id);

        update = repository.save(update);

        return ResponseEntity.ok().body(update.toCategoryDTO());
    }

    private Category findCategoryById(String id) {
        Category category = repository.findById(id);

        checkIfCategoryExists(category);

        return category;
    }

    private void checkIfCategoryExists(Category category) {
        if(Objects.isNull(category.getId())) throw new CategoryNotFoundException();
    }

    private List<CategoryDTO> toCategoryDTO(List<Category> categories) {
        return categories.stream().map(Category::toCategoryDTO).collect(Collectors.toList());
    }

    private boolean checkInputs(Map<String, String> inputs) {
        String ownerId = inputs.get(FIELDS[0]);

        return !Objects.isNull(ownerId) && !(ownerId.isEmpty() && ownerId.isBlank());
    }
}
