package com.otaviomenezes.apianotaai.domain;

import com.otaviomenezes.apianotaai.domain.dtos.CategoryDTO;
import com.otaviomenezes.apianotaai.domain.dtos.ProductDTO;

public class Product {
    private String id;

    private String title;

    private String description;

    private String ownerId;

    private Double price;

    private Category category;

    public Product(String id, String title, String description, String ownerId, Double price, Category category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ownerId = ownerId;
        this.price = price;
        this.category = category;
    }

    public ProductDTO toProductDTO() {
        return new ProductDTO(id, title, description, ownerId, price,
                new CategoryDTO(category.getId(), category.getTitle(), category.getDescription(), category.getOwnerId()));
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}