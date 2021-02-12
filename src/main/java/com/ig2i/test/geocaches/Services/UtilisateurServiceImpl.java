package com.ig2i.test.geocaches.Services;

import com.ig2i.test.geocaches.BDD.MySQL.Utilisateur.UtilisateurEntity;
import com.ig2i.test.geocaches.Interfaces.Repository.UtilisateurRepository;
import com.ig2i.test.geocaches.Interfaces.Service.UtilisateurService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurEntity findUserById(String id) {
        return utilisateurRepository.findUserById(id);
    }

    @Override
    public List<UtilisateurEntity> findAllUsers() {
        return utilisateurRepository.findAllUsers();
    }

    @Override
    public void saveUser(UtilisateurEntity user) {
        utilisateurRepository.saveUser(user);
    }

    @Override
    public void saveAllUsers(List<UtilisateurEntity> users) {
        utilisateurRepository.saveAllUsers(users);
    }

    @Override
    public void deleteUserById(String id) {
        utilisateurRepository.deleteUserById(id);
    }

    @Override
    public void deleteAllUsers() {
        utilisateurRepository.deleteAllUsers();
    }
}
