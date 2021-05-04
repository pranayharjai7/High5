package Survey5.controller.SurveyTemplateControllers;

import Survey5.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;

import java.io.IOException;

public class BusinessTemplate4Controller
{
    @FXML
    private Label BusinessTemplate4Label;

    @FXML
    private Text SurveyQ1;

    @FXML
    private RadioButton SurveyQ1Option1;

    @FXML
    private RadioButton SurveyQ1Option2;

    @FXML
    private RadioButton SurveyQ1Option3;

    @FXML
    private RadioButton SurveyQ1Option4;

    @FXML
    private RadioButton SurveyQ1Option5TextField;

    @FXML
    private Text SurveyQ2;

    @FXML
    private RadioButton getSurveyQ1Option1;

    @FXML
    private Text SurveyQ3;

    @FXML
    private RadioButton SurveyQ3Option1;

    @FXML
    private RadioButton SurveyQ3Option2;

    @FXML
    private RadioButton SurveyQ3Option4;

    @FXML
    private RadioButton SurveyQ3Option3;

    @FXML
    private Text SurveyQ4;

    @FXML
    private RadioButton SurveyQ4Option2;

    @FXML
    private RadioButton SurveyQ4Option1;

    @FXML
    private RadioButton SurveyQ4Option3;

    @FXML
    private RadioButton SurveyQ4Option4;

    @FXML
    private Text SurveyQ5;

    @FXML
    private RadioButton SurveyQ5Option1;

    @FXML
    private RadioButton SurveyQ5Option2;

    @FXML
    private RadioButton SurveyQ5Option3;

    @FXML
    private RadioButton SurveyQ5Option4;

    @FXML
    private Text SurveyQ6;

    @FXML
    private RadioButton SurveyQ6Option1;

    @FXML
    private RadioButton SurveyQ6Option2;

    @FXML
    private RadioButton SurveyQ6Option3;

    @FXML
    private RadioButton SurveyQ6Option4;

    @FXML
    private Text SurveyQ7;

    @FXML
    private RadioButton SurveyQ7Option1;

    @FXML
    private RadioButton SurveyQ7Option2;

    @FXML
    private RadioButton SurveyQ7Option3;

    @FXML
    private RadioButton SurveyQ7Option4;

    @FXML
    private Text Question8;

    @FXML
    private RadioButton SurveyQ8Option1;

    @FXML
    private RadioButton SurveyQ8Option2;

    @FXML
    private RadioButton SurveyQ8Option3;

    @FXML
    private RadioButton SurveyQ8Option4;

    @FXML
    private Button BusinessTemplate4SubmitButton;

    @FXML
    void BusinessTemplate4SubmitButtonClicked(ActionEvent event) {

    }
    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
    }
}

