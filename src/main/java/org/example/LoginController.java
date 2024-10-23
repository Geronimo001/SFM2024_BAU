package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {

    Stage stage;

    @FXML
    private Button exit_button;

    @FXML
    private Button login_button;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    void exit(ActionEvent event) {
        stage = (Stage) exit_button.getScene().getWindow();
        stage.close();
    }

    @FXML
    void login(ActionEvent event) {
        loginCheck();
    }

    String loginCheck()
    {
        if(username.getText().isEmpty() || password.getText().isEmpty()) {
            Alerts alert = new Alerts("Nem megfelelő bejelentkezési paraméterek.", "Kötelező kitölteni mindkét mezőt!");
            alert.showAlert();
            return "";
        }
        return "doctor";
    }

}