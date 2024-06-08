package services;

import entities.Categorieplat;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static services.IService.con;

public class ServiceCategorieplat implements services.Categorieplat {
    public void modifier(Categorieplat x) throws SQLException {
        String req = "UPDATE Categorieplat SET nomC = ?, descC= ?, etatC = ?  WHERE idC = ?";
        PreparedStatement ps = con.prepareStatement(req);
        entities.Categorieplat c = null;
        ps.setString(1, c.getNomC());
        ps.setString(2, c.getDescC());
        ps.setBoolean(3, c.getetatC());
        ps.setInt(4, c.getIdC());

        int rowsUpdated = ps.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Categorieplat modifie !");
        } else {
            System.out.println("idC incorrect");
        }
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM Categorieplat WHERE idC = ?";

        PreparedStatement ps = con.prepareStatement(req);
        int idC = 0;
        ps.setInt(1, idC);

        int rowsDeleted = ps.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Categorieplat supprime !");
        } else {
            System.out.println("idC incorrect");
        }

    }

    @Override
    public Categorieplat getOneById(int idC) throws SQLException {
        return null;
    }

    @Override
    public List<Categorieplat> getAll() throws SQLException {
        return null;
    }
}


