package com.ig2i.test.geocaches.Interfaces.Service;

import com.ig2i.test.geocaches.BDD.MySQL.Visite.VisiteEntity;

import java.util.Date;
import java.util.List;

public interface VisiteService {

    VisiteEntity findVisiteById(String id);

    List<VisiteEntity> findAllVisites();

    void saveVisite(VisiteEntity visite);

    void deleteVisiteById(String id);

    void deleteAllVisites();

    void updateVisite(String id, String champ, String valeur);

    List<VisiteEntity> findVisitesByDate(Date date);
}
