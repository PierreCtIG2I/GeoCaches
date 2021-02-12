package com.ig2i.test.geocaches.BDD.MongoDB.Cache;

import com.ig2i.test.geocaches.BDD.MySQL.Cache.CacheEntity;
import com.ig2i.test.geocaches.Interfaces.Repository.CacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Profile("mongodb")
public class CacheMongoRepositoryImpl implements CacheRepository {

    private final CacheMongoRepository cacheMongoRepository;

    @Override
    public CacheEntity findCacheById(String id) {
        return cacheMongoRepository.findById(id).orElse(null);
    }

    @Override
    public List<CacheEntity> findAllCaches() {
        return cacheMongoRepository.findAll();
    }

    @Override
    public void saveCache(CacheEntity cache) {
        cacheMongoRepository.save(cache);
    }

    @Override
    public void saveAllCaches(List<CacheEntity> caches) {
        cacheMongoRepository.saveAll(caches);
    }

    @Override
    public void deleteCacheById(String id) {
        cacheMongoRepository.deleteById(id);
    }

    @Override
    public void deleteAllCaches() {
        cacheMongoRepository.deleteAll();
    }
}
