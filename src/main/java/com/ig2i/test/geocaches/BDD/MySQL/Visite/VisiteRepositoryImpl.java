package com.ig2i.test.geocaches.BDD.MySQL.Visite;

import com.ig2i.test.geocaches.Interfaces.Repository.VisiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Profile("mysql")
public class VisiteRepositoryImpl implements VisiteRepository {

    private final VisiteJPARepository visiteJPARepository;

    @Override
    public VisiteEntity findVisiteById(String id) {
        return visiteJPARepository.findById(id).orElse(null);
    }

    @Override
    public List<VisiteEntity> findAllVisites() {
        return visiteJPARepository.findAll();
    }

    @Override
    public void saveVisite(VisiteEntity visite) {
        visiteJPARepository.save(visite);
    }

    @Override
    public void saveAllVisites(List<VisiteEntity> visites) {
        visiteJPARepository.saveAll(visites);
    }

    @Override
    public void deleteVisiteById(String id) {
        visiteJPARepository.deleteById(id);
    }

    @Override
    public void deleteAllVisites() {
        visiteJPARepository.deleteAll();
    }
}
