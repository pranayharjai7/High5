package Survey5.controller;

import Survey5.model.Data;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class MyProfileController {
    private static Data data;

    public static void setData(Data data) {
        MyProfileController.data = data;
    }

    @FXML
    private Label nameLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label emailLabel;

    public void mouseEntered(MouseEvent mouseEvent) {
        nameLabel.setText(data.getName());
        usernameLabel.setText(data.getUsername());
        emailLabel.setText(data.getEmail());
    }
}
