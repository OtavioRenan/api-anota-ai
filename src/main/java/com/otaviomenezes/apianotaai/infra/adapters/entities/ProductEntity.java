package com.otaviomenezes.apianotaai.infra.adapters.entities;

import com.otaviomenezes.apianotaai.domain.Product;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class ProductEntity {
    @Id
    private String id;

    @NotBlank(message = "O título é obrigatório.")
    private String title;

    @NotBlank(message = "A descrição é obrigatória.")
    private String description;

    @NotBlank(message = "O proprietário é obrigatório.")
    private String ownerId;

    @NotBlank(message = "O preço é obrigatório.")
    private Double price;

    @NotBlank(message = "A categoria é obrigatória.")
    private CategoryEntity category;

    public ProductEntity() {}

    public ProductEntity(Product product) {
        id = product.getId();
        title = product.getTitle();
        description = product.getDescription();
        ownerId = product.getOwnerId();
        price = product.getPrice();
        category = new CategoryEntity(product.getCategory());
    }

    public Product toProduct() { return new Product(this); }

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