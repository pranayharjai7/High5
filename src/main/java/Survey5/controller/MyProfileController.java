package Survey5.controller;

import Survey5.MainApp;
import Survey5.model.Data;
import Survey5.model.DataDaoInterface;
import Survey5.model.DataManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class MyProfileController {
    private DataDaoInterface dm = new DataManager();
    private static Data userdata;

    private TextField nameField = new TextField();
    private TextField usernameField = new TextField();
    private TextField emailField = new TextField();
    private TextField passwordField = new PasswordField();
    private Button doneButton = new Button("Done");

    public static void setData(Data data) {
        MyProfileController.userdata = data;
    }

    @FXML
    private AnchorPane myProfileAnchorPane;
    @FXML
    private Label nameLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Button changeButton;

    @FXML
    public void initialize(){
        nameLabel.setText(userdata.getName());
        usernameLabel.setText(userdata.getUsername());
        emailLabel.setText(userdata.getEmail());
    }

    @FXML
    private void backButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/AfterLoginMenu.fxml");
    }

    @FXML
    private void changeButtonClicked(ActionEvent actionEvent){
        nameField.setText("");
        nameField.setPromptText("Enter New Name Here");
        nameField.setLayoutX(nameLabel.getLayoutX());
        nameField.setLayoutY(nameLabel.getLayoutY());

        usernameField.setText("");
        usernameField.setPromptText("Enter New Username Here");
        usernameField.setLayoutX(usernameLabel.getLayoutX());
        usernameField.setLayoutY(usernameLabel.getLayoutY());

        emailField.setText("");
        emailField.setPromptText("Enter New Email Here");
        emailField.setLayoutX(emailLabel.getLayoutX());
        emailField.setLayoutY(emailLabel.getLayoutY());

        doneButton.setLayoutX(changeButton.getLayoutX());
        doneButton.setLayoutY(changeButton.getLayoutY());
        doneButton.setOnAction(this::changeDoneClicked);

        myProfileAnchorPane.getChildren().removeAll(nameLabel,usernameLabel,emailLabel,changeButton);
        myProfileAnchorPane.getChildren().addAll(nameField,usernameField,emailField,doneButton);

    }

    private void changeDoneClicked(ActionEvent actionEvent){
           System.out.println(userdata);
       
        if(!nameField.getText().equals("")) {
            nameLabel.setText(nameField.getText());
            userdata.setName(nameLabel.getText());
        }
        if(!usernameField.getText().equals("")) {
            usernameLabel.setText(usernameField.getText());
            userdata.setUsername(usernameLabel.getText());
        }
        if(!emailField.getText().equals("")) {
            emailLabel.setText(emailField.getText());
            userdata.setEmail(emailLabel.getText());
        }
        dm.updateData(userdata);
        try {
            dm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        myProfileAnchorPane.getChildren().removeAll(nameField,usernameField,emailField,doneButton);
        myProfileAnchorPane.getChildren().addAll(nameLabel,usernameLabel,emailLabel,changeButton);
    

    }
}
    
