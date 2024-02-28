module marc.nikita.trivial {
    requires javafx.controls;
    requires javafx.fxml;


    opens marc.nikita.trivial to javafx.fxml;
    exports marc.nikita.trivial;
}