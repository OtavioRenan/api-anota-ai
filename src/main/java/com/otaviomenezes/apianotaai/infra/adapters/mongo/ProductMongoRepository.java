package com.otaviomenezes.apianotaai.infra.adapters.mongo;

import com.otaviomenezes.apianotaai.infra.adapters.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMongoRepository extends MongoRepository<ProductEntity, String> {
    @Query("{ownerId: ?0}")
    List<ProductEntity> findByOwnerId(String ownerId);
}