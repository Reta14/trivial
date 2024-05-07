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
    private int numPreguntaActual;

    public Partida(String tema, Jugador[] jugadors) {
        this.tema = tema;
        this.jugadors = jugadors;
        this.preguntes = Pregunta.getPreguntesFromAPI(tema);
    }

    public Pregunta[] getPreguntes() {
        return preguntes;
    }

    public Pregunta getPreguntaActual() {
        return preguntes[numPreguntaActual];
    }

    public void setPreguntaActual() {

    }

    public int getNumPreguntaActual() {
        return numPreguntaActual;
    }

    public void setNumPreguntaActual(int numPreguntaActual) {
        this.numPreguntaActual = numPreguntaActual;
    }

    public boolean nextPregunta() {
        if (numPreguntaActual < preguntes.length - 1) {
            numPreguntaActual++;
            return true;
        }else{
            return false;
        }
    }
}
