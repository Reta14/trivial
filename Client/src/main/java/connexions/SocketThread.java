package connexions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import static java.lang.System.out;


public class SocketThread extends Thread {
    private static final String HOST_NAME = "127.0.0.1";
    private static final int PORT_NUMBER = 1234;
    public static String nomJugador;

    public SocketThread(String nomJugador) {
        this.nomJugador = nomJugador;
    }

    public static void enviarNombre(String nomJugador) {
        if (out != null) {
            out.println(nomJugador);
        }
    }

    public static void enviarTema(String tema) {
        if (out != null) {
            out.println(tema);
        }
    }

    @Override
    public void run() {
        try (Socket echoSocket = new Socket(HOST_NAME, PORT_NUMBER);
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connectat al servidor Echo. Escriu un missatge:");

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                String messageToSend = userInput;
                if (nomJugador != null) {
                    messageToSend += nomJugador;
                }
                out.println(userInput + nomJugador);
                System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("No es coneix l'amfitrió " + HOST_NAME);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("No es pot obtenir la I/O per la connexió a " + HOST_NAME);
            System.exit(1);
        }

        }

    }
