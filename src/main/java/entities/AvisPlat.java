package entite;

import java.util.Objects;

public class AvisPlat{

  
        private int idAP;
        private String commAP;
        private int star;
        private Plat idPlat;
       // private User idU;

        

        public AvisPlat(int idAP, String commAP, int star, Plat idPlat  ) {
            this.idAP = idAP;
            this.commAP = commAP;
            this.star = star;
            this.idPlat = idPlat;
          //  this.idU = idU;
        }
       
        

        // Getters and setters
        public int getIdAP() {
            return idAP;
        }

        public void setIdAP(int idAP) {
            this.idAP = idAP;
        }

        public String getCommAP() {
            return commAP;
        }

        public void setCommAP(String commAP) {
            this.commAP = commAP;
        }

        public int getStar() {
            return star;
        }

        public void setStar(int star) {
            this.star = star;
        }



        public Plat getPlat() {return idPlat; }

        public void setPlat(Plat idPlat) {
            this.idPlat = idPlat;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AvisPlat avis = (AvisPlat) o;
            return idAP == avis.idAP;
        }

        @Override
        public int hashCode() {
            Objects Objects;
            return idAP;
        }

        @Override
        public String toString() {
            return "AvisP{" +
                    "idAP=" + idAP +
                    ", commAP='" + commAP + '\'' +
                    ", star=" + star +
                    '}';
        }
    }


