package org.example;

import entities.Reclamation;
import entities.Seance;
import services.ReclamationService;
import util.Datasource;
import java.util.Date;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        Reclamation r1=new Reclamation("qualitè de service","mal",1,"refusé");
        ReclamationService REC = new ReclamationService();


        System.out.println("1.Ajouter une nouvelle Reclamation");
        System.out.println("2. Modifier une Reclamation ");
        System.out.println("3. Afficher tous les reclamations ");
        System.out.println("4. Afficher reclamation by id");
        System.out.println("5. Supprimer reclamation");
        System.out.println("0. Quitter ");
        System.out.print("Choisis Crud: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                try {
                    // Insert the new Person into the database
                    REC.ajouter(r1);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                try {
                    // Update the Person in the database
                    Reclamation reclamation = new Reclamation();
                    System.out.print("Enter the id of the rec to update: ");
                    int id = scanner.nextInt();
                    reclamation.setIdRec(id); // Spécifiez l'ID de la réclamation à modifier
                    reclamation.setCategorieR("Problème technique"); // Spécifiez la nouvelle catégorie
                    reclamation.setDescription("azerty"); // Spécifiez la nouvelle description
                    reclamation.setIdU(1); // Spécifiez le nouvel utilisateur associé
                    reclamation.setEtat("En cours"); // Spécifiez le nouvel état
                    // Créez une instance de votre service de réclamation
                    ReclamationService service = new ReclamationService();
                    service.modifier(reclamation);

                    // Affichez un message de confirmation
                    System.out.println("Reclamation modifiée avec succès !");
                } catch (Exception e) {
                    System.out.println("Erreur lors de la modification de la réclamation : " + e.getMessage());

                }
                break;

            case 4:
                // Read the Person by id from the database
                System.out.print("Enter the id of the rec: ");
                int idRec = scanner.nextInt();
                Reclamation readrec = REC.getOneById(idRec);
                System.out.println("Read rec by id: " + readrec);
                break;
            case 5:
                // Delete the Person from the database
                System.out.print("Enter the id of the rec to delete: ");
                int id = scanner.nextInt();
                REC.supprimer(id);
                System.out.println("Deleted the rec with id: " + id);
                break;

            case 0:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid choice. Please enter a number between 0 and 5.");
        }
    }
}