package marc.nikita.trivial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Vista_1.fxml"));
        Pane root = loader.load();

        Scene scene1 = new Scene(root, 600, 400);
        primaryStage.setScene(scene1);
        primaryStage.show();

        // Crear y ejecutar un nuevo hilo para la conexión del socket
        SocketThread socketThread = new SocketThread();
        socketThread.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class SocketThread extends Thread {
    private static final String HOST_NAME = "127.0.0.1";
    private static final int PORT_NUMBER = 1234;

    @Override
    public void run() {
        try (Socket echoSocket = new Socket(HOST_NAME, PORT_NUMBER);
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connectat al servidor Echo. Escriu un missatge:");

            String userInput;
            String nom;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
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
