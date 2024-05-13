package marc.nikita.trivial.Classes;

import com.google.gson.Gson;

public class Missatge {
    private String contingut;
    private String clau;

    // Instancia de Gson para convertir objetos a JSON y viceversa.
    private static Gson gson = new Gson();

    // Inicializa el contenido y la clave del mensaje.
    public Missatge(String contingut, String clau) {
        this.contingut = contingut;
        this.clau = clau;
    }

    public Missatge() {
    }

    public String getContingut() {
        return contingut;
    }

    public void setContingut(String contingut) {
        this.contingut = contingut;
    }

    public String getClau() {
        return clau;
    }

    public void setClau(String clau) {
        this.clau = clau;
    }

    // Método para convertir el objeto Missatge a JSON.
    public String getJson(){
        return gson.toJson(this);
    }

    // Método para convertir un JSON a un objeto Missatge.
    public void fromJsonToMissatge(String json){
        Missatge missatge = gson.fromJson(json, Missatge.class);
        this.contingut = missatge.getContingut();
        this.clau = missatge.getClau();
    }
}
