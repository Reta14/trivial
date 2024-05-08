package marc.nikita.trivial.controladors;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import marc.nikita.trivial.Classes.Client;
import marc.nikita.trivial.HelloApplication;

import java.io.IOException;

public class Controlador_Vista_4 {
    @FXML
    private Button idTornaAJugar;
    @FXML
    private Button idSortirV4;

    private Client client = Client.getInstance();


    @FXML
    private void handleSortirButtonAction() {
        client.cerrarConexion();
        // Cerrar la aplicación
        System.exit(0);
    }

    @FXML
    private void handleTornaAJugarButtonAction() {
        try {
            // Cargar la vista inicial y mostrarla
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Vista_1.fxml"));
            Stage stage = (Stage) idTornaAJugar.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
