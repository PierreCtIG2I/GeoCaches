package com.ig2i.test.geocaches.BDD.MongoDB.Utilisateur;

import com.ig2i.test.geocaches.BDD.MySQL.Utilisateur.UtilisateurEntity;
import com.ig2i.test.geocaches.Interfaces.Repository.UtilisateurRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("mongodb")
public class UtilisateurMongoRepositoryImpl implements UtilisateurRepository {

    private final UtilisateurMongoRepository utilisateurMongoRepository;

    public UtilisateurMongoRepositoryImpl(UtilisateurMongoRepository utilisateurMongoRepository) {
        this.utilisateurMongoRepository = utilisateurMongoRepository;
    }

    @Override
    public UtilisateurEntity findUserById(String id) {
        return utilisateurMongoRepository.findById(id).orElse(null);
    }

    @Override
    public List<UtilisateurEntity> findAllUsers() {
        return utilisateurMongoRepository.findAll();
    }

    @Override
    public void saveUser(UtilisateurEntity user) {
        utilisateurMongoRepository.save(user);
    }

    @Override
    public void saveAllUsers(List<UtilisateurEntity> users) {
        utilisateurMongoRepository.saveAll(users);
    }

    @Override
    public void deleteUserById(String id) {
        utilisateurMongoRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        utilisateurMongoRepository.deleteAll();
    }
}
