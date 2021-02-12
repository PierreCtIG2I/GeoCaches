package com.ig2i.test.geocaches.BDD.MySQL.Lieu;

import com.ig2i.test.geocaches.Interfaces.Repository.LieuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Profile("mysql")
public class LieuRepositoryImpl implements LieuRepository {

    private final LieuJPARepository lieuJPARepository;

    @Override
    public LieuEntity findLieuById(String id) {
        return lieuJPARepository.findById(id).orElse(null);
    }

    @Override
    public List<LieuEntity> findAllLieux() {
        return lieuJPARepository.findAll();
    }

    @Override
    public void saveLieu(LieuEntity lieu) {
        lieuJPARepository.save(lieu);
    }

    @Override
    public void saveAllLieux(List<LieuEntity> lieux) {
        lieuJPARepository.saveAll(lieux);
    }

    @Override
    public void deleteLieuById(String id) {
        lieuJPARepository.deleteById(id);
    }

    @Override
    public void deleteAllLieux() {
        lieuJPARepository.deleteAll();
    }
}
