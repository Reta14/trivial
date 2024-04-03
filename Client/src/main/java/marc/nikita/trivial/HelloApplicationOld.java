package marc.nikita.trivial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class HelloApplicationOld extends Application {
    @Override
    public void start(Stage stage1) throws IOException {
        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplicationOld.class.getResource("Vista_1.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load(), 600, 400);
        stage1.setScene(scene1);
        stage1.show();

        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplicationOld.class.getResource("Vista_2.fxml"));
        Scene scene2 = new Scene(fxmlLoader2.load(), 600, 400);
        Stage stage2 = new Stage();
        stage2.setScene(scene2);
        stage2.show();

        FXMLLoader fxmlLoader3 = new FXMLLoader(HelloApplicationOld.class.getResource("Vista_3.fxml"));
        Scene scene3 = new Scene(fxmlLoader3.load(), 600, 400);
        Stage stage3 = new Stage();
        stage3.setScene(scene3);
        stage3.show();

        FXMLLoader fxmlLoader4 = new FXMLLoader(HelloApplicationOld.class.getResource("Vista_4.fxml"));
        Scene scene4 = new Scene(fxmlLoader4.load(), 600, 400);
        Stage stage4 = new Stage();
        stage4.setScene(scene4);
        stage4.show();

        String hostName = "127.0.0.1"; // Adreça IP del servidor
        int portNumber = 1234; // Port on escolta el servidor. Alerta, per norma el port ha de ser major de 1024



        try (Socket echoSocket = new Socket(hostName, portNumber);
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connectat al servidor Echo. Escriu un missatge:");

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("No es coneix l'amfitrió " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("No es pot obtenir la I/O per la connexió a " + hostName);
            System.exit(1);
        }

    }

    public static void main(String[] args) {

        launch();


    }
    }
