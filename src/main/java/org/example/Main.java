package org.example;

import util.Datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
    public static void main(String[] args) throws SQLException {
        Datasource ds = new Datasource();
        Connection cnx=ds.getCon();


    }
}