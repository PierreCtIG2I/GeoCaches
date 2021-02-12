package com.ig2i.test.geocaches.Application;

import com.ig2i.test.geocaches.BDD.MySQL.Cache.CacheEntity;
import com.ig2i.test.geocaches.BDD.MySQL.Lieu.LieuEntity;
import com.ig2i.test.geocaches.BDD.MySQL.Visite.VisiteEntity;
import com.ig2i.test.geocaches.Interfaces.Service.*;
import com.ig2i.test.geocaches.BDD.MySQL.Utilisateur.UtilisateurEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ApplicationConsole implements CommandLineRunner {

    private final CacheService cacheService;
    private final LieuService lieuService;
    private final UtilisateurService utilisateurService;
    private final VisiteService visiteService;

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String commande = "";
        System.out.println("Appuyez sur n'importe quelle touche pour commencer la session de test");
        scanner.nextLine();
        while (!commande.equalsIgnoreCase("quitter")) {
            System.out.println("\t======================================================"
            + "\n Commandes de l'application : "
            + "\t - get [cache|lieu|utilisateur|visite] [id || all]"
            + "\t - update [cache|lieu|utilisateur|visite] [id]"
            + "\t - delete [cache|lieu|utilisateur|visite] [id || all]"
            + "\t - add [cache|lieu|utilisateur|visite] [valeurs_des_champs]"
            + "\t\t - Template table cache : "
            + "\t\t\t - add cache coordonnees;description;type;nature;etat;id_lieu;id_utilisateur"
            + "\t\t\t Notes : * La champ \"nature\" doit contenir la valeur 'PHYSIQUE' ou 'VIRTUELLE'."
            + "\t\t\t * La champ \"etat\" doit contenir la valeur 'ACTIVEE', 'EN_COURS_ACTIVATION', 'FERMEE' ou 'SUSPENDUE'."
            + "\t\t - Template table lieu : "
            + "\t\t\t - add lieu description"
            + "\t\t - Template table utilisateur : "
            + "\t\t\t - add user pseudo;description;photo"
            + "\t\t - Template table visite : "
            + "\t\t\t - add visite commentaire;photo;id_cache;id_utilisateur"
            + "\t - Quitter |Termine la session de test|\n"
            + "\t======================================================\n");

            System.out.println("Veuillez entrer une commande :");
            commande = scanner.nextLine();
            String[] commandeDivisee = commande.split(" ");

            switch (commandeDivisee[0]) {
                case "get":
                    if (commandeDivisee[1] != null) {
                        switch (commandeDivisee[1]) {
                            case "cache":
                                if (commandeDivisee[2].equalsIgnoreCase("all")) {
                                    System.out.println(cacheService.findAllCaches());
                                } else {
                                    System.out.println(cacheService.findCacheById(commandeDivisee[2]));
                                }
                                break;
                            case "lieu":
                                if (commandeDivisee[2].equalsIgnoreCase("all")) {
                                    System.out.println(lieuService.findAllLieux());
                                } else {
                                    System.out.println(lieuService.findLieuById(commandeDivisee[2]));
                                }
                                break;
                            case "utilisateur":
                                if (commandeDivisee[2].equalsIgnoreCase("all")) {
                                    System.out.println(utilisateurService.findAllUsers());
                                } else {
                                    System.out.println(utilisateurService.findUserById(commandeDivisee[2]));
                                }
                                break;
                            case "visite":
                                if (commandeDivisee[2].equalsIgnoreCase("all")) {
                                    System.out.println(visiteService.findAllVisites());
                                } else {
                                    System.out.println(visiteService.findVisiteById(commandeDivisee[2]));
                                }
                                break;
                            default:
                                System.out.printf("La table '%s' n'est pas présent en base %n", commandeDivisee[1]);
                        }
                    }
                    break;
                /*case "update":
                    Faker faker = new Faker(new Locale("fr"));
                    if (commandSplit[1] != null)
                        switch (commandSplit[1]) {
                            case "cache":
                                String[] fields = commandSplit[2].split(":");
                                if (fields.length == 1) {
                                    Cache c = cacheService.findCacheById(fields[0]);
                                    if (c != null) {
                                        c.setDescription(faker.lorem().fixedString(30));
                                        System.out.println(cacheService.save(c));
                                    }
                                } else {
                                    System.out.println("Vous n'avez pas renseigné assez de champs");
                                    break;
                                }
                                break;
                            case "visite":
                                fields = commandSplit[2].split(":");
                                if (fields.length == 1) {
                                    Visite c = visiteService.findVisiteById(fields[0]);
                                    if (c != null) {
                                        c.setCommentaire(faker.lorem().fixedString(30));
                                        System.out.println(visiteService.save(c));
                                    }
                                } else {
                                    System.out.println("Vous n'avez pas renseigné assez de champs");
                                    break;
                                }
                                break;
                            case "user":
                                fields = commandSplit[2].split(":");
                                if (fields.length == 1) {
                                    User c = userService.findUserById(fields[0]);
                                    if (c != null) {
                                        c.setDescription(faker.lorem().fixedString(30));
                                        System.out.println(userService.save(c));
                                    }
                                } else {
                                    System.out.println("Vous n'avez pas renseigné assez de champs");
                                    break;
                                }
                                break;
                            case "lieu":
                                fields = commandSplit[2].split(":");
                                if (fields.length == 1) {
                                    Lieu c = lieuService.findLieuById(fields[0]);
                                    if (c != null) {
                                        c.setNom(faker.address().city());
                                        System.out.println(lieuService.save(c));
                                    }
                                } else {
                                    System.out.println("Vous n'avez pas renseigné assez de champs");
                                    break;
                                }
                                break;
                            default:
                                System.out.printf("L'objet '%s' n'est pas reconnu %n", commandSplit[1]);
                                throw new IllegalArgumentException("Objet invalide");
                        }
                    break;*/
                case "add":
                    if (commandeDivisee[1] != null) {
                        String id = UUID.randomUUID().toString();
                        switch (commandeDivisee[1]) {
                            case "cache":
                                String[] champs = commandeDivisee[2].split(";");
                                if (champs.length != 7) {
                                    System.out.println("Tous les champs n'ont pas été renseignés. Création de la cache annulée");
                                    break;
                                }
                                LieuEntity lieu = lieuService.findLieuById(champs[5]);
                                UtilisateurEntity utilisateur = utilisateurService.findUserById(champs[6]);
                                cacheService.saveCache(new CacheEntity(id, champs[0], champs[1], champs[2], champs[3], champs[4], lieu, utilisateur));
                                System.out.println("Nouvelle cache créée (cache_id = " + id + ")");
                                break;
                            case "lieu":
                                champs = commandeDivisee[2].split(":");
                                if (champs.length != 1) {
                                    System.out.println("Tous les champs n'ont pas été renseignés. Création du lieu annulée");
                                    break;
                                }
                                lieuService.saveLieu(new LieuEntity(id, champs[0]));
                                System.out.println("Nouveau lieu créé (lieu_id = " + id + ")");
                                break;
                            case "utilisateur":
                                champs = commandeDivisee[2].split(":");
                                if (champs.length != 3) {
                                    System.out.println("Tous les champs n'ont pas été renseignés. Création de l'utilisateur annulée");
                                    break;
                                }
                                utilisateurService.saveUser(new UtilisateurEntity(id, champs[0], champs[1], champs[2]));
                                System.out.println("Nouvel utilisateur créé (utilisateur_id = " + id + ")");
                                break;
                            case "visite":
                                champs = commandeDivisee[2].split(":");
                                if (champs.length == 4) {
                                    CacheEntity cache = cacheService.findCacheById(champs[2]);
                                    UtilisateurEntity utilisateurVisite = utilisateurService.findUserById(champs[3]);
                                    visiteService.saveVisite(new VisiteEntity(id, LocalDateTime.now(), champs[0], champs[1], cache, utilisateurVisite));
                                    System.out.println("Nouvelle visite créée (visite_id = " + id + ")");
                                } else {
                                    System.out.println("Tous les champs n'ont pas été renseignés. Création de la visite annulée");
                                    break;
                                }
                                break;
                            default:
                                System.out.printf("La table '%s' n'est pas présent en base %n", commandeDivisee[1]);
                                throw new IllegalArgumentException("Objet invalide");
                        }
                        break;
                    }
                case "delete":
                    if (commandeDivisee[1] != null)
                        switch (commandeDivisee[1]) {
                            case "cache":
                                if (commandeDivisee[2].equalsIgnoreCase("all")) {
                                    cacheService.deleteAllCaches();
                                    System.out.println("Toutes les caches ont été supprimées.");
                                } else {
                                    cacheService.deleteCacheById(commandeDivisee[2]);
                                    System.out.println("La cache id=" + commandeDivisee[2] + " a été supprimée.");
                                }
                                break;
                            case "utilisateur":
                                if (commandeDivisee[2].equalsIgnoreCase("all")) {
                                    utilisateurService.deleteAllUsers();
                                    System.out.println("Tous les utilisateurs ont été supprimés.");
                                } else {
                                    utilisateurService.deleteUserById(commandeDivisee[2]);
                                    System.out.println("L'utilisateur id=" + commandeDivisee[2] + " a été supprimé.");
                                }
                                break;
                            case "lieu":
                                if (commandeDivisee[2].equalsIgnoreCase("all")) {
                                    lieuService.deleteAllLieux();
                                    System.out.println("Tous les lieux ont été supprimés.");
                                } else {
                                    lieuService.deleteLieuById(commandeDivisee[2]);
                                    System.out.println("La cache id=" + commandeDivisee[2] + " a été supprimée.");
                                }
                                break;
                            case "visite":
                                if (commandeDivisee[2].equalsIgnoreCase("all")) {
                                    visiteService.deleteAllVisites();
                                    System.out.println("Toutes les visites ont été supprimées.");
                                } else {
                                    visiteService.deleteVisiteById(commandeDivisee[2]);
                                    System.out.println("La cache id=" + commandeDivisee[2] + " a été supprimée.");
                                }
                                break;
                            default:
                                System.out.printf("L'objet '%s' n'est pas reconnu %n", commandeDivisee[1]);
                        }
                    break;
                case "quitter":
                    System.out.println("Fin de la sesion de test.");
                    break;
                default:
                    System.out.printf("La commande %s n'existe pas.", commandeDivisee[0]);
            }
        }

    }
}
