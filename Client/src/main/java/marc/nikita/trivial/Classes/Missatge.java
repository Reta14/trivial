package marc.nikita.trivial.Classes;

import com.google.gson.Gson;

public class Missatge {
    private String contingut;
    private String clau;

    private static Gson gson = new Gson();

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

    public String getJson(){
        return gson.toJson(this);
    }
}
