package com.otaviomenezes.apianotaai.domain;

import com.otaviomenezes.apianotaai.domain.dtos.CategoryDTO;
import com.otaviomenezes.apianotaai.infra.adapters.entities.CategoryEntity;

public class Category {
    private String id;

    private String title;

    private String description;

    private String ownerId;

    public Category(CategoryDTO category) {
        id = category.getId();
        title = category.getTitle();
        description = category.getDescription();
        ownerId = category.getOwnerId();
    }

    public Category(CategoryEntity category) {
        id = category.getId();
        title = category.getTitle();
        description = category.getDescription();
        ownerId = category.getOwnerId();
    }

    public CategoryDTO toCategoryDTO() {
        return new CategoryDTO(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
