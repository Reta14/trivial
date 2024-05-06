package Classes;


//{
//  tipus: Class/Missatge
//  contingut:


import com.google.gson.Gson;

public class Missatge {
    private String contingut;
    private String clau;

    private static Gson gson = new Gson();

    public Missatge(String contingut, String clau) {
        this.contingut = contingut;
        this.clau = clau;
    }

    public Missatge() {
    }

    public String getClau() {
        return clau;
    }

    public void setClau(String clau) {
        this.clau = clau;
    }

    public String getContingut() {
        return contingut;
    }

    public void setContingut(String contingut) {
        this.contingut = contingut;
    }
    public String getJson(){
        return gson.toJson(this);
    }

    public void fromJsonToMissatge(String json){
        Missatge missatge = gson.fromJson(json, Missatge.class);
        this.contingut = missatge.getContingut();
        this.clau = missatge.getClau();
    }
}
