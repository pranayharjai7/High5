package Survey5.controller.SurveyTemplateControllers;

import Survey5.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HealthTemplate2Controller
{

    @FXML
    private Button q1Agree;

    @FXML
    private Button q1rta;

    @FXML
    private Button q1sDisagree;

    @FXML
    private Button q1sAgree;

    @FXML
    private Button q1Disagree;

    @FXML
    private TextField q1TextField;

    @FXML
    void q1AnswerClicked(ActionEvent event) {

        if(event.getSource().equals(q1Agree)) {
            q1TextField.setText(q1Agree.getText());
            q1Agree.getStyleClass().add("SurveyButtonsNew");
            q1Agree.getStyleClass().remove("SurveyButtons");
        }
        else if(event.getSource().equals(q1Disagree))
            q1TextField.setText(q1Disagree.getText());


    }

    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
    }
}
