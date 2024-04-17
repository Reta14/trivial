package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Pregunta {
    private String descripcio;
    private String[] respostes;
    private int indexRespostaCorrecte;


    private Pregunta[] getPreguntesFromAPI(){
        String urlString = "https://opentdb.com/api.php?amount=10&category=9&difficulty=easy&type=multiple"; // URL que devuelve un JSON

        try {
            URL url = new URL(urlString);
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

            // Aquí puedes procesar el JSON según tus necesidades

            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
