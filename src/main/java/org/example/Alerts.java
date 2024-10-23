package org.example;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Alerts {
    private String header;
    private String message;

    public Alerts(String header, String message) {
        this.header = header;
        this.message = message;
    }

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Hiba");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.getButtonTypes().setAll(new ButtonType("Bezárás"));
        alert.showAndWait();
    }
}
