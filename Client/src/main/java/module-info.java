module marc.nikita.trivial {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens marc.nikita.trivial to javafx.fxml, com.google.gson;
    exports marc.nikita.trivial;
    exports marc.nikita.trivial.controladors;
    opens marc.nikita.trivial.controladors to javafx.fxml;
    opens marc.nikita.trivial.Classes to com.google.gson;
}