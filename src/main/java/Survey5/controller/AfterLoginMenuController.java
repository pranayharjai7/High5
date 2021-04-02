package Survey5.controller;

import Survey5.MainApp;
import Survey5.model.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class AfterLoginMenuController {

    private static Data userdata;

    public static void setUserdata(Data userdata) {
        AfterLoginMenuController.userdata = userdata;
    }

    @FXML
    private void profileButtonClicked(ActionEvent actionEvent) throws IOException {
        MyProfileController.setData(userdata);
        MainApp.setRoot("/fxml/MyProfile.fxml");
    }

    @FXML
    private void savedSurveyButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    private void createSurveyButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/TemplateOrCreate.fxml");
    }

    @FXML
    private void AnswerSurveyButtonClicked(ActionEvent actionEvent) {
    }
}
