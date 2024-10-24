package org.example;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Alerts {
    private String header;
    private String message;


    public Alerts() {
        //empty constructor
    }

    public void ErrorAlert(String header, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Hiba");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.getButtonTypes().setAll(new ButtonType("Bezárás"));
        alert.showAndWait();
    }

    public void VisitAlert(String header, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Vizsgálat lezárása");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.getButtonTypes().setAll(new ButtonType("Nem jelent meg"), new ButtonType("Gyógyszer felírása"), new ButtonType("Műtét javasolt"));
        alert.showAndWait();
    }
}
