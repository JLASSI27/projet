package services;

import entite.AvisPlat;
import services.IService;
import util.Datasource;
import util.Datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ServicesAvisPlat implements IService<AvisPlat> {
    private Connection cnx;

  public ServicesAvisPlat(){
      cnx= Datasource.getInstance().getCon();
  }
    @Override
    public void ajouter(AvisPlat x) throws SQLException {

    }

    @Override
    public void modifier(AvisPlat x) throws SQLException {

    }

    @Override
    public void supprimer(int id) throws SQLException {

    }

    @Override
    public AvisPlat getOneById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<AvisPlat> getAll() throws SQLException {
        return null;
    }
}
