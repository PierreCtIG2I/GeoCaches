package com.ig2i.test.geocaches.BDD.MongoDB.Utilisateur;

import com.ig2i.test.geocaches.BDD.MySQL.Utilisateur.UtilisateurEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UtilisateurMongoRepository extends MongoRepository<UtilisateurEntity, String> {
}
