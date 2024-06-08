package services;

import entities.Reclamation;
import util.Datasource;

import java.sql.*;
import java.util.List;

public class ReclamationService implements IService<Reclamation> {

    private Connection cnx;

    public ReclamationService() {
        cnx = Datasource.getInstance().getCon();
    }


    @Override
    public void ajouter(Reclamation r) throws SQLException {
        try {
            // Votre code de connexion et d'exécution SQL ici
            String query = "INSERT INTO reclamation (categorieR, description, IdU, etat) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = cnx.prepareStatement(query);
            preparedStatement.setString(1, r.getCategorieR());
            preparedStatement.setString(2, r.getDescription());
            preparedStatement.setInt(3, r.getIdU());
            preparedStatement.setString(4, r.getEtat());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void supprimer(int idRec) {
        try {
            String req = "DELETE FROM reclamation WHERE idRec = " + idRec;

            PreparedStatement ps  = cnx.prepareStatement(req);
            Statement ste  = cnx.createStatement();
            ste.executeUpdate(req);
            System.out.println("Reclamation supprimé !");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void modifier(Reclamation reclamation) throws SQLException {
        String request = "update reclamation set categorieR = ?, description = ?, IdU = ?,etat = ? where idREC = ?";
        try (PreparedStatement preparedStatement = cnx.prepareStatement(request)) {
            preparedStatement.setString(1, reclamation.getCategorieR());
            preparedStatement.setString(2, reclamation.getDescription());
            preparedStatement.setInt(3, reclamation.getIdU());
            preparedStatement.setString(4, reclamation.getEtat());
            preparedStatement.setInt(5, reclamation.getIdRec());

            preparedStatement.executeUpdate();
            System.out.println("Reclamation modifié !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Reclamation getOneById(int id) throws SQLException {String requete="select * from reclamation where idRec="+id;
        Reclamation r=null;
        try {
            Statement ste=cnx.createStatement();
            ResultSet rs=ste.executeQuery(requete);
            if(rs.next())
                r=new Reclamation(rs.getNString(2),
                        rs.getString(3),rs.getInt(4),rs.getString(5));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return r;
    }

    @Override
    public List<Reclamation> getAll() throws SQLException {
        return null;
    }

}