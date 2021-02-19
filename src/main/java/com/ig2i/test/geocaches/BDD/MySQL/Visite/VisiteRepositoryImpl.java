package com.ig2i.test.geocaches.BDD.MySQL.Visite;

import com.ig2i.test.geocaches.Interfaces.Repository.VisiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Date;
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
    public void deleteVisiteById(String id) {
        visiteJPARepository.deleteById(id);
    }

    @Override
    public void deleteAllVisites() {
        visiteJPARepository.deleteAll();
    }

    @Override
    public void updateVisite(String id, String champ, String valeur) {
        VisiteEntity visite = visiteJPARepository.findById(id).orElse(null);
        if (visite != null) {
            switch (champ) {
                case "commentaire":
                    visite.setCommentaire(valeur);
                    this.saveVisite(visite);
                    break;
                case "photo":
                    visite.setPhoto(valeur);
                    this.saveVisite(visite);
                    break;
                default:
                    System.out.println("Cette colonne n'est pas modifiable ou n'existe pas");
            }
        }
    }

    @Override
    public List<VisiteEntity> findVisitesByDate(Date date) {
        return visiteJPARepository.findVisiteEntitiesByDate(date).orElse(null);
    }
}
