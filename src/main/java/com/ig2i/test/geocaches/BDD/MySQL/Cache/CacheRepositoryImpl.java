package com.ig2i.test.geocaches.BDD.MySQL.Cache;

import com.ig2i.test.geocaches.Interfaces.Repository.CacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;

@Repository
@RequiredArgsConstructor
@Profile("mysql")
public class CacheRepositoryImpl implements CacheRepository {

    private final CacheJPARepository cacheJPARepository;

    @Override
    public CacheEntity findCacheById(String id) {
        return cacheJPARepository.findById(id).orElse(null);
    }

    @Override
    public List<CacheEntity> findAllCaches() {
        return cacheJPARepository.findAll();
    }

    @Override
    public void saveCache(CacheEntity cache) {
        cacheJPARepository.save(cache);
    }

    @Override
    public void deleteCacheById(String id) {
        cacheJPARepository.deleteById(id);
    }

    @Override
    public void deleteAllCaches() {
        cacheJPARepository.deleteAll();
    }

    @Override
    public void updateCache(String id, String champ, String valeur) {
        CacheEntity cache = cacheJPARepository.findById(id).orElse(null);
        if (cache != null) {
            switch (champ) {
                case "coordonnees" :
                    cache.setCoordonnees(valeur);
                    this.saveCache(cache);
                    break;
                case "description" :
                    cache.setDescription(valeur);
                    this.saveCache(cache);
                    break;
                case "type" :
                    cache.setType(valeur);
                    this.saveCache(cache);
                    break;
                case "nature" :
                    if (valeur.equalsIgnoreCase("VIRTUELLE") || valeur.equalsIgnoreCase("PHYSIQUE")) {
                        cache.setNature(valeur.toUpperCase(Locale.ROOT));
                        this.saveCache(cache);
                    }
                    else {
                        System.out.println("La valeur attribué au champ nature ne correspond pas. Veuillez saisir la valeur 'physique' ou 'virtuelle");
                    }
                    break;
                case "etat" :
                    if (valeur.equalsIgnoreCase("ACTIVEE") || valeur.equalsIgnoreCase("EN_COURS_ACTIVATION") || valeur.equalsIgnoreCase("FERMEE") || valeur.equalsIgnoreCase("SUSPENDUE")) {
                        cache.setEtat(valeur.toUpperCase(Locale.ROOT));
                        this.saveCache(cache);
                    }
                    else {
                        System.out.println("La valeur attribué au champ etat ne correspond pas. Veuillez saisir la valeur 'activee', 'en_cours_activation', 'fermee' ou 'susprendue");
                    }
                    break;
                default:
                    System.out.println("Cette colonne n'est pas modifiable ou n'existe pas");
            }
        }
    }

    @Override
    public List<CacheEntity> findCachesByUtilisateur(String id) {
        return cacheJPARepository.findCacheEntitiesByUtilisateur(id).orElse(null);
    }
}
