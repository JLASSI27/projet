package services;

import entities.Seance;
import util.Datasource;
import entities.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ServiceReservation implements IService <Seance> {
    Connection con= Datasource.getInstance().getCon();

    @Override
    public void ajouter(Seance x) throws SQLException {
        String req = "insert into reservation values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(req);
        ps.setInt(1, x.getIdS());

     }

    @Override
    public void modifier(Seance x) throws SQLException {



    }

    @Override
    public void supprimer(int id) throws SQLException {

    }

    @Override
    public Seance getOneById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Seance> getAll() throws SQLException {
        return List.of();
    }
}
