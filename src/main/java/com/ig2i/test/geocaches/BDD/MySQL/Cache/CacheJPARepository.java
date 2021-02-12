package com.ig2i.test.geocaches.BDD.MySQL.Cache;

import com.ig2i.test.geocaches.BDD.MySQL.Cache.CacheEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CacheJPARepository extends JpaRepository<CacheEntity, String> {
}
