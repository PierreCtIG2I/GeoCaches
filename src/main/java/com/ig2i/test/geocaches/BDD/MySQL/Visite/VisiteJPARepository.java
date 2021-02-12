package com.ig2i.test.geocaches.BDD.MySQL.Visite;

import com.ig2i.test.geocaches.BDD.MySQL.Visite.VisiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisiteJPARepository extends JpaRepository<VisiteEntity, String> {
}
