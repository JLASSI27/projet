package services;

import entities.*;
import util.*;
import java.sql.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceReservation implements IService <Reservation> {


    @Override
    public void ajouter(Reservation reservation) throws SQLException {
        String req="INSERT INTO 'reservation' (idRS,nom,prenom,email,tel,sexe,etat,idU) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps= con.prepareStatement(req);
        ps.setInt(1,reservation.getIdRs());
        ps.setString(2,reservation.getName());
        ps.setString(3,reservation.getPrenom());
        ps.setString(4,reservation.getEmail());
        ps.setFloat(5,reservation.getTel());
        ps.setString(6,String.valueOf(reservation.getSexe()));
        ps.setString(7,Reservation.getEtat());
        ps.setInt(8,reservation.getIdU());
        ps.executeUpdate();
        System.out.println("RESERVATION AJOUTER !");




    }

    @Override
    public void modifier(Reservation reservation) throws SQLException {
        String req= "UPDATE 'reservation' name=?,prenom=?,email=?,tel=?,sexe=?,etat=?,idU=? WHERE idRS=?";
        PreparedStatement ps= con.prepareStatement(req);
        ps.setInt(1,reservation.getIdRs());
        ps.setString(2,reservation.getName());
        ps.setString(3,reservation.getPrenom());
        ps.setString(4,reservation.getEmail());
        ps.setFloat(5,reservation.getTel());
        ps.setString(6,String.valueOf(reservation.getSexe()));
        ps.setString(7,Reservation.getEtat());
        ps.setInt(8,reservation.getIdU());
        ps.executeUpdate();
        System.out.println("RESERVATION MODIFIEE !");


    }

    @Override
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM `reservation` WHERE idRS = ?";

        PreparedStatement ps = con.prepareStatement(req);
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("RESERVATION SUPPRIMEE !");

    }

    @Override
    public Reservation getOneById(int id) throws SQLException {
        Reservation reservation = null;
        String req = "SELECT * FROM seance WHERE idRS = ?";
        ResultSet res;
        try (PreparedStatement ps = con.prepareStatement(req)) {
            ps.setInt(1, id);
            res = ps.executeQuery();
        }
        if (res.next()) {
            int idRS=res.getInt("idRS");
            String nom=res.getString("nom");
            String prenom=res.getString("prenom");
            String email=res.getString("email");
            float tel=res.getFloat("tel");
            Reservation.sexe s= Reservation.sexe.valueOf(res.getString("sexe"));
            String etat=res.getString("etat");
            int idU=res.getInt("idU");


            reservation = new Reservation(idRS,nom,prenom,email,tel,s,etat,idU);
        }

        return reservation;
    }


    @Override
    public List<Reservation> getAll() throws SQLException {
        List <Reservation> reservations = new ArrayList<>();

        String req = "Select * from reservation";

        Statement st = con.createStatement();
        ResultSet res = st.executeQuery(req);
        while (res.next()){
            int idRS =res.getInt(1);
            String nom = res.getString(2);
            String prenom = res.getString(3);
            String email = res.getString(4);
            float tel= res.getFloat(5);
            Reservation.sexe s= Reservation.sexe.valueOf(res.getString(6));
            String etat = res.getString(7);
            int idU=res.getInt(8);

            Reservation reservation=new Reservation(idRS,nom,prenom,email,tel,s,etat,idU);
            reservations.add(reservation);
        }

        return reservations;
    }
}
