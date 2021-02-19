package com.ig2i.test.geocaches.BDD.MySQL.Visite;

import com.ig2i.test.geocaches.BDD.MySQL.Visite.VisiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface VisiteJPARepository extends JpaRepository<VisiteEntity, String> {
    Optional<List<VisiteEntity>> findVisiteEntitiesByDate(Date date);
}
