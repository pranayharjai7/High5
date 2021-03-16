package Survey5;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController {

    Data data = new Data();
    
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    
    @FXML
    public void loginButtonClicked(ActionEvent event){
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
    
    @FXML
    public void registerClassOpenerClicked(ActionEvent event){
        try {
            App.setRoot("RegisterScene");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
