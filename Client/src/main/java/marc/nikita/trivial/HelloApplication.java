package marc.nikita.trivial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import marc.nikita.trivial.Classes.Client;

import java.io.IOException;


public class HelloApplication extends Application {

    private Client client = Client.getInstance();

    @Override
    public void start(Stage stage) throws IOException {
        stage.setOnCloseRequest(event ->{
            handleClose();
        });

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Vista_1.fxml"));

        Scene scene = new Scene(loader.load());
        stage.setTitle("Trivial");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

    private void handleClose(){
        client.cerrarConexion();
        System.exit(0);
    }


}


