package marc.nikita.trivial.controladors;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import marc.nikita.trivial.Classes.Client;

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



}
