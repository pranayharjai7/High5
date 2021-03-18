package Survey5;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController {

    private Data data = new Data();
    private Alert warn = new Alert(Alert.AlertType.WARNING);
    private Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    
    @FXML
    public void loginButtonClicked(ActionEvent event){
        if(data.checkUsername(usernameTextField.getText())){
            if(data.checkPassword(passwordField.getText())){
                confirm.setContentText("Login Successful!");
                confirm.showAndWait();
            }
            else{
                warn.setContentText("Password entered is incorrect.. Please try again.");
                warn.showAndWait();
            }
        }
        else{
            warn.setContentText("Entered Username Doesn't Exist!");
            warn.showAndWait();
        }
    }
    
    @FXML
    public void registerClassOpenerClicked(ActionEvent event){
        try {
            App.setRoot("RegisterScene");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
