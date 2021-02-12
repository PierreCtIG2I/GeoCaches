package com.ig2i.test.geocaches.Services;

import com.ig2i.test.geocaches.BDD.MySQL.Cache.CacheEntity;
import com.ig2i.test.geocaches.Interfaces.Repository.CacheRepository;
import com.ig2i.test.geocaches.Interfaces.Service.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CacheServiceImpl implements CacheService {

    private final CacheRepository cacheRepository;

    @Override
    public CacheEntity findCacheById(String id) {
        return cacheRepository.findCacheById(id);
    }

    @Override
    public List<CacheEntity> findAllCaches() {
        return cacheRepository.findAllCaches();
    }

    @Override
    public void saveCache(CacheEntity cache) {
        cacheRepository.saveCache(cache);
    }

    @Override
    public void saveAllCaches(List<CacheEntity> caches) {
        cacheRepository.saveAllCaches(caches);
    }

    @Override
    public void deleteCacheById(String id) {
        cacheRepository.deleteCacheById(id);
    }

    @Override
    public void deleteAllCaches() {
        cacheRepository.deleteAllCaches();
    }
}
