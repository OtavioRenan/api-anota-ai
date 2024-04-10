package com.otaviomenezes.apianotaai.infra.adapters.mongo;

import com.otaviomenezes.apianotaai.infra.adapters.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMongoRepository extends MongoRepository<CategoryEntity, String> {
    @Query("{$or: [{title: {$regex: ?0}}, {description: {$regex: ?0}}]}")
    List<CategoryEntity> findWithParams(String fields, String ownerId);

    @Query("{$or: [{title: {$regex: ?0}}, {description: {$regex: ?0}}]}")
    Page<CategoryEntity> findWithParams(String fields, String ownerId, Pageable pageable);
}