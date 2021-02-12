package com.ig2i.test.geocaches.Interfaces.Repository;

import com.ig2i.test.geocaches.BDD.MySQL.Visite.VisiteEntity;

import java.util.List;

public interface VisiteRepository {

    VisiteEntity findVisiteById(String id);

    List<VisiteEntity> findAllVisites();

    void saveVisite(VisiteEntity visite);

    void saveAllVisites(List<VisiteEntity> visites);

    void deleteVisiteById(String id);

    void deleteAllVisites();

    void updateVisite(String id, String champ, String valeur);
}
