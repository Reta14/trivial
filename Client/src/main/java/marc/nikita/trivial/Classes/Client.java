package marc.nikita.trivial.Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// Se encarga de enviar y recibir mensajes.
public class Client{
    private static Client instance;    // Instancia estática de la clase Client para implementar el patrón Singleton.
    private Socket socket;  // Socket para la comunicación con el servidor.
    private PrintWriter out;
    private BufferedReader in;

    // Constructor de la clase Client.
    // Intenta establecer una conexión con el servidor en la dirección y puerto especificados.
    public Client(String direccionServidor, int puertoServidor) {
        try {
            socket = new Socket(direccionServidor, puertoServidor);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enviarMensaje(String mensaje) {
        out.println(mensaje);
    }

    public String recibirMensaje() throws IOException {
        return in.readLine();
    }

    public void cerrarConexion() {  // Cierra el PrintWriter, el BufferedReader y el Socket.
        try {
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Retorna instancia de la clase Client.
    // Si la instancia es null, crea una nueva instancia de la clase Client.

    public static Client getInstance() {
        if (instance == null) {
            instance = new Client("127.0.0.1", 1234);
            //instance = new Client("10.0.127.4", 1234);
        }
        return instance;
    }
}