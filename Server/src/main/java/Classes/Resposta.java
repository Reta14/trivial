package Classes;

public class Resposta {
    private int punts;
    private String resposta;

    public Resposta(int punts, String resposta) {
        this.punts = punts;
        this.resposta = resposta;
    }

    public int getPunts() {
        return punts;
    }

    public String getResposta() {
        return resposta;
    }
}
