package com.ig2i.test.geocaches.BDD.MongoDB.Visite;

import com.ig2i.test.geocaches.BDD.MySQL.Visite.VisiteEntity;
import com.ig2i.test.geocaches.Interfaces.Repository.VisiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Profile("mongodb")
public class VisiteMongoRepositoryImpl implements VisiteRepository {

    private final VisiteMongoRepository visiteMongoRepository;

    @Override
    public VisiteEntity findVisiteById(String id) {
        return visiteMongoRepository.findById(id).orElse(null);
    }

    @Override
    public List<VisiteEntity> findAllVisites() {
        return visiteMongoRepository.findAll();
    }

    @Override
    public void saveVisite(VisiteEntity visite) {
        visiteMongoRepository.save(visite);
    }

    @Override
    public void saveAllVisites(List<VisiteEntity> visites) {
        visiteMongoRepository.saveAll(visites);
    }

    @Override
    public void deleteVisiteById(String id) {
        visiteMongoRepository.deleteById(id);
    }

    @Override
    public void deleteAllVisites() {
        visiteMongoRepository.deleteAll();
    }
}
