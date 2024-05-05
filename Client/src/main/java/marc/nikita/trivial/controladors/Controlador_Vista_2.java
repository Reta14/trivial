package marc.nikita.trivial.controladors;
import connexions.SocketThread;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import marc.nikita.trivial.HelloApplication;

import java.io.IOException;

public class Controlador_Vista_2 {

    @FXML
    private Button idEsports;
    @FXML
    private Button idCulturaGeneral;
    @FXML
    private Button idEntreteniment;
    @FXML
    private Button idInformatica;

    String tema;

    @FXML
    private void handleEsportsButtonAction() throws IOException {
        // mostrar eleccion de tema
        System.out.println("Esports");
        tema = "Tema: Esports";
        // Cargar la segunda vista y mostrarla
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Vista_3.fxml"));
        Pane vista3 = loader.load();
        //Obtener la escena actual y la ventana principal
        Scene scene = idEsports.getScene();
        Stage stage = (Stage) scene.getWindow();

        // Establecer la nueva escena en la ventana principal
        scene.setRoot(vista3);
        stage.setScene(scene);

        SocketThread.enviarTema(tema);



    }

    @FXML
    private void handleCulturaGeneralButtonAction() throws IOException {
        // Mostrar eleccion de tema
        System.out.println("Cultura General");
        tema = "Tema: Cultura General";
        // Cargar la segunda vista y mostrarla
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Vista_3.fxml"));
        Pane vista3 = loader.load();
        //Obtener la escena actual y la ventana principal
        Scene scene = idCulturaGeneral.getScene();
        Stage stage = (Stage) scene.getWindow();

        //Establecer la nueva escena en la ventana principal
        scene.setRoot(vista3);
        stage.setScene(scene);

        SocketThread.enviarTema(tema);
    }

    @FXML
    private void handleEntretenimentButtonAction() throws IOException {
        // Mostrar eleccion de tema
        System.out.println("Entreteniment");
        tema = "Tema: Entreteniment";
        // Cargar la segunda vista y mostrarla
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Vista_3.fxml"));
        Pane vista3 = loader.load();
        //Obtener la escena actual y la ventana principal
        Scene scene = idEntreteniment.getScene();
        Stage stage = (Stage) scene.getWindow();

        //Establecer la nueva escena en la ventana principal
        scene.setRoot(vista3);
        stage.setScene(scene);

        SocketThread.enviarTema(tema);
    }

    @FXML
    private void handleInformaticaButtonAction() throws IOException {
        // Mostrar eleccion de tema
        System.out.println("Informàtica");
        tema = "Tema: Informàtica";
        // Cargar la segunda vista y mostrarla
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Vista_3.fxml"));
        Pane vista3 = loader.load();
        //Obtener la escena actual y la ventana principal
        Scene scene = idInformatica.getScene();
        Stage stage = (Stage) scene.getWindow();

        //Establecer la nueva escena en la ventana principal
        scene.setRoot(vista3);
        stage.setScene(scene);

        SocketThread.enviarTema(tema);
    }


}
