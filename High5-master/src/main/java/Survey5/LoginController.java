package Survey5;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class LoginController {

    private Data data = new Data();
    private Alert warn = new Alert(Alert.AlertType.WARNING);
    private Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
  
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    
    
    
    public void loginButtonClicked(ActionEvent event) throws IOException {
        
       
        if(data.checkUsername(usernameTextField.getText())){
            if(data.checkPassword(passwordField.getText())){
                confirm.setContentText("Login Successful!");
                confirm.showAndWait();
         
             FXMLLoader loader=new FXMLLoader(getClass().getResource("SurveyScene.fxml"));
             Parent root=loader.load();
             Stage stage=new Stage();
             stage.setScene(new Scene(root));
             stage.setTitle("Covid 20 Survey");
             stage.resizableProperty().setValue(Boolean.FALSE);
             stage.show();
               
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
            
        }
    }   
}
