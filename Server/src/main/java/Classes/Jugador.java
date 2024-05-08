package Classes;

import pkgFitxers.Fitxers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Jugador implements Serializable {
    private String nom;
    private int punts;
    private String ip;
    private static String rutaFitxer = "puntuacio.dat";
    private static Fitxers f = new Fitxers();

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

    public void guardarJugador() {
        try {
            f.escriuObjecteFitxer(this, rutaFitxer, true);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public List<Jugador> getJugadores() {
        try {
            List<Jugador> jugadores = (List<Jugador>) f.retornaFitxerObjecteEnLlista(rutaFitxer, Jugador.class);
            return jugadores;
        }catch(InterruptedException | IOException | ClassNotFoundException | NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
        }
        return null;
    }
}

