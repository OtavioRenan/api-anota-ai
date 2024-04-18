package com.otaviomenezes.apianotaai.domain;

import com.otaviomenezes.apianotaai.domain.dtos.ProductDTO;
import com.otaviomenezes.apianotaai.infra.adapters.entities.ProductEntity;

public class Product {
    private String id;

    private String title;

    private String description;

    private String ownerId;

    private Double price;

    private Category category;

    public Product(ProductEntity product) {
        id = product.getId();
        title = product.getTitle();
        description = product.getDescription();
        ownerId = product.getOwnerId();
        price = product.getPrice();
        category = new Category(product.getCategory());
    }

    public Product(ProductDTO product) {
        id = product.getId();
        title = product.getTitle();
        description = product.getDescription();
        ownerId = product.getOwnerId();
        price = product.getPrice();
        category = new Category(product.getCategory());
    }

    public ProductDTO toProductDTO() { return new ProductDTO(this); }

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