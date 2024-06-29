package com.otaviomenezes.apianotaai.infra.adapters.repositories;

import com.otaviomenezes.apianotaai.domain.Product;
import com.otaviomenezes.apianotaai.domain.ports.repositories.ProductRepositoryPort;
import com.otaviomenezes.apianotaai.infra.adapters.entities.ProductEntity;
import com.otaviomenezes.apianotaai.infra.adapters.mongo.ProductMongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepository implements ProductRepositoryPort {
    private final ProductMongoRepository repository;

    public ProductRepository(ProductMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void delete(Product product) {
        repository.delete(new ProductEntity(product));
    }

    @Override
    public List<Product> findAll() {
        return toProduct(repository.findAll());
    }

    @Override
    public Product findById(String id) {
        return repository.findById(id).orElse(new ProductEntity()).toProduct();
    }

    @Override
    public List<Product> findByOwnerId(String ownerId) {
        return toProduct(repository.findByOwnerId(ownerId));
    }

    @Override
    public Product save(Product product) {
        return repository.save(new ProductEntity(product)).toProduct();
    }

    private List<Product> toProduct(List<ProductEntity> products) {
        return products.stream().map(ProductEntity::toProduct).toList();
    }
}
