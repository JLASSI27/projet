package services;

import entities.Utilisateur;
import util.Datasource;
import entities.Evenement;
import entities.Participation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceParticipation implements IService<Participation>{

    //SessionManagement ss=new SessionManagement();
    //String mail=ss.getEmail;
    //UserService us=new UserService();
    //User u =us.getOneByEmail(mail);


    Connection cnx = Datasource.getInstance().getCon();

    @Override
    public void ajouter(Participation p) throws SQLException{

        String req = "INSERT INTO `participation`( `nom_p`,`prenom_p`, `age`,`email` , `id_p` , `id_Utilisateur`) VALUES (?,?,?,?,?,?)";

        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1,p.getNom_p());
        ps.setString(2,p.getPrenom_p());
        ps.setInt(3,p.getAge());
        ps.setString(4,p.getEmail());
        ps.setInt(5,p.getEvent().getIdEv());
        ps.setInt(6,p.getUtilisateur().getIdU());
        ps.executeUpdate();
        System.out.println("participation added !");


    }

    @Override
    public void modifier(Participation p) throws SQLException {
        String req = "UPDATE participation SET nom_p = ?, prenom_p = ?, age = ?, email = ?, idf_event = ? WHERE id_p = ?";

        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1,p.getNom_p());
        ps.setString(2,p.getPrenom_p());
        ps.setInt(3,p.getAge());
        ps.setString(4,p.getEmail());
        ps.setInt(5,p.getEvent().getIdEv());
        ps.setInt(6, p.getId_p()); // Spécification de l'ID de participation à modifier

        ps.executeUpdate();
        System.out.println("updated !");
    }

    @Override
    public void supprimer(int IdEv) {
        String sql = "delete from participation where id_p = ?";
        try {
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);
            preparedStatement.setInt(1, IdEv);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Participation getOneById(int id_p) {
        String req = "SELECT * FROM participation WHERE id_p = ?";
        Participation participation = null;
        try (PreparedStatement ps = cnx.prepareStatement(req)) {
            ps.setInt(1, id_p);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ServiceEvenement se = new ServiceEvenement();
                services.UtilisateurService utilisateur = new services.UtilisateurService();

                Evenement e = se.getOneById(rs.getInt("idf_event"));
                Utilisateur us = utilisateur.getOneByEmail();
                participation = new Participation(
                        rs.getString("nom_p"),
                        rs.getString("prenom_p"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        e,us);

                participation.getId_p(rs.getInt("Id_p"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return participation;
    }

    @Override
    public List<Participation> getAll() throws  SQLException{
        List<Participation> participations = new ArrayList<>();

        String req = "SELECT * FROM participation";
        PreparedStatement ps = cnx.prepareStatement(req);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ServiceEvenement se = new ServiceEvenement();
            //UserService userService = new UserService();

            Evenement e = se.getOneById(rs.getInt("idf_event"));
            Utilisateur utilisateur = UtilisateurService.getOneById(rs.getInt("id_User"));

            Participation participation = new Participation(
                    rs.getString("nom_p"),
                    rs.getString("prenom_p"),
                    rs.getInt("age"),
                    rs.getString("email"),
                    e,utilisateur);
            participation.getId_p(rs.getInt("Id_p"));
            participations.add(participation);
        }


        return participations;
    }

}
