package com.ig2i.test.geocaches.BDD.MongoDB.Cache;

import com.ig2i.test.geocaches.BDD.MySQL.Cache.CacheEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CacheMongoRepository extends MongoRepository<CacheEntity, String> {
    Optional<List<CacheEntity>> findCacheEntitiesByUtilisateur(String id);
}

