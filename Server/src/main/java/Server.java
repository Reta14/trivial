import Classes.Jugador;
import Classes.Missatge;
import Classes.Partida;
import Classes.Pregunta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private static Jugador jugador;
    private static Partida partida;

    public Server() {
    }

    public void startServer(int port){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Servidor en linea...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            String clientIp = clientSocket.getInetAddress().getHostAddress();
            System.out.println("Cliente conectado desde " + clientIp);

            // Configurar flujo de entrada y salida para el cliente
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Leer mensaje del cliente
            String mensaje;
            while ((mensaje = in.readLine()) != null) {
                Missatge missatge = new Missatge();
                missatge.fromJsonToMissatge(mensaje);
                gestionarMissatge(missatge, clientIp);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public String receiveMessage() throws IOException {
        return in.readLine();
    }

    public void closeConnection() {
        try {
            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.startServer(1234);

    }

    private void gestionarMissatge(Missatge missatge, String clientIp) {
        switch (missatge.getClau()) {
            case "nomJugador":
                crearJugador(missatge, clientIp);
                break;
            case "temaPartida":
                crearPartida(missatge);
                break;
            case "respostaPregunta":

        }
    }

    private void crearJugador(Missatge missatge, String clientIp) {
        String nom = missatge.getContingut();
        jugador = new Jugador(nom, 0, clientIp);
    }

    private void crearPartida(Missatge missatge) {
        String tema = missatge.getContingut();
        partida = new Partida(tema,new Jugador[]{jugador});
    }

    private void respondrePregunta(Missatge missatge, String clientIp) {

    }
}
