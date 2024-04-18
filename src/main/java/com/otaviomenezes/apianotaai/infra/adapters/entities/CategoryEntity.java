package com.otaviomenezes.apianotaai.infra.adapters.entities;

import com.otaviomenezes.apianotaai.domain.Category;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categories")
public class CategoryEntity {
    @Id
    private String id;

    @NotBlank(message = "O título é obrigatório.")
    private String title;

    @NotBlank(message = "A descrição é obrigatória.")
    private String description;

    @NotBlank(message = "O proprietário é obrigatório.")
    private String ownerId;

    public CategoryEntity(){}

    public CategoryEntity(Category category) {
        id = category.getId();
        title = category.getTitle();
        description = category.getDescription();
        ownerId = category.getOwnerId();
    }

    public Category toCategory() {
        return new Category(this);
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
