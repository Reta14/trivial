package marc.nikita.trivial.Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TestConnection {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost"; // Cambia esta dirección si el servidor está en otra máquina
        final int SERVER_PORT = 1234; // Cambia este puerto si es necesario

        try(Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {

            Missatge m = new Missatge();
            m.setClau("nom");
            m.setContingut("Nikita");
            int i = 0;
            // Enviar mensaje al servidor
            do {
                out.println(m.getJson());
                i++;
                Thread.sleep(1000);
            }while(i < 5);
            // Leer respuesta del servidor
            String respuesta = in.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
