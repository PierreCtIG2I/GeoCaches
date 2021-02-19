package com.ig2i.test.geocaches.Interfaces.Service;

import com.ig2i.test.geocaches.BDD.MySQL.Lieu.LieuEntity;

import java.util.List;

public interface LieuService {
    LieuEntity findLieuById(String id);

    List<LieuEntity> findAllLieux();

    void saveLieu(LieuEntity lieu);

    void deleteLieuById(String id);

    void deleteAllLieux();

    void updateLieu(String id, String champ, String valeur);
}
