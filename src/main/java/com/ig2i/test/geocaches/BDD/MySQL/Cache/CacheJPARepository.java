package com.ig2i.test.geocaches.BDD.MySQL.Cache;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CacheJPARepository extends JpaRepository<CacheEntity, String> {
    Optional<List<CacheEntity>> findCacheEntitiesByUtilisateur(String id);
}

