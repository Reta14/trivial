package marc.nikita.trivial.controladors;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controlador_Vista_1 {
    @FXML
    private TextField idTFNom;
    @FXML
    private Button idJugar;
    @FXML
    private Button idSortir;


    @FXML
    public String nomJugador() {
        return idTFNom.getText();
    }

    @FXML
    private void handleJugarButtonAction() throws IOException {
        //String nomJugador = idTFNom.getText();
        // Cargar la segunda vista y mostrarla
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Vista_2.fxml"));
        Pane vista2 = loader.load();

        // Obtener la escena actual y la ventana principal
        Scene scene = idJugar.getScene();
        Stage stage = (Stage) scene.getWindow();

        // Establecer la nueva escena en la ventana principal
        scene.setRoot(vista2);
        stage.setScene(scene);

        //SocketThread.enviarNombre(nomJugador);
    }

    @FXML
    private void handleSortirButtonAction() {
        // Cerrar la aplicación
        System.exit(0);
    }
}
