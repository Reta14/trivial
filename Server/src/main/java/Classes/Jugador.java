package Classes;

public class Jugador {
    private String nom;
    private int punts;

    public Jugador(String nom, int punts) {
        this.nom = nom;
        this.punts = punts;
    }

    public int getPunts() {
        return punts;
    }

    public void setPunts(int punts) {
        this.punts = punts;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
