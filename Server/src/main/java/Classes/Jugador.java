package Classes;

public class Jugador {
    private String nom;
    private int punts;
    private String ip;

    public Jugador(String nom, int punts, String ip) {
        this.nom = nom;
        this.punts = punts;
        this.ip = ip;
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
