package org.example;

import util.Datasource;
import entities.Evenement;
import entities.Type;
import services.ServiceEvenement;

import java.sql.SQLException;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        ServiceEvenement se = new ServiceEvenement();
        Date date = new Date();
        Date date2 = new Date();
        Evenement e = new Evenement(date, date2, 3, "", Type.TENNIS, "");
        try {
            se.ajouter(e);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
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
    }
}

