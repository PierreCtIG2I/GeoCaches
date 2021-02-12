package com.ig2i.test.geocaches.BDD.MySQL.Utilisateur;

import com.ig2i.test.geocaches.BDD.MySQL.Utilisateur.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurJPARepository extends JpaRepository<UtilisateurEntity, String> {
}
