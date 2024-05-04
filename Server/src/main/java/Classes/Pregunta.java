package Classes;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Pregunta {
    private String type;
    private String difficulty;
    private String category;
    private String question;
    private String correct_answer;
    private String[] incorrect_answers;

    private static Gson gson = new Gson();


    public static Pregunta[] getPreguntesFromAPI(String tema){
        String categoria = obtenirCategoria(tema);

        StringBuilder urlString = new StringBuilder("https://opentdb.com/api.php?amount=10");
        if (!categoria.equals("any"))
            urlString.append("&category=").append(categoria);
        urlString.append("&type=multiple");
        String urlFinal = urlString.toString();

        try {
            URL url = new URL(urlFinal);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Leer la respuesta de la URL
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                response.append(linea);
            }
            reader.close();

            // Guardar el JSON en un archivo o hacer lo que necesites con él
            String jsonString = response.toString();
            System.out.println("JSON obtenido:");
            System.out.println(jsonString);
            JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
            JsonArray preguntesJson = jsonObject.getAsJsonArray("results");
            Pregunta[] preguntes = new Pregunta[preguntesJson.size()];
            for (int i = 0; i < preguntesJson.size(); i++) {
                Pregunta pregunta = gson.fromJson(preguntesJson.get(i), Pregunta.class);
                preguntes[i] = pregunta;
            }

            conn.disconnect();
            return preguntes;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String obtenirCategoria(String tema){
        switch (tema){
            case "Sports":
                return "21";
            case "General Knowledge":
                return "9";
            case "History":
                return "23";
            case "Films":
                return "11";
        }
        return "any";
    }
}
