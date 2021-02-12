package com.ig2i.test.geocaches.BDD.MySQL.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "utilisateur")
@Document
public class UtilisateurEntity {

    @Id
    @Column(name = "utilisateur_id")
    private String utilisateur_id;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "description")
    private String description;

    @Column(name = "photo")
    private String photo;

    @Override
    public String toString() {
        return "\nUtilisateur : " +
                "\n - id : " + utilisateur_id +
                "\n - pseudo : " + pseudo +
                "\n - description : '" + description + "'" +
                "\n - photo : " + photo + "\n";
    }
}
