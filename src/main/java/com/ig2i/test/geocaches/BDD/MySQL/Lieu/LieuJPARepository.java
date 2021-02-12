package com.ig2i.test.geocaches.BDD.MySQL.Lieu;

import com.ig2i.test.geocaches.BDD.MySQL.Lieu.LieuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LieuJPARepository extends JpaRepository<LieuEntity, String> {
}
