package Survey5.controller;

import Survey5.MainApp;
import Survey5.model.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.io.IOException;

public class AfterLoginMenuController {

    private static Data userdata;
    private Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);

    public static void setUserdata(Data userdata) {
        AfterLoginMenuController.userdata = userdata;
    }

    @FXML
    private void profileButtonClicked(ActionEvent actionEvent) throws IOException {
        MyProfileController.setData(userdata);
        MainApp.setRoot("/fxml/MyProfile.fxml");
    }

    @FXML
    private void savedSurveyButtonClicked(ActionEvent actionEvent) throws IOException {
        SavedSurveysController.setUserdata(userdata);
        MainApp.setRoot("/fxml/SavedSurveys.fxml");
    }

    @FXML
    private void createSurveyButtonClicked(ActionEvent actionEvent) throws IOException {
        TemplateOrCreateController.setData(userdata);
        MainApp.setRoot("/fxml/TemplateOrCreate.fxml");
    }

    @FXML
    private void AnswerSurveyButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    private void logoutButtonClicked(ActionEvent actionEvent) throws IOException {
        confirm.setContentText("You have been logged out successfully");
        confirm.showAndWait();
        MainApp.setRoot("/fxml/LoginScene.fxml");
    }
}
