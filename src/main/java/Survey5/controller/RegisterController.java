package Survey5.controller;

import Survey5.MainApp;
import Survey5.model.Data;
import Survey5.model.DataDaoInterface;
import Survey5.model.DataManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.List;

public class RegisterController{

    private int flag;
    private Alert warn = new Alert(Alert.AlertType.WARNING);
    private Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    DataDaoInterface dm = new DataManager();
    List<Data> dList;

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private void registerButtonClicked(ActionEvent actionEvent) throws Exception {
        flag = 0;
        dList = dm.getAllData();
        for (Data data:dList) {
            if(data.getEmail().equals(emailField.getText())){
                warn.setContentText("The Email you entered already exists!");
                warn.showAndWait();
                flag = 1;
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
}
