package com.ig2i.test.geocaches.BDD.MongoDB.Cache;

import com.ig2i.test.geocaches.BDD.MySQL.Cache.CacheEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CacheMongoRepository extends MongoRepository<CacheEntity, String> {
}