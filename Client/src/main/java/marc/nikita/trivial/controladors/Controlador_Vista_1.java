package marc.nikita.trivial.controladors;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import marc.nikita.trivial.Classes.Client;
import marc.nikita.trivial.Classes.Missatge;
import marc.nikita.trivial.HelloApplication;

import java.io.IOException;

public class Controlador_Vista_1 {
    @FXML
    private TextField idTFNom;
    @FXML
    private Button idJugar;
    @FXML
    private Button idSortir;
    private Client client = Client.getInstance();


    @FXML
    public String nomJugador() {
        return idTFNom.getText();
    }

    @FXML
    private void handleJugarButtonAction() throws IOException {

        String nomJugador = idTFNom.getText();
        Missatge missatge = new Missatge(nomJugador, "nomJugador" );
        client.enviarMensaje(missatge.getJson());

        // Cargar la segunda vista y mostrarla
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Vista_2.fxml"));
        Pane vista2 = loader.load();

        // Obtener la escena actual y la ventana principal
        Scene scene = idJugar.getScene();
        Stage stage = (Stage) scene.getWindow();

        // Establecer la nueva escena en la ventana principal
        scene.setRoot(vista2);
        stage.setScene(scene);
    }

    @FXML
    private void handleSortirButtonAction() {
        client.cerrarConexion();
        // Cerrar la aplicación
        System.exit(0);
    }
}
