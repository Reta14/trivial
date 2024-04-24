package marc.nikita.trivial;

import connexions.SocketThread;
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

import static connexions.SocketThread.nomJugador;


public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Vista_1.fxml"));
        Pane root = loader.load();

        Scene scene1 = new Scene(root, 600, 400);
        primaryStage.setScene(scene1);
        primaryStage.show();

        // Crear y ejecutar un nuevo hilo para la conexión del socket
        //String nomJugador = idTFNom.getText();
        SocketThread socketThread = new SocketThread(nomJugador);
        socketThread.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


