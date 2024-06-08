package org.example;

import Services.AbonnementService;
import Services.UtilisateurService;
import entities.AvisPlat;
import entities.Plat;
import services.ServicesAvisPlat;
import util.DataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UtilisateurService utilisateurService = new UtilisateurService();
        AbonnementService abonnementService = new AbonnementService();

        try (Connection connection = DataSource.getInstance().getConnexion()) {
            // Création d'un nouvel utilisateur
            org.example.Utilisateur nouvelUtilisateur = new org.example.Utilisateur();
            nouvelUtilisateur.setNomU("John");
            nouvelUtilisateur.setPrenomU("Doe");
            nouvelUtilisateur.setMdp("password");
            nouvelUtilisateur.setMailU("john.doe@example.com");
            nouvelUtilisateur.setTel(1234567890);
            nouvelUtilisateur.setStatut(true);
            nouvelUtilisateur.setDateNaissance(new Date());
=======

public static void main(String[] args) throws SQLException {
    ServicesAvisPlat se = new ServicesAvisPlat();!
    Date date =new Date();
    Date date2 =new Date();
    Evenement e = new Evenement(date, date2, 3,"", Type.TENNIS,"");
    try {
        se.ajouter(e);
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
>>>>>>> Stashed changes

            // Ajout de l'utilisateur
            utilisateurService.ajouter(connection, nouvelUtilisateur);

            // Suppression de l'utilisateur
            utilisateurService.supprimer(1);

            // Consultation de l'utilisateur
            org.example.Utilisateur utilisateur = utilisateurService.consulter(2);
            if (utilisateur != null) {
                System.out.println("Utilisateur consulté : " + utilisateur.getNomU());
            }

            // Recherche des utilisateurs par nom
            List<org.example.Utilisateur> utilisateursTrouves = utilisateurService.rechercher("John");
            System.out.println("Utilisateurs trouvés sous nom tapé : " + utilisateursTrouves.size());

            // Tri des utilisateurs par nom
            List<org.example.Utilisateur> utilisateursTries = utilisateurService.trierParNom();
            System.out.println("Utilisateurs triés : " + utilisateursTries.size());

            // Vérification de l'ID
            boolean idExiste = utilisateurService.verifId(2);
            System.out.println("ID existe : " + idExiste);

            // Mettre à jour le mot de passe
            utilisateurService.oublierMdp(3, "7856697");

            // Modification de l'utilisateur
            int idUtilisateurAModifier = 4; // Remplacez 4 par l'ID de l'utilisateur que vous souhaitez modifier
            org.example.Utilisateur utilisateurModifie = new org.example.Utilisateur();
            utilisateurModifie.setNomU("Malek");
            utilisateurModifie.setPrenomU("Benkacem");
            utilisateurModifie.setMdp("123456");
            utilisateurModifie.setMailU("malek.benkacem@esprit.com");
            utilisateurModifie.setTel(987654321);
            utilisateurModifie.setStatut(false);
            utilisateurModifie.setDateNaissance(new Date());

            utilisateurService.modifier(connection, idUtilisateurAModifier, utilisateurModifie);

            // Ajout d'un nouvel abonnement
            Abonnement newAbonnement = new Abonnement();
            newAbonnement.setMontant(100.0f);
            newAbonnement.setDateExpiration(new Date()); // Utilisez dateExpiration au lieu de dateExpedition
            newAbonnement.setCodePromo("PROMO2023");
            newAbonnement.setTypeAbonnement("Premium");
            newAbonnement.setIdU(nouvelUtilisateur.getIdU());

            abonnementService.ajouterS(newAbonnement);

            // Modifier un abonnement
            Abonnement modifiedAbonnement = new Abonnement();
            modifiedAbonnement.setMontant(200.0f);
            modifiedAbonnement.setDateExpiration(new Date()); // Utilisez dateExpiration au lieu de dateExpedition
            modifiedAbonnement.setCodePromo("PROMO2024");
            modifiedAbonnement.setTypeAbonnement("Gold");
            modifiedAbonnement.setIdU(nouvelUtilisateur.getIdU());

            abonnementService.modifierS(newAbonnement.getIdA(), modifiedAbonnement);

            // Consulter un abonnement
            Abonnement abonnement = abonnementService.consulter(newAbonnement.getIdA());
            if (abonnement != null) {
                System.out.println("Abonnement consulté : " + abonnement.getTypeAbonnement());
            }

            // Supprimer un abonnement
            abonnementService.supprimerS(newAbonnement.getIdA());

            // Abonnement personnalisé
            abonnementService.abonnementPersonnalise(newAbonnement.getIdA(), "NEWPROMO2024");

            // Rappel automatique
            abonnementService.rappelAutomatique();

            // Paiement abonnement
            abonnementService.paiementAbonnement(newAbonnement.getIdA());

            // Notification abonnement
            abonnementService.notificationAbonnement(newAbonnement.getIdA());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            ServicesAvisPlat platService = getServicesAvisPlat();

            // Supprimer un plat
            platService.supprimer(1);

            // Récupérer un plat par ID
            Plat platById = platService.getOneById(1).getPlat();

            // Récupérer tous les plats
            List<AvisPlat> tousLesPlats = platService.getAll();

        } catch (SQLException e) {
            System.out.println("Erreur de base de données : " + e.getMessage());
        }
    }

    private static ServicesAvisPlat getServicesAvisPlat() throws SQLException {
        false > 'platService = new ServicesPlat<>();

        // Créer un nouveau plat
        AvisPlat plat = new AvisPlat();
        plat.setNomP("Plat de test");
        plat.setPrixP(10.99F);
        plat.setDescP("Description du plat de test");
        plat.setAlergieP("Arachides");
        plat.setEtatP(true);
        plat.setRate(4.5F);
        plat.setCalories(500);
        ServicesAvisPlat platService = null;
        platService.ajouter(plat);

        // Modifier un Avisplat
        plat.setNomP("Nouveau nom du plat");
        plat.setPrixP(12.99F);
        platService.modifier(plat);
        return platService;
    }
}