package Register;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

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
