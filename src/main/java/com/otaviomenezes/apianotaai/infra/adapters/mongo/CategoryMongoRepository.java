package com.otaviomenezes.apianotaai.infra.adapters.mongo;

import com.otaviomenezes.apianotaai.infra.adapters.entities.CategoryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMongoRepository extends MongoRepository<CategoryEntity, String> {
}