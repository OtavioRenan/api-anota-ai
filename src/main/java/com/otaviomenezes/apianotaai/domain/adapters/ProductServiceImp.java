package com.otaviomenezes.apianotaai.domain.adapters;

import com.otaviomenezes.apianotaai.domain.Product;
import com.otaviomenezes.apianotaai.domain.dtos.ProductDTO;
import com.otaviomenezes.apianotaai.domain.exceptions.CategoryNotFoundException;
import com.otaviomenezes.apianotaai.domain.exceptions.ProductNotFoundException;
import com.otaviomenezes.apianotaai.domain.ports.interfaces.CategoryServicePort;
import com.otaviomenezes.apianotaai.domain.ports.interfaces.ProductServicePort;
import com.otaviomenezes.apianotaai.domain.ports.repositories.ProductRepositoryPort;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductServiceImp implements ProductServicePort {
    private final ProductRepositoryPort repository;

    private final CategoryServicePort categoryService;

    private static final String[] FIELDS = {"ownerId"};

    public ProductServiceImp(ProductRepositoryPort repository, CategoryServicePort categoryService) {
        this.repository = repository;
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<ProductDTO> delete(String id) {
        repository.delete(findProductById(id));

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<ProductDTO>> findAll(Map<String, String> inputs) {
        List<Product> products;

        if(checkInputs(inputs)) {
            products = repository.findByOwnerId(inputs.get(FIELDS[0]));
        } else {
            products = repository.findAll();
        }

        return ResponseEntity.ok().body(toProductDTO(products));
    }

    @Override
    public ResponseEntity<ProductDTO> findById(String id) {
        return ResponseEntity.ok().body(findProductById(id).toProductDTO());
    }

    @Override
    public ResponseEntity<ProductDTO> insert(ProductDTO product) {
        checkIfCategoryExists(product);

        Product insert = new Product(product);

        insert = repository.save(insert);

        return ResponseEntity.ok().body(insert.toProductDTO());
    }

    @Override
    public ResponseEntity<ProductDTO> update(ProductDTO product, String id) {
        checkIfCategoryExists(product);

        Product update = new Product(product);
        update.setId(id);

        update = repository.save(update);

        return ResponseEntity.ok().body(update.toProductDTO());
    }

    private Product findProductById(String id) {
        Product product = repository.findById(id);

        checkIfProductExists(product);

        return product;
    }

    private void checkIfProductExists(Product product) {
        if(Objects.isNull(product.getId())) throw new ProductNotFoundException();
    }

    private void checkIfCategoryExists(ProductDTO product) {
        if(Objects.isNull(product.getCategory())
            || Objects.isNull(product.getCategory().getId())) throw new CategoryNotFoundException();

        categoryService.findById(product.getCategory().getId());
    }

    private List<ProductDTO> toProductDTO(List<Product> products) {
        return products.stream().map(Product::toProductDTO).collect(Collectors.toList());
    }

    private boolean checkInputs(Map<String, String> inputs) {
        String ownerId = inputs.get(FIELDS[0]);

        return !Objects.isNull(ownerId) && !(ownerId.isEmpty() && ownerId.isBlank());
    }
}