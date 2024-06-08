package org.example;

import entities.Participation;
import entities.Utilisateur;
import services.ServiceParticipation;
import util.Datasource;
import entities.Evenement;
import entities.Type;
import services.ServiceEvenement;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        ServiceEvenement se = new ServiceEvenement();
        Date date = new Date();
        Date date2 = new Date();
        Evenement e = new Evenement(date, date2, 3, "", Type.TENNIS, "");
        try {
        //    se.ajouter(e);
      //  } catch (SQLException ex) {
          //  System.out.println(ex.getMessage());
       // }
        e.setIdEv(1);
        e.setDateD(new Date());
        e.setDateF(new Date());
        e.setType(Type.BODYBUILD);
        e.setNbMax(100);
        e.setLieux("Lieu modifié");
        e.setImage_eve("Image modifiée");

        try {
            se.modifier(e);
            System.out.println("Evenement modifié !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        se.supprimer(e.getIdEv());
        System.out.println("Événement supprimé !");

        List<Evenement> evenements = se.getAll();
        for (Evenement ev : evenements) {
            System.out.println("ID : " + ev.getIdEv());
            System.out.println("Type : " + ev.getType());
            System.out.println("Date de début : " + ev.getDateD());
            System.out.println("Date de fin : " + ev.getDateF());
            System.out.println("Nombre maximal de participants : " + ev.getNbMax());
            System.out.println("Lieu : " + ev.getLieux());
            System.out.println("Image : " + ev.getImage_eve());
            System.out.println("---------------");
        }
    } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        ServiceParticipation sp = new ServiceParticipation();

    // Ajout d'une participation
    Participation p = new Participation("Nom", "Prenom", 20, "email@example.com", new Evenement(new Date(), new Date(), 3, "", Type.TENNIS, "");
     sp.ajouter(p);
        System.out.println("Participation ajoutée !");

    // Récupération de la participation par ID
    Participation participation = sp.getOneById(p.getId_p());
        System.out.println("Participation récupérée : " + participation.getNom_p());

    // Modification de la participation
        participation.setNom_p("Nom modifié");
        sp.modifier(participation);
        System.out.println("Participation modifiée !");

    // Suppression de la participation
        sp.supprimer(p.getId_p());
        System.out.println("Participation supprimée !");

    // Récupération de toutes les participations
    List<Participation> participations = sp.getAll();
        for (Participation p2 : participations) {
        System.out.println("Nom : " + p2.getNom_p());
        System.out.println("Prénom : " + p2.getPrenom_p());
        System.out.println("Âge : " + p2.getAge());
        System.out.println("Email : " + p2.getEmail());
        System.out.println("---------------");
    }
}
}






