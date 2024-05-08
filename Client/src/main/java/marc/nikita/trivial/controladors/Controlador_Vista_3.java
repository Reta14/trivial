package marc.nikita.trivial.controladors;

import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import marc.nikita.trivial.Classes.Client;
import marc.nikita.trivial.Classes.Missatge;
import marc.nikita.trivial.Classes.Pregunta;
import marc.nikita.trivial.Classes.Resposta;
import marc.nikita.trivial.HelloApplication;

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
    private final int[] counter = {20};
    private ServerListener serverListener = new ServerListener();
    private Pregunta preguntaActual;

    @FXML
    public void initialize() throws IOException {
        // Obtener la pregunta
        try {
            String missatge = client.recibirMensaje();
            System.out.println(missatge);
            Missatge m = new Missatge();
            m.fromJsonToMissatge(missatge);
            Pregunta p = gson.fromJson(m.getContingut(), Pregunta.class);
            mostrarPregunta(p);
            serverListener.start();
        }catch (IOException e){
            e.printStackTrace();
        }
        // Crear un contador de 20 segundos


        // Crear una nueva Timeline
        Timeline timeline = new Timeline();

        // Crear un KeyFrame que se ejecute cada segundo
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
            // Decrementar el contador
            counter[0]--;

            // Actualizar el TextArea
            TATemps.setText(String.valueOf(counter[0]));

            // Si el contador llega a 0, detener la Timeline
//            if (counter[0] <= 0) {
//                timeline.stop();
//            }
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
        int punts = counter[0];
        Resposta resposta = new Resposta(punts, op);
        String respostaJson = gson.toJson(resposta);
        Missatge missatge = new Missatge(respostaJson, "respostaPregunta");
        client.enviarMensaje(missatge.getJson());
        TAResposta.setText(preguntaActual.getCorrectAnswer());
    }

    private class ServerListener extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    String missatge = client.recibirMensaje();
                    Missatge m = new Missatge();
                    m.fromJsonToMissatge(missatge);
                    if (m.getClau().equals("pregunta")) {
                        Pregunta p = gson.fromJson(m.getContingut(), Pregunta.class);
                        Platform.runLater(() -> {
                            // Deshabilitar los botones
                            idOp1.setDisable(true);
                            idOp2.setDisable(true);
                            idOp3.setDisable(true);
                            idOp4.setDisable(true);
                        });
                        Thread.sleep(2000);
                        Platform.runLater(() -> {
                            // Habilitar los botones
                            idOp1.setDisable(false);
                            idOp2.setDisable(false);
                            idOp3.setDisable(false);
                            idOp4.setDisable(false);
                            mostrarPregunta(p);
                        });
                    }else if(m.getClau().equals("puntuacio")){
                        Platform.runLater(() -> {
                            try {
                                mostrarResultats();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void mostrarPregunta(Pregunta p){
        preguntaActual = p;
        TAPregunta.setText(p.getQuestion());
        List<String> options = p.getIncorrectAnswers();
        options.add(p.getCorrectAnswer());
        Collections.shuffle(options);
        idOp1.setText(options.get(0));
        idOp2.setText(options.get(1));
        idOp3.setText(options.get(2));
        idOp4.setText(options.get(3));
        TAResposta.setText("");
        counter[0] = 20;
    }

    public void mostrarResultats() throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Vista_4.fxml"));
        Pane vista3 = loader.load();
        //Obtener la escena actual y la ventana principal
        Scene scene = TAPregunta.getScene();
        Stage stage = (Stage) scene.getWindow();

        // Establecer la nueva escena en la ventana principal
        scene.setRoot(vista3);
        stage.setScene(scene);
    }

}
