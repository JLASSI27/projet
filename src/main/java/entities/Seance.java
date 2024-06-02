package entities;

import java.util.Date;

public class Seance {
    private int idS;
    private String nomS;
    private Date date;
    private int duree;
    private String coach;
    private String salle;
    private int nb_place;

    public Seance(int idS, String nomS, int duree, Date date, String coach, String salle, int nb_place) {
        this.idS = idS;
        this.nomS = nomS;
        this.duree = duree;
        this.date = date;
        this.coach = coach;
        this.salle = salle;
        this.nb_place = nb_place;
    }

    public int getIdS() { return idS; }
    public void setIdS(int idS) {this.idS = idS; }
    public String getNomS() {return nomS;   }
    public void setNomS(String nomS) {this.nomS = nomS;  }
    public Date getDate() { return date; }
    public void setDate(Date date) {this.date = date;   }
    public int getDuree() {return duree; }
    public void setDuree(int duree) {this.duree = duree; }
    public String getCoach() {return coach;  }
    public void setCoach(String coach) {this.coach = coach;  }
    public String getSalle() {return salle; }
    public void setSalle(String salle) {this.salle = salle; }
    public int getNb_place() {return nb_place; }
    public void setNb_place(int nb_place) { this.nb_place = nb_place; }
}

