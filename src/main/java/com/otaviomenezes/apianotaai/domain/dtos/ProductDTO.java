package com.otaviomenezes.apianotaai.domain.dtos;

import com.otaviomenezes.apianotaai.domain.Product;

public class ProductDTO {
    private String id;

    private String title;

    private String description;

    private String ownerId;

    private Double price;

    private CategoryDTO category;

    public ProductDTO() {}

    public ProductDTO(Product product) {
        id = product.getId();
        title = product.getTitle();
        description = product.getDescription();
        ownerId = product.getOwnerId();
        price = product.getPrice();
        category = new CategoryDTO(product.getCategory());
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

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}
