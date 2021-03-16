package Survey5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RegisterController {
    private Data d1 = new Data();

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private void registerButtonClicked(ActionEvent actionEvent) {

        if (!(d1.checkEmail(emailField.getText()))) {
            d1.addToFile(nameField.getText(), emailField.getText(), usernameField.getText(), passwordField.getText());
        }
        else{
            System.out.println("This Email Already exists!");
        }
    }
}
