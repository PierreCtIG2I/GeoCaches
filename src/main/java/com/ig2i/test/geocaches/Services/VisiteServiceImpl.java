package com.ig2i.test.geocaches.Services;

import com.ig2i.test.geocaches.BDD.MySQL.Visite.VisiteEntity;
import com.ig2i.test.geocaches.Interfaces.Repository.VisiteRepository;
import com.ig2i.test.geocaches.Interfaces.Service.VisiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisiteServiceImpl implements VisiteService {

    private final VisiteRepository visiteRepository;

    @Override
    public VisiteEntity findVisiteById(String id) {
        return visiteRepository.findVisiteById(id);
    }

    @Override
    public List<VisiteEntity> findAllVisites() {
        return visiteRepository.findAllVisites();
    }

    @Override
    public void saveVisite(VisiteEntity visite) {
        visiteRepository.saveVisite(visite);
    }

    @Override
    public void saveAllVisites(List<VisiteEntity> visites) {
        visiteRepository.saveAllVisites(visites);
    }

    @Override
    public void deleteVisiteById(String id) {
        visiteRepository.deleteVisiteById(id);
    }

    @Override
    public void deleteAllVisites() {
        visiteRepository.deleteAllVisites();
    }
}