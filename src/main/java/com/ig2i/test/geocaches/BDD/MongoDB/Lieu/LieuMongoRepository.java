package com.ig2i.test.geocaches.BDD.MongoDB.Lieu;

import com.ig2i.test.geocaches.BDD.MySQL.Lieu.LieuEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LieuMongoRepository extends MongoRepository<LieuEntity, String> {
}
