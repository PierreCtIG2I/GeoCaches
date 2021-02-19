package com.ig2i.test.geocaches.Services;

import com.ig2i.test.geocaches.BDD.MySQL.Lieu.LieuEntity;
import com.ig2i.test.geocaches.Interfaces.Repository.LieuRepository;
import com.ig2i.test.geocaches.Interfaces.Service.LieuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LieuServiceImpl implements LieuService {

    private final LieuRepository lieuRepository;

    @Override
    public LieuEntity findLieuById(String id) {
        return lieuRepository.findLieuById(id);
    }

    @Override
    public List<LieuEntity> findAllLieux() {
        return lieuRepository.findAllLieux();
    }

    @Override
    public void saveLieu(LieuEntity lieu) {
        lieuRepository.saveLieu(lieu);
    }

    @Override
    public void deleteLieuById(String id) {
        lieuRepository.deleteLieuById(id);
    }

    @Override
    public void deleteAllLieux() {
        lieuRepository.deleteAllLieux();
    }

    @Override
    public void updateLieu(String id, String champ, String valeur) {
        lieuRepository.updateLieu(id, champ, valeur);
    }
}
