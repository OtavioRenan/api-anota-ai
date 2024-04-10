package com.otaviomenezes.apianotaai.infra.adapters.entities;

import com.otaviomenezes.apianotaai.domain.Category;
import com.otaviomenezes.apianotaai.domain.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "products")
public class ProductEntity {
    @Id
    private String id;

    private String title;

    private String description;

    private String ownerId;

    private Double price;

    private CategoryEntity category;

    public ProductEntity(String id, String title, String description, String ownerId, Double price, CategoryEntity category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ownerId = ownerId;
        this.price = price;
        this.category = category;
    }

    public Product toProduct() {
        return new Product(id, title, description, ownerId, price, new Category(category));
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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
