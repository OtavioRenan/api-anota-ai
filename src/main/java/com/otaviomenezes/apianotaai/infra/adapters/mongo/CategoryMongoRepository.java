package com.otaviomenezes.apianotaai.infra.adapters.mongo;

import com.otaviomenezes.apianotaai.infra.adapters.entities.CategoryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMongoRepository extends MongoRepository<CategoryEntity, String> {
    @Query("{ownerId: ?0}")
    List<CategoryEntity> findByOwnerId(String ownerId);
}