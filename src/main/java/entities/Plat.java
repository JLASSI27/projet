package entities;

public class Plat {
    private int idP;
    private String nomP;
    private Float prixP;
    private String descP;
    private String alergieP;
    private Boolean etatP;
    private Float rate;
    private int calories;



    public Plat(String nomP, Float prixP,String descP, String alergieP, Boolean etatP , Float rate , int calories) {
        this.nomP = nomP;
        this.prixP = prixP;
        this.descP = descP;
        this.alergieP = alergieP;
        this.etatP = etatP;
        this.rate = rate;
        this.calories = calories;
    }
    public Plat(String nomP, Float prixP,String descP, String alergieP, Boolean etatP  , int calories) {
        this.nomP = nomP;
        this.prixP = prixP;
        this.descP = descP;
        this.alergieP = alergieP;
        this.etatP = etatP;
        this.calories = calories;
    }
    public Plat(String nomP, Float prixP, String alergieP, Boolean etatP ) {
        this.nomP = nomP;
        this.prixP = prixP;
        this.alergieP = alergieP;
        this.etatP = etatP;

    }


    public Plat( int idP, String nomP, Float prixP,String descP, String alergieP, Boolean etatP , Float rate , int calories) {
        this.idP = idP;
        this.nomP = nomP;
        this.prixP = prixP;
        this.descP = descP;
        this.alergieP = alergieP;
        this.etatP = etatP;
        this.rate = rate;
        this.calories = calories;
    }

    public Plat() {
        
    }


    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public Float getPrixP() {
        return prixP;
    }

    public float getrate() {
        return rate;
    }

    public void setrate(Float rate) {
        this.rate = rate;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setPrixP(Float prixP) {
        this.prixP = prixP;
    }

    public String getDescP() {
        return descP;
    }

    public void setDescP(String descP) {
        this.descP = descP;
    }

    public String getAlergieP() {
        return alergieP;
    }

    public void setAlergieP(String alergieP) {
        this.alergieP = alergieP;
    }

    public Boolean getEtatP() {
        return etatP;
    }

    public void setEtatP(Boolean etatP) {
        this.etatP = etatP;
    }

    @Override
    public String toString() {
        return "Plat{" +
                "idP=" + idP +
                ", nomP='" + nomP + '\'' +
                ", prixP=" + prixP +
                ", descP='" + descP + '\'' +
                ", alergieP='" + alergieP + '\'' +
                ", etatP=" + etatP +
                ", calories=" + calories +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plat plat = (Plat) o;
        return idP == plat.idP;
    }

    @Override
    public int hashCode() {
        return idP;
    }

    public float getRate() {
        return 0;
    }

    public int getIdp() {
        return 0;
    }

    public void setRate(float v) {
    }
}


