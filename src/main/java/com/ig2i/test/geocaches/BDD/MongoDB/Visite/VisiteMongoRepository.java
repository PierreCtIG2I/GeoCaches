package com.ig2i.test.geocaches.BDD.MongoDB.Visite;

import com.ig2i.test.geocaches.BDD.MySQL.Visite.VisiteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VisiteMongoRepository extends MongoRepository<VisiteEntity, String> {
}
