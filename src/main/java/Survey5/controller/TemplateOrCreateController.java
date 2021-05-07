package Survey5.controller;

import Survey5.MainApp;
import Survey5.controller.SurveyTemplateControllers.TemplateSurveyController;
import Survey5.model.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class TemplateOrCreateController {

    private static Data userdata;

    public static void setData(Data userdata) {
        TemplateOrCreateController.userdata = userdata;
    }

    @FXML
    private void templateButtonClicked(ActionEvent actionEvent) throws IOException {
        TemplateSurveyController.setData(userdata);
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
    }

    @FXML
    private void createSurveyButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/NewSurvey.fxml");
    }

    @FXML
    private void backButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/AfterLoginMenu.fxml");
    }
}
