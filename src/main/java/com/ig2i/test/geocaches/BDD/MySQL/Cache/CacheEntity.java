package com.ig2i.test.geocaches.BDD.MySQL.Cache;

import com.ig2i.test.geocaches.BDD.MySQL.Lieu.LieuEntity;
import com.ig2i.test.geocaches.BDD.MySQL.Utilisateur.UtilisateurEntity;
import com.ig2i.test.geocaches.BDD.MySQL.Visite.VisiteEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cache")
@Document
public class CacheEntity {

    @Id
    @Column(name = "cache_id")
    private String cache_id;

    @Column(name = "coordonnees")
    private String coordonnees;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "nature")
    private String nature;

    @Column(name = "etat")
    private String etat;

    @ManyToOne
    @JoinColumn(name = "id_lieu")
    private LieuEntity lieu;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private UtilisateurEntity utilisateur;

    @OneToMany(mappedBy = "cache", cascade = CascadeType.ALL)
    private List<VisiteEntity> listeVisites;

    public CacheEntity(String id, String coordonnees, String description, String type, String nature, String etat, LieuEntity lieu, UtilisateurEntity utilisateur) {
        this.cache_id = id;
        this.coordonnees = coordonnees;
        this.description = description;
        this.type = type;
        this.nature = nature;
        this.etat = etat;
        this.lieu = lieu;
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString() {
        return "\nCache : " +
                "\n - id : " + cache_id +
                "\n - Coordonnées : " + coordonnees +
                "\n - Description : '" + description +
                "'\n - Type de cache : " + type +
                "\n - Nature : " + nature +
                "\n - Etat : " + etat +
                "\n - Lieu de la cache { " + lieu + "}\n" +
                "\n - Propriétaire de la cache { " + utilisateur + "}\n";
    }
}
