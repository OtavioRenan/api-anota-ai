package com.otaviomenezes.apianotaai.domain.adapters;

import com.otaviomenezes.apianotaai.domain.Category;
import com.otaviomenezes.apianotaai.domain.dtos.CategoryDTO;
import com.otaviomenezes.apianotaai.domain.exceptions.CategoryNotFound;
import com.otaviomenezes.apianotaai.domain.ports.interfaces.CategoryServicePort;
import com.otaviomenezes.apianotaai.domain.ports.repositories.CategoryRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CategoryServiceImp implements CategoryServicePort {
    private final CategoryRepositoryPort repository;

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
        List<CategoryDTO> categories = repository
            .findWithParams(inputs.get("fields"), inputs.get("ownerId"))
            .stream().map(Category::toCategoryDTO).collect(Collectors.toList());

        return ResponseEntity.ok().body(categories);
    }

    @Override
    public ResponseEntity<Page<CategoryDTO>> findAll(Map<String, String> inputs, int pageNumber, int pageSize) {
        Page<CategoryDTO> categories = repository
            .findWithParams(inputs.get("fields"),
            inputs.get("ownerId"), pageNumber, pageSize).map(Category::toCategoryDTO);

        return ResponseEntity.ok().body(categories);
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

        if(Objects.isNull(category.getId())) {
            throw  new CategoryNotFound();
        }

        return category;
    }
}
