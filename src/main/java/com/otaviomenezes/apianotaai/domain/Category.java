package com.otaviomenezes.apianotaai.domain;

import com.otaviomenezes.apianotaai.domain.dtos.CategoryDTO;

public class Category {
    private String id;

    private String title;

    private String description;

    private String ownerId;

    public Category(String id, String title, String description, String ownerId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ownerId = ownerId;
    }

    public CategoryDTO toCategoryDTO() {
        return new CategoryDTO(id, title, description, ownerId);
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
