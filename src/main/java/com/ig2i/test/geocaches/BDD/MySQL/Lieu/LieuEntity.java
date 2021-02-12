package com.ig2i.test.geocaches.BDD.MySQL.Lieu;

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
@Table(name = "lieu")
@Document
public class LieuEntity {

    @Id
    @Column(name = "lieu_id")
    private String lieu_id;

    @Column(name = "description")
    private String description;

    @Override
    public String toString() {
        return "\nLieu : " +
                "\n - id : " + lieu_id +
                "\n - description : '" + description + "' \n";
    }
}
