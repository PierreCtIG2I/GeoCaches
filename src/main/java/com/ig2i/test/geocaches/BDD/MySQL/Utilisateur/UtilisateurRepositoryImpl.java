package com.ig2i.test.geocaches.BDD.MySQL.Utilisateur;

import com.ig2i.test.geocaches.Interfaces.Repository.UtilisateurRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("mysql")
public class UtilisateurRepositoryImpl implements UtilisateurRepository {

    private final UtilisateurJPARepository utilisateurJPARepository;

    public UtilisateurRepositoryImpl(UtilisateurJPARepository utilisateurJPARepository) {
        this.utilisateurJPARepository = utilisateurJPARepository;
    }

    @Override
    public UtilisateurEntity findUserById(String id) {
        return utilisateurJPARepository.findById(id).orElse(null);
    }

    @Override
    public List<UtilisateurEntity> findAllUsers() {
        return utilisateurJPARepository.findAll();
    }

    @Override
    public void saveUser(UtilisateurEntity user) {
        utilisateurJPARepository.save(user);
    }

    @Override
    public void deleteUserById(String id) {
        utilisateurJPARepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        utilisateurJPARepository.deleteAll();
    }

    @Override
    public void updateUser(String id, String champ, String valeur) {
        UtilisateurEntity utilisateur = utilisateurJPARepository.findById(id).orElse(null);
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
