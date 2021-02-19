package com.ig2i.test.geocaches.BDD.MongoDB.Utilisateur;

import com.ig2i.test.geocaches.BDD.MySQL.Cache.CacheEntity;
import com.ig2i.test.geocaches.BDD.MySQL.Utilisateur.UtilisateurEntity;
import com.ig2i.test.geocaches.Interfaces.Repository.UtilisateurRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;

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
    public void deleteUserById(String id) {
        utilisateurMongoRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        utilisateurMongoRepository.deleteAll();
    }

    @Override
    public void updateUser(String id, String champ, String valeur) {
        UtilisateurEntity utilisateur = utilisateurMongoRepository.findById(id).orElse(null);
        if (utilisateur != null) {
            switch (champ) {
                case "description":
                    utilisateur.setDescription(valeur);
                    this.saveUser(utilisateur);
                    break;
                case "photo":
                    utilisateur.setPhoto(valeur);
                    this.saveUser(utilisateur);
                    break;
                default:
                    System.out.println("Cette colonne n'est pas modifiable ou n'existe pas");
            }
        }
    }
}
