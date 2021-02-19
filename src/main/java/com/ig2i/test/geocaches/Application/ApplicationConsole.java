package com.ig2i.test.geocaches.Application;

import com.ig2i.test.geocaches.BDD.MySQL.Cache.CacheEntity;
import com.ig2i.test.geocaches.BDD.MySQL.Lieu.LieuEntity;
import com.ig2i.test.geocaches.BDD.MySQL.Visite.VisiteEntity;
import com.ig2i.test.geocaches.Interfaces.Service.*;
import com.ig2i.test.geocaches.BDD.MySQL.Utilisateur.UtilisateurEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

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
        while (!commande.equalsIgnoreCase("/q")) {
            System.out.println("\t======================================================"
            + "\n - /c |Commandes de l'application| "
            + "\t - /q |Termine la session de test|\n"
            + "\t======================================================\n");

            System.out.println("Veuillez entrer une commande :");
            commande = scanner.nextLine();
            String[] commandeDivisee = commande.split(" ");

            switch (commandeDivisee[0]) {
                case "/c" :
                    System.out.println("\t======================================================" +
                            "\t - /g [cache|lieu|utilisateur|visite] [id || all]"
                            + "\t - /getCacheParUtilisateur [id]"
                            + "\t - /getVisiteParDate [date] |Date au format dd/mm/yyyy|"
                            + "\t - /u [cache|lieu|utilisateur|visite] [id] [champ à update]"
                            + "\t - /d [cache|lieu|utilisateur|visite] [id || all]"
                            + "\t - /a [cache|lieu|utilisateur|visite] [valeurs_des_champs]"
                            + "\t\t - Template table cache : "
                            + "\t\t\t - /a cache coordonnees;description;type;nature;etat;id_lieu;id_utilisateur"
                            + "\t\t\t Notes : * Le champ \"nature\" doit contenir la valeur 'PHYSIQUE' ou 'VIRTUELLE'."
                            + "\t\t\t * Le champ \"etat\" doit contenir la valeur 'ACTIVEE', 'EN_COURS_ACTIVATION', 'FERMEE' ou 'SUSPENDUE'."
                            + "\t\t - Template table lieu : "
                            + "\t\t\t - /a lieu description"
                            + "\t\t - Template table utilisateur : "
                            + "\t\t\t - /a user pseudo;description;photo"
                            + "\t\t - Template table visite : "
                            + "\t\t\t - /a visite commentaire;photo;id_cache;id_utilisateur"
                            + "\t======================================================\n");
                case "/g":
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
                                System.out.printf("La table '%s' n'est pas présente en base %n", commandeDivisee[1]);
                        }
                    }
                    System.out.println("Commande non conforme.");
                    break;
                case "/getCacheParUtilisateur":
                    if (commandeDivisee[1] != null) {
                        System.out.println(cacheService.findCachesByUtilisateur(commandeDivisee[1]));
                    }
                case "/getVisiteParDate":
                    if (commandeDivisee[1] != null) {
                        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(commandeDivisee[1]);
                        System.out.println(visiteService.findVisitesByDate(date));
                    }
                case "/u":
                    if (commandeDivisee[1] != null && commandeDivisee.length == 4) {
                        String valeur;
                        switch (commandeDivisee[1]) {
                            case "cache":
                                System.out.println("Veuillez définir la valeur à insérer dans le champ " + commandeDivisee[3] + ":");
                                valeur = scanner.nextLine();
                                this.cacheService.updateCache(commandeDivisee[2], commandeDivisee[3], valeur);
                                break;
                            case "visite":
                                System.out.println("Veuillez définir la valeur à insérer dans le champ " + commandeDivisee[3] + ":");
                                valeur = scanner.nextLine();
                                this.visiteService.updateVisite(commandeDivisee[2], commandeDivisee[3], valeur);
                                break;
                            case "user":
                                System.out.println("Veuillez définir la valeur à insérer dans le champ " + commandeDivisee[3] + ":");
                                valeur = scanner.nextLine();
                                this.utilisateurService.updateUser(commandeDivisee[2], commandeDivisee[3], valeur);
                                break;
                            case "lieu":
                                System.out.println("Veuillez définir la valeur à insérer dans le champ " + commandeDivisee[3] + ":");
                                valeur = scanner.nextLine();
                                this.lieuService.updateLieu(commandeDivisee[2], commandeDivisee[3], valeur);
                                break;
                            default:
                                System.out.printf("La table '%s' n'est pas présente en base %n", commandeDivisee[1]);
                                throw new IllegalArgumentException("Objet invalide");
                        }
                    }
                    System.out.println("Commande non conforme.");
                    break;
                case "/a":
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
                                System.out.printf("La table '%s' n'est pas présente en base %n", commandeDivisee[1]);
                                throw new IllegalArgumentException("Objet invalide");
                        }
                        System.out.println("Commande non conforme.");
                        break;
                    }
                case "/d":
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
                                System.out.printf("La table '%s' n'est pas présente en base %n", commandeDivisee[1]);
                                throw new IllegalArgumentException("Objet invalide");
                        }
                    System.out.println("Commande non conforme.");
                    break;
                case "/q":
                    System.out.println("Fin de la sesion de test.");
                    break;
                default:
                    System.out.printf("La commande %s n'existe pas.", commandeDivisee[0]);
            }
        }

    }
}
