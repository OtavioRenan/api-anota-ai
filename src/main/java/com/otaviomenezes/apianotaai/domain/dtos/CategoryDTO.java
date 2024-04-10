package com.otaviomenezes.apianotaai.domain.dtos;

import com.otaviomenezes.apianotaai.domain.Category;

public class CategoryDTO {
    private String id;

    private String title;

    private String description;

    private String ownerId;

    public CategoryDTO() {}

    public CategoryDTO(Category category) {
        id = category.getId();
        title = category.getTitle();
        description = category.getDescription();
        ownerId = category.getOwnerId();
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