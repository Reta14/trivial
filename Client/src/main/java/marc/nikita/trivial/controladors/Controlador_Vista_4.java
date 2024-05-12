package marc.nikita.trivial.controladors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import marc.nikita.trivial.Classes.Client;
import marc.nikita.trivial.Classes.Jugador;
import marc.nikita.trivial.Classes.Missatge;
import marc.nikita.trivial.Classes.Pregunta;
import marc.nikita.trivial.HelloApplication;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Controlador_Vista_4 {
    @FXML
    private Button idTornaAJugar;
    @FXML
    private Button idSortirV4;
    @FXML
    private TableView TVRanking;

    private Client client = Client.getInstance();
    private static Gson gson = new Gson();

    public void initialize() {
        try {
            String missatge = client.recibirMensaje();
            System.out.println(missatge);
            Missatge m = new Missatge();
            m.fromJsonToMissatge(missatge);
            if (m.getClau().equals("puntuacio")) {
                getJugadors(m.getContingut());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

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

    private void getJugadors(String json) {
        Type listType = new TypeToken<List<Jugador>>(){}.getType();
        List<Jugador> jugadors = gson.fromJson(json, listType);
        Map<Integer, Jugador> mapJugadors = new HashMap<Integer, Jugador>();
        for (Jugador jugador : jugadors) {
            mapJugadors.put(jugador.getPunts(), jugador);
        }
        omplirTaulaPuntuacio(mapJugadors);
    }

    private void omplirTaulaPuntuacio(Map<Integer, Jugador> mapJugadors) {
        ObservableList<Jugador> jugadors = FXCollections.observableArrayList();
        Iterator it = mapJugadors.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            jugadors.add((Jugador) pair.getValue());
        }
        TableColumn colNom = new TableColumn("Nom");
        TableColumn colPunts = new TableColumn("Punts");

        colNom.setCellValueFactory(new PropertyValueFactory<Integer, String>("nom"));
        colPunts.setCellValueFactory(new PropertyValueFactory<Integer, Integer>("punts"));

        TVRanking.setItems(jugadors);
        TVRanking.getColumns().addAll(colNom, colPunts);

    }

}
