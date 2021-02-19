package com.ig2i.test.geocaches.Interfaces.Service;

import com.ig2i.test.geocaches.BDD.MySQL.Utilisateur.UtilisateurEntity;

import java.util.List;

public interface UtilisateurService {

    UtilisateurEntity findUserById(String id);

    List<UtilisateurEntity> findAllUsers();

    void saveUser(UtilisateurEntity user);

    void deleteUserById(String id);

    void deleteAllUsers();

    void updateUser(String id, String champ, String valeur);
}
