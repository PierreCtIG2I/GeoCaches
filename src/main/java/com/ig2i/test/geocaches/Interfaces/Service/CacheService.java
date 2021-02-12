package com.ig2i.test.geocaches.Interfaces.Service;

import com.ig2i.test.geocaches.BDD.MySQL.Cache.CacheEntity;

import java.util.List;

public interface CacheService {
    CacheEntity findCacheById(String id);

    List<CacheEntity> findAllCaches();

    void saveCache(CacheEntity cache);

    void saveAllCaches(List<CacheEntity> caches);

    void deleteCacheById(String id);

    void deleteAllCaches();
}