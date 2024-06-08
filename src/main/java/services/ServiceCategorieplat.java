package services;

import entities.Categorieplat;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class ServiceCategorieplat implements IService<Categorieplat>{
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

    public abstract void supprimer(int id) throws SQLException;

    @Override
    public Categorieplat getOneById(int idC) throws SQLException {
        return null;
    }

    @Override
    public List<Categorieplat> getAll() throws SQLException {
        return null;
    }
}


