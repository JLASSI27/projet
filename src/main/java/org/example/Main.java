package org.example;

import Services.UtilisateurService;
import util.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UtilisateurService utilisateurService = new UtilisateurService();

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

            // Suppression de l'utilisateur
            utilisateurService.supprimer(41);

            // Consultation de l'utilisateur
            org.example.Utilisateur utilisateur = utilisateurService.consulter(36);
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
            boolean idExiste = utilisateurService.verifId(5);
            System.out.println("ID existe : " + idExiste);

            // Mettre à jour le mot de passe
            utilisateurService.oublierMdp(15, "7856697");

            // Modification de l'utilisateur
            int idUtilisateurAModifier = 10; // Remplacez 10 par l'ID de l'utilisateur que vous souhaitez modifier
            org.example.Utilisateur utilisateurModifie = new org.example.Utilisateur();
            utilisateurModifie.setNomU("Malek");
            utilisateurModifie.setPrenomU("Benkacem");
            utilisateurModifie.setMdp("123456");
            utilisateurModifie.setMailU("malek.benkacem@esprit.com");
            utilisateurModifie.setTel(987654321);
            utilisateurModifie.setStatut(false);
            utilisateurModifie.setDateNaissance(new Date());

            utilisateurService.modifier(connection, idUtilisateurAModifier, utilisateurModifie);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
