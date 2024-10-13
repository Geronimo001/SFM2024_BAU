package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    Stage stage;

    @FXML
    private Button exit_button;

    @FXML
    private Button login_button;

    @FXML
    private Button login_button2;

    @FXML
    private TextField usernameTextbox;

    @FXML
    private TextField usernameTextbox1;

    @FXML
    void exit(ActionEvent event) {
        stage = (Stage) exit_button.getScene().getWindow();
        System.out.println("Exit...");
        stage.close();
    }

    @FXML
    void login(ActionEvent event) {
        System.out.println("Login gomb megnyomva!");

        try {
            // Betöltjük a pacients.fxml-t (a páciensek listájának ablakát)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pacients.fxml"));

            Parent root = loader.load();

            // Új ablak létrehozása
            Stage pacientStage = new Stage();
            pacientStage.setTitle("Páciensek listája");
            pacientStage.setScene(new Scene(root));
            pacientStage.show();

            // A jelenlegi (login) ablak bezárása, ha szeretnéd
            Stage currentStage = (Stage) login_button.getScene().getWindow();
            currentStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}