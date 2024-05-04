package Classes;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tema;
    private Pregunta[] preguntes;
    private Jugador[] jugadors;

    public Partida(String tema, Jugador[] jugadors) {
        this.tema = tema;
        this.jugadors = jugadors;
        this.preguntes = Pregunta.getPreguntesFromAPI(tema);
    }

}
