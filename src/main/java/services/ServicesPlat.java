package service;
import entite.Plat;
import utile.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class ServicesPlat implements IService<Plat> {


    Connection cnx = Datasource.getInstance().getCon();

    @Override
    public void ajouter(Plat x) throws SQLException {

    }

    @Override
    public void modifier(Plat x) throws SQLException {

    }

    @Override
    public void supprimer(int id) throws SQLException {

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