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
import javafx.application.Application;
import javafx.stage.Stage;
import org.controlsfx.tools.Platform;

public class RegisterController {
    
    private static int flag;
    private static Alert warn = new Alert(Alert.AlertType.WARNING);
    private Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    DataDaoInterface dm = new DataManager();
    List<Data> dList;
    
    
    public RegisterController() {

    }

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    public void registerButtonClicked(ActionEvent actionEvent) throws Exception {
        flag = 0;
        dList = dm.getAllData();
        for (Data data:dList) {
            if(data.getEmail().equals(emailField.getText())){
                flag = 1;
                warn.setContentText("The Email you entered already exists!");
                warn.showAndWait();
                break;
            }
        }
        if(flag==0) {            
            Data data = new Data();
            data.setName(nameField.getText());
            data.setEmail(emailField.getText());
            data.setUsername(usernameField.getText());
            data.setPassword(passwordField.getText());
            dm.setData(data);
            dm.close();

            MainApp.setRoot("/fxml/LoginScene.fxml");
        }
    }
    
    

    @FXML
    public void  backButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/LoginScene.fxml");
    }

    public static Alert getWarn() {
        return warn;
    }

    public static int getFlag() {
        return flag;
    }

    

    }