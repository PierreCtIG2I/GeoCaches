package com.ig2i.test.geocaches.BDD.MongoDB.Visite;

import com.ig2i.test.geocaches.BDD.MySQL.Utilisateur.UtilisateurEntity;
import com.ig2i.test.geocaches.BDD.MySQL.Visite.VisiteEntity;
import com.ig2i.test.geocaches.Interfaces.Repository.VisiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Date;
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
    public void deleteVisiteById(String id) {
        visiteMongoRepository.deleteById(id);
    }

    @Override
    public void deleteAllVisites() {
        visiteMongoRepository.deleteAll();
    }

    @Override
    public void updateVisite(String id, String champ, String valeur) {
        VisiteEntity visite = visiteMongoRepository.findById(id).orElse(null);
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
        return visiteMongoRepository.findVisiteEntitiesByDate(date).orElse(null);
    }
}
