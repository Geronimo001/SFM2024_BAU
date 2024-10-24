package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

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
        String login = loginCheck();
        if (login.equals("doctor")) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DoctorFXML.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Vizsgálat");
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.setTitle("BAU");
                Image image = new Image(App.class.getResourceAsStream("images/baulog.png"));
                stage.getIcons().add(image);
                stage.show();
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    String loginCheck()
    {
        if(username.getText().isEmpty() || password.getText().isEmpty()) {
            new Alerts().ErrorAlert("Nem megfelelő bejelentkezési paraméterek.", "Kötelező kitölteni mindkét mezőt!");
            return "";
        }
        return "doctor";
        //Will expand it
    }

}