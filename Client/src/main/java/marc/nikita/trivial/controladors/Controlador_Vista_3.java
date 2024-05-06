package marc.nikita.trivial.controladors;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import marc.nikita.trivial.Classes.Client;
import marc.nikita.trivial.Classes.Missatge;
import marc.nikita.trivial.Classes.Pregunta;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Controlador_Vista_3 {

    @FXML
    private Button idOp1;
    @FXML
    private Button idOp2;
    @FXML
    private Button idOp3;
    @FXML
    private Button idOp4;
    @FXML
    private TextArea TAPregunta;
    @FXML
    private TextArea TATemps;
    @FXML
    private TextArea TAResposta;
    private Client client = Client.getInstance();
    private Gson gson = new Gson();

    @FXML
    public void initialize() throws IOException {
        // Obtener la pregunta
        try {
            String missatge = client.recibirMensaje();
            System.out.println(missatge);
            Missatge m = new Missatge();
            m.fromJsonToMissatge(missatge);
            Pregunta p = gson.fromJson(m.getContingut(), Pregunta.class);
            TAPregunta.setText(p.getQuestion());
            List<String> options = p.getIncorrectAnswers();
            options.add(p.getCorrectAnswer());
            Collections.shuffle(options);
            idOp1.setText(options.get(0));
            idOp2.setText(options.get(1));
            idOp3.setText(options.get(2));
            idOp4.setText(options.get(3));
        }catch (IOException e){
            e.printStackTrace();
        }
        // Crear un contador de 20 segundos
        final int[] counter = {20};

        // Crear una nueva Timeline
        Timeline timeline = new Timeline();

        // Crear un KeyFrame que se ejecute cada segundo
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
            // Decrementar el contador
            counter[0]--;

            // Actualizar el TextArea
            TATemps.setText(String.valueOf(counter[0]));

            // Si el contador llega a 0, detener la Timeline
            if (counter[0] <= 0) {
                timeline.stop();
            }
        });

        // Añadir el KeyFrame a la Timeline
        timeline.getKeyFrames().add(keyFrame);

        // Establecer el ciclo de la Timeline para que se ejecute una vez
        timeline.setCycleCount(20);

        // Iniciar la Timeline
        timeline.play();
    }

    @FXML
    private void handleOpcionButtonAction(ActionEvent event) {
        Button button = (Button) event.getSource();
        String op = button.getText();
        Missatge missatge = new Missatge(op, "respostaPregunta");
        client.enviarMensaje();
    }


    @FXML
    private void handleOp1ButtonAction() {
        // Mostrar eleccion de tema
        System.out.println("Opcion 1");



    }

    @FXML
    private void handleOp2ButtonAction() {
        // Mostrar eleccion de tema
        System.out.println("Opcion 2");
    }

    @FXML
    private void handleOp3ButtonAction() {
        // Mostrar eleccion de tema
        System.out.println("Opcion 3");
    }

    @FXML
    private void handleOp4ButtonAction() {
        // Mostrar eleccion de tema
        System.out.println("Opcion 4");
    }

}
