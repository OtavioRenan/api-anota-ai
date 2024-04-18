package com.otaviomenezes.apianotaai.infra.configs;

import com.otaviomenezes.apianotaai.domain.adapters.CategoryServiceImp;
import com.otaviomenezes.apianotaai.domain.adapters.ProductServiceImp;
import com.otaviomenezes.apianotaai.domain.ports.interfaces.CategoryServicePort;
import com.otaviomenezes.apianotaai.domain.ports.interfaces.ProductServicePort;
import com.otaviomenezes.apianotaai.domain.ports.repositories.CategoryRepositoryPort;
import com.otaviomenezes.apianotaai.domain.ports.repositories.ProductRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    CategoryServicePort categoryService(CategoryRepositoryPort repository) {
        return new CategoryServiceImp(repository);
    }

    @Bean
    ProductServicePort productService(ProductRepositoryPort repository, CategoryServicePort categoryService) {
        return new ProductServiceImp(repository, categoryService);
    }
}
