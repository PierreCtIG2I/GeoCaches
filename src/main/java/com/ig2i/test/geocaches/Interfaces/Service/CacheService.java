package com.ig2i.test.geocaches.Interfaces.Service;

import com.ig2i.test.geocaches.BDD.MySQL.Cache.CacheEntity;

import java.util.List;

public interface CacheService {
    CacheEntity findCacheById(String id);

    List<CacheEntity> findAllCaches();

    void saveCache(CacheEntity cache);

    void deleteCacheById(String id);

    void deleteAllCaches();

    void updateCache(String id, String champ, String valeur);

    List<CacheEntity> findCachesByUtilisateur(String id);
}
