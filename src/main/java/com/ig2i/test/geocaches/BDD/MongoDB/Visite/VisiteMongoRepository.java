package com.ig2i.test.geocaches.BDD.MongoDB.Visite;

import com.ig2i.test.geocaches.BDD.MySQL.Visite.VisiteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface VisiteMongoRepository extends MongoRepository<VisiteEntity, String> {
    Optional<List<VisiteEntity>> findVisiteEntitiesByDate(Date date);
}
