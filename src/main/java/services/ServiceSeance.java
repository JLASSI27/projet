
package services;

import entities.Seance;
import util.*;
import java.sql.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceSeance implements IService <Seance>{

    Connection cnx=Datasource.getInstance().getCon();

    @Override
    public void ajouter(Seance seance) throws SQLException {
        String req=" INSERT INTO `seance` (Ids,`NomS`,`Date`,`Duree`,`Coach`,`salle`,`nb_place`) VALUES (?,?,?,?,?,?,?)";

        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1,seance.getIdS());
        ps.setString(2,seance.getNomS());
        ps.setString(3, seance.getDate());
        ps.setInt(4,seance.getDuree());
        ps.setString(5,seance.getCoach());
        ps.setString(6,seance.getSalle());
        ps.setInt(7,seance.getNb_place());
        ps.executeUpdate();
        System.out.println("Seance added !");    }

    @Override
    public void modifier(Seance seance) throws SQLException {
      //  String req = "UPDATE `seance` SET NomS=?, Date = ?, Duree = ?, Coach =?, salle=?,nb_place=? WHERE Ids = ?";
       // String req=" INSERT INTO `seance` (Ids,`NomS`,`Date`,`Duree`,`Coach`,`salle`,`nb_place`)
        String req = ("UPDATE seance SET NomS=?,Date=?,Duree=?,Coach=?,salle=?,nb_place=? WHERE Ids=?");

        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(7,seance.getIdS());
        ps.setString(1,seance.getNomS());
        ps.setString(2, seance.getDate());
        ps.setInt(3,seance.getDuree());
        ps.setString(4,seance.getCoach());
        ps.setString(5,seance.getSalle());
        ps.setInt(6,seance.getNb_place());
        int test=ps.executeUpdate();
        System.out.println("Seance modifier !"+test);

    }

    @Override
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM seance WHERE idS =?";

        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, id);
       int test=ps.executeUpdate();
        System.out.println("Seance supprimée !"+test);


    }

    @Override
    public Seance getOneById(int id)  throws SQLException{
        Seance seance = null;
        String req = "SELECT * FROM seance WHERE idS =?";
        ResultSet res;
        try (PreparedStatement ps = cnx.prepareStatement(req)) {
            ps.setInt(1, id);
            res = ps.executeQuery();
            if (res.next()) {
                String nom = res.getString("NomS");
                String date = res.getString("Date");
                int duree = res.getInt("Duree");
                String coach= res.getString("Coach");
                String salle = res.getString("SAlle");
                int nb_place= res.getInt("Nb_place");

                seance = new Seance(id,nom,date, duree, coach,salle,nb_place);
            }
        }


        return seance;
    }

    @Override
    public List<Seance> getAll()  throws SQLException{
        List <Seance> seances = new ArrayList<>();

        String req = "Select * from seance";

        Statement st = cnx.createStatement();
        ResultSet res = st.executeQuery(req);
        while (res.next()){
            int id =res.getInt(1);
            String nomS = res.getString(2);
            String date = res.getString(3);
            int duree = res.getInt(4);
            String coach= res.getString(5);
            String salle = res.getString(6);
            int nb_place= res.getInt(7);

            Seance seance = new Seance(id, nomS,date,duree,coach,salle,nb_place);
            seances.add(seance);
        }



        return seances;
    }

}
