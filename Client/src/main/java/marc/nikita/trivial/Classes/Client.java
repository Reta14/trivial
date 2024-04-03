package marc.nikita.trivial.Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client{
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

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

    public void cerrarConexion() {
        try {
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}