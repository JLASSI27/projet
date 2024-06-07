package services;

import entities.Plat;
import util.Datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class ServicesPlat<Plat> implements IService<Plat> {


    Connection cnx = Datasource.getInstance().getCon();

    @Override
    public void ajouter(Plat x) throws SQLException {
        String req = "INSERT INTO `plat`(`nomP`, `prixP`, `descP`, `alergieP`, `etatP` , `rate` ,`calories`, `idP`) VALUES (?, ?, ?, ?, ? , ? , ?)";

        PreparedStatement ps = cnx.prepareStatement(req);
        entities.Plat p = null;
        ps.setString(1, p.getNomP());
        ps.setFloat(2, p.getPrixP());
        ps.setString(3, p.getDescP());
        ps.setString(4, p.getAlergieP());
        ps.setBoolean(5, p.getEtatP());
        ps.setFloat(6, p.getRate());
        ps.setInt(7, p.getCalories());
        ps.executeUpdate();
        System.out.println("Plat ajouté !");



    }

    @Override
    public void modifier(Plat x) throws SQLException {
        String req = "UPDATE plat SET nomP = ?, prixP = ?, descP = ?, alergieP = ?, etatP = ? , rate =? , calories = ? WHERE idP = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        entities.Plat p = null;
        ps.setString(1, p.getNomP());
        ps.setFloat(2, p.getPrixP());
        ps.setString(3, p.getDescP());
        ps.setString(4, p.getAlergieP());
        ps.setBoolean(5, p.getEtatP());
        ps.setFloat(6, p.getRate());
        ps.setInt(7, p.getCalories());
        ps.setInt(8, p.getIdP());

        int rowsUpdated = ps.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Plat modifie !");
        } else {
            System.out.println("id incorrect");
        }


    }

    @Override
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM plat WHERE idP = ?";

        PreparedStatement ps = cnx.prepareStatement(req);
        int idP = 0;
        ps.setInt(1, idP);

        int rowsDeleted = ps.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Plat supprime !");
        } else {
            System.out.println("id incorrect");
        }



    }

    @Override
    public Plat getOneById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Plat> getAll() throws SQLException {
        return null;
    }
}
