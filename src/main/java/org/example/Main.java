package org.example;


import util.*;
import entities.*;
import services.*;
import java.sql.*;
import java.util.List;


public class Main {
    public static void main(String[] args)  {



     Seance s1=new Seance(0,"jlassi","27/07/86",30,"marwa","box",5);
     ServiceSeance ps=new ServiceSeance();
     try {
     // ps.ajouter(s1);
     Seance s2=new Seance(15,"jlff","27/07/86",30,"marwa","box",5);

     //  ps.modifier(s2);
     // ps.supprimer(16);
     //Seance t=  ps.getOneById(18);
     //System.out.println(t);
      List<Seance>list = ps.getAll();
      System.out.println(list);
      /* for (Seance seance : ps.getAll()) {
      System.out.println(seance);
      }*/

      } catch (SQLException e) {
      throw new RuntimeException(e);
     }
   }
}