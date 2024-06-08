package org.example;

import Services.AbonnementService;
import Services.UtilisateurService;
import util.DataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UtilisateurService utilisateurService = new UtilisateurService();
        AbonnementService abonnementService = new AbonnementService(); // Create an instance of AbonnementService
        Scanner scanner = new Scanner(System.in);

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

            // Ajout de l'utilisateur
            utilisateurService.ajouter(connection, nouvelUtilisateur);
            int nouvelUtilisateurId = nouvelUtilisateur.getIdU();
            System.out.println("Nouvel utilisateur ajouté avec ID : " + nouvelUtilisateurId);

            // Demander l'ID de l'utilisateur à supprimer
            System.out.print("Entrez l'ID de l'utilisateur à supprimer : ");
            int idUtilisateurASupprimer = scanner.nextInt();
            utilisateurService.supprimer(idUtilisateurASupprimer);

            // Demander l'ID de l'utilisateur à consulter
            System.out.print("Entrez l'ID de l'utilisateur à consulter : ");
            int idUtilisateurAConsulter = scanner.nextInt();
            org.example.Utilisateur utilisateur = utilisateurService.consulter(idUtilisateurAConsulter);
            if (utilisateur != null) {
                System.out.println("Utilisateur consulté : " + utilisateur.getNomU());
            }

            // Recherche des utilisateurs par nom
            System.out.print("Entrez le nom de l'utilisateur à rechercher : ");
            scanner.nextLine(); // Consuming newline left-over
            String nomRecherche = scanner.nextLine();
            List<org.example.Utilisateur> utilisateursTrouves = utilisateurService.rechercher(nomRecherche);
            System.out.println("Utilisateurs trouvés sous nom tapé : " + utilisateursTrouves.size());

            // Tri des utilisateurs par nom
            List<org.example.Utilisateur> utilisateursTries = utilisateurService.trierParNom();
            System.out.println("Utilisateurs triés : " + utilisateursTries.size());

            // Vérification de l'ID
            System.out.print("Entrez l'ID à vérifier : ");
            int idAVerifier = scanner.nextInt();
            boolean idExiste = utilisateurService.verifId(idAVerifier);
            System.out.println("ID existe : " + idExiste);

            // Mettre à jour le mot de passe
            System.out.print("Entrez l'ID de l'utilisateur pour réinitialiser le mot de passe : ");
            int idUtilisateurMdp = scanner.nextInt();
            System.out.print("Entrez le nouveau mot de passe : ");
            scanner.nextLine(); // Consuming newline left-over
            String nouveauMdp = scanner.nextLine();
            utilisateurService.oublierMdp(idUtilisateurMdp, nouveauMdp);

            // Modification de l'utilisateur
            System.out.print("Entrez l'ID de l'utilisateur à modifier : ");
            int idUtilisateurAModifier = scanner.nextInt();
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
            org.example.Abonnement newAbonnement = new org.example.Abonnement();
            newAbonnement.setMontant(100.0f);
            newAbonnement.setDateExpiration(new Date());
            newAbonnement.setCodePromo("PROMO2023");
            newAbonnement.setTypeAbonnement("Premium");
            newAbonnement.setIdU(nouvelUtilisateurId);

            abonnementService.ajouterS(newAbonnement);
            int newAbonnementId = newAbonnement.getIdA();
            System.out.println("Nouvel abonnement ajouté avec ID : " + newAbonnementId);

            // Modifier un abonnement
            System.out.print("Entrez l'ID de l'abonnement à modifier : ");
            int idAbonnementAModifier = scanner.nextInt();
            org.example.Abonnement modifiedAbonnement = new org.example.Abonnement();
            modifiedAbonnement.setMontant(200.0f);
            modifiedAbonnement.setDateExpiration(new Date());
            modifiedAbonnement.setCodePromo("PROMO2024");
            modifiedAbonnement.setTypeAbonnement("Gold");
            modifiedAbonnement.setIdU(nouvelUtilisateurId);

            abonnementService.modifierS(idAbonnementAModifier, modifiedAbonnement);

            // Consulter un abonnement
            System.out.print("Entrez l'ID de l'abonnement à consulter : ");
            int idAbonnementAConsulter = scanner.nextInt();
            org.example.Abonnement abonnement = abonnementService.consulter(idAbonnementAConsulter);
            if (abonnement != null) {
                System.out.println("Abonnement consulté : " + abonnement.getTypeAbonnement());
            }

            // Supprimer un abonnement
            System.out.print("Entrez l'ID de l'abonnement à supprimer : ");
            int idAbonnementASupprimer = scanner.nextInt();
            abonnementService.supprimerS(idAbonnementASupprimer);

            // Abonnement personnalisé
            System.out.print("Entrez l'ID de l'abonnement à personnaliser : ");
            int idAbonnementPersonnalise = scanner.nextInt();
            System.out.print("Entrez le nouveau code promo : ");
            scanner.nextLine(); // Consuming newline left-over
            String newCodePromo = scanner.nextLine();
            abonnementService.abonnementPersonnalise(idAbonnementPersonnalise, newCodePromo);

            // Rappel automatique
            abonnementService.rappelAutomatique();

            // Paiement abonnement
            System.out.print("Entrez l'ID de l'abonnement pour effectuer le paiement : ");
            int idAbonnementPaiement = scanner.nextInt();
            abonnementService.paiementAbonnement(idAbonnementPaiement);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
