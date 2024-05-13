package marc.nikita.trivial.Classes;

public class Jugador {
    private String nom;
    private int punts;
    private String ip;

    // Inicializa el nombre, los puntos y la dirección IP del jugador.
    public Jugador(String nom, int punts, String ip){
        this.nom = nom;
        this.punts = punts;
        this.ip = ip;
    }

    public String getNom() {
        return nom;
    }

    public int getPunts() {
        return punts;
    }

}
