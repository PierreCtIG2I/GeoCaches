package com.ig2i.test.geocaches.BDD.MongoDB.Lieu;

import com.ig2i.test.geocaches.BDD.MySQL.Lieu.LieuEntity;
import com.ig2i.test.geocaches.Interfaces.Repository.LieuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Profile("mongodb")
public class LieuMongoRepositoryImpl implements LieuRepository {

    private final LieuMongoRepository lieuMongoRepository;

    @Override
    public LieuEntity findLieuById(String id) {
        return lieuMongoRepository.findById(id).orElse(null);
    }

    @Override
    public List<LieuEntity> findAllLieux() {
        return lieuMongoRepository.findAll();
    }

    @Override
    public void saveLieu(LieuEntity lieu) {
        lieuMongoRepository.save(lieu);
    }

    @Override
    public void deleteLieuById(String id) {
        lieuMongoRepository.deleteById(id);
    }

    @Override
    public void deleteAllLieux() {
        lieuMongoRepository.deleteAll();
    }

    @Override
    public void updateLieu(String id, String champ, String valeur) {
        if (champ.equals("description")) {
            LieuEntity lieu = this.findLieuById(id);
            lieu.setDescription(valeur);
            saveLieu(lieu);
        } else {
            System.out.println("La colonne spécifiée n'existe pas ou ne peut pas être changée.");
        }
    }
}
