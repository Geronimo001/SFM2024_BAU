package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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

    }

}
