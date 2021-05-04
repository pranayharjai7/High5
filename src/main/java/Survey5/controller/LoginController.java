package Survey5.controller;

import Survey5.MainApp;
import Survey5.model.Data;
import Survey5.model.DataDaoInterface;
import Survey5.model.DataManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;


public class LoginController {

    private int flag;
    private Alert warn = new Alert(Alert.AlertType.WARNING);
    private Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    DataDaoInterface dm = new DataManager();
    List<Data> dList;
    
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private void loginButtonClicked(ActionEvent event) throws IOException {
        flag = 0;
        dList = dm.getAllData();
        for (Data data: dList) {
            if(data.getUsername().equals(usernameTextField.getText())){
                if(data.getPassword().equals(passwordField.getText())) {
                    flag = 1;
                    AfterLoginMenuController.setUserdata(data);
                    break;
                }
            }
        }
        if(flag==1){
            confirm.setContentText("Login was Successful!");
            confirm.showAndWait();
            MainApp.setRoot("/fxml/AfterLoginMenu.fxml");
        }
        else{
            warn.setContentText("Either username or password was incorrect..\n Please try again..");
            warn.showAndWait();
        }
    }
    
    @FXML
    private void registerClassOpenerClicked(ActionEvent event) throws IOException {
            MainApp.setRoot("/fxml/RegisterScene.fxml");

    }
}
