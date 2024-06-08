package entities;

public class Reclamation {


    private int idRec;
    private String categorieR;
    private String description;
    private int idU;
    private String etat;

    public Reclamation() {
    }

    public Reclamation(String categorieR, String description, int idU, String etat) {
        this.idRec = idRec;
        this.categorieR = categorieR;
        this.description = description;
        this.idU = idU;
        this.etat = etat;
    }



    public int getIdRec() {
        return idRec;
    }

    public void setIdRec(int idRec) {
        this.idRec = idRec;
    }

    public String getCategorieR() {
        return categorieR;
    }

    public void setCategorieR(String categorieR) {
        this.categorieR = categorieR;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Reclamation{" +
                "idRec=" + idRec +
                ", categorieR='" + categorieR + '\'' +
                ", description='" + description + '\'' +
                ", idU=" + idU +
                ", etat='" + etat + '\'' +
                '}';
    }
}

