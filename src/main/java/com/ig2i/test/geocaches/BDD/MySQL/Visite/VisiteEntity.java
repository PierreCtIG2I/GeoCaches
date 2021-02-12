package com.ig2i.test.geocaches.BDD.MySQL.Visite;

import com.ig2i.test.geocaches.BDD.MySQL.Cache.CacheEntity;
import com.ig2i.test.geocaches.BDD.MySQL.Utilisateur.UtilisateurEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "visite")
@Document
public class VisiteEntity {

    @Id
    @Column(name = "visite_id")
    private String visite_id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "photo")
    private String photo;

    @ManyToOne()
    @JoinColumn(name = "id_cache")
    private CacheEntity cache;

    @ManyToOne()
    @JoinColumn(name = "id_utilisateur")
    private UtilisateurEntity utilisateur;

    @Override
    public String toString() {
        return "\nVisite : " +
                "\n - id : " + visite_id +
                "\n - Date de la visite : " + date +
                "\n - Commentaire de l'utilisateur : '" + commentaire +
                "\n - Photo : " + photo +
                "'\n - Cache visitée { " + cache + "}\n" +
                "\n - Utilisateur de la visite { " + utilisateur + " }\n";
    }
}
