package marc.nikita.trivial.controladors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import marc.nikita.trivial.Classes.Client;
import marc.nikita.trivial.Classes.Missatge;
import marc.nikita.trivial.HelloApplication;

import java.io.IOException;

public class Controlador_Vista_2 {

    @FXML
    private Button buttonSports;
    @FXML
    private Button buttonGeneralKnowledge;
    @FXML
    private Button buttonFilms;
    @FXML
    private Button buttonHistory;

    private String tema;
    private Client client = Client.getInstance();



    @FXML
    private void handleCategoryButtonAction(ActionEvent event) throws IOException {
        Button button = (Button) event.getSource();
        tema = button.getText();
        Missatge missatge = new Missatge(tema,"temaPartida" );
        client.enviarMensaje(missatge.getJson());

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Vista_3.fxml"));
        Pane vista3 = loader.load();
        //Obtener la escena actual y la ventana principal
        Scene scene = button.getScene();
        Stage stage = (Stage) scene.getWindow();

        // Establecer la nueva escena en la ventana principal
        scene.setRoot(vista3);
        stage.setScene(scene);

    }



}
