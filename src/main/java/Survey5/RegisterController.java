package Survey5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegisterController {
    private Data d1 = new Data();
    private Alert warn = new Alert(Alert.AlertType.WARNING);
    private Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private void registerButtonClicked(ActionEvent actionEvent) throws IOException {

        if (!(d1.checkEmail(emailField.getText()))) {
            d1.addToFile(nameField.getText(), emailField.getText(), usernameField.getText(), passwordField.getText());
            confirm.setContentText("Registration Successful!");
            confirm.showAndWait();
        }
        else{
            warn.setContentText("This Email Already exists!");
            warn.showAndWait();
        }
        App.setRoot("LoginScene");
    }
}
