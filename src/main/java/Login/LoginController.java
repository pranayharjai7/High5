package Login;

import Register.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    Data data = new Data();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;


    @FXML
    private void loginButtonClicked(ActionEvent actionEvent) {
        if(data.checkUsername(usernameTextField.getText())){
            if(data.checkPassword(passwordField.getText())){
                System.out.println("Login Successful!");
            }
            else{
                System.out.println("Password Entered is incorrect..Try Again.");
            }
        }
        else{
            System.out.println("Entered Username Doesn't Exist!");
        }
    }
}
