package marc.nikita.trivial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Vista_1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        //stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("Vista_2.fxml"));
        Scene scene2 = new Scene(fxmlLoader.load(), 600, 400);
        //stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        FXMLLoader fxmlLoader3 = new FXMLLoader(HelloApplication.class.getResource("Vista_3.fxml"));
        Scene scene3 = new Scene(fxmlLoader.load(), 600, 400);
        //stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        FXMLLoader fxmlLoader4 = new FXMLLoader(HelloApplication.class.getResource("Vista_4.fxml"));
        Scene scene4 = new Scene(fxmlLoader.load(), 600, 400);
        //stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}