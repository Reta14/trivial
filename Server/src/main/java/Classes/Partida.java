package Classes;

import Enums.Tema;

public class Partida {
    private int id;
    private Tema tema;
    private Pregunta[] preguntes;
    private Jugador[] jugadors;

    public Partida(int id, Tema tema, Jugador[] jugadors) {
        this.id = id;
        this.tema = tema;
        this.jugadors = jugadors;
    }




}
