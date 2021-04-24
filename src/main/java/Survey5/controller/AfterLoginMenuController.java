package Survey5.controller;

import Survey5.MainApp;
import Survey5.model.Data;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.io.IOException;

public class AfterLoginMenuController {

    private static Data userdata;
    private Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    private FadeTransition fadeTransition;
    public static void setUserdata(Data userdata) {
        AfterLoginMenuController.userdata = userdata;
    }

    @FXML
    private Label AfterLoginMenuTitle;

    @FXML
    private void initialize(){
        fadeTransition = new FadeTransition(Duration.seconds(1.0), AfterLoginMenuTitle);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        //fadeTransition.setCycleCount(Animation.INDEFINITE);
        fadeTransition.play();
        fadeTransition.setOnFinished(this::fadeFinished);
    }
    private void fadeFinished(ActionEvent actionEvent) {
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
        fadeTransition.setOnFinished(this::fadeStart);
    }
    private void fadeStart(ActionEvent actionEvent) {
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.play();
        fadeTransition.setOnFinished(this::fadeFinished);
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
    private void AnswerSurveyButtonClicked(ActionEvent actionEvent) throws IOException {
        AnswerSurveyController.setUserdata(userdata);
        MainApp.setRoot("/fxml/AnswerSurvey.fxml");
    }

    @FXML
    private void logoutButtonClicked(ActionEvent actionEvent) throws IOException {
        confirm.setContentText("You have been logged out successfully");
        confirm.showAndWait();
        MainApp.setRoot("/fxml/LoginScene.fxml");
    }
}
