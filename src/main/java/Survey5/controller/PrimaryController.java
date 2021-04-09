package Survey5.controller;

import Survey5.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class PrimaryController {
    @FXML
    private Button startButton;

    @FXML
    private void startButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/LoginScene.fxml");
    }
}
