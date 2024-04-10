package com.otaviomenezes.apianotaai.infra.adapters.mongo;

import com.otaviomenezes.apianotaai.infra.adapters.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMongoRepository extends MongoRepository<ProductEntity, String> {
}