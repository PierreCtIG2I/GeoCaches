package com.ig2i.test.geocaches.Interfaces.Repository;

import com.ig2i.test.geocaches.BDD.MySQL.Lieu.LieuEntity;

import java.util.List;

public interface LieuRepository {
    LieuEntity findLieuById(String id);

    List<LieuEntity> findAllLieux();

    void saveLieu(LieuEntity lieu);

    void saveAllLieux(List<LieuEntity> lieux);

    void deleteLieuById(String id);

    void deleteAllLieux();

    void updateLieu(String id, String valeur);
}
