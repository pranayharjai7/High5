package Survey5.controller.SurveyTemplateControllers;

import Survey5.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class BusinessTemplate4Controller
{
    @FXML
    private AnchorPane BusinessTemplate4AnchorPane;

    @FXML
    private Label BusinessTemplate4;

    @FXML
    private Text SurveyQ1;

    @FXML
    private RadioButton Ans1_1;

    @FXML
    private RadioButton Ans1_2;

    @FXML
    private RadioButton Ans1_3;

    @FXML
    private RadioButton Ans1_4;

    @FXML
    private TextField Ans1_5;

    @FXML
    private RadioButton SurveyQ1Option5TextField;

    @FXML
    private Text SurveyQ2;

    @FXML
    private RadioButton Ans2_2;

    @FXML
    private RadioButton Ans2_1;

    @FXML
    private RadioButton Ans2_3;

    @FXML
    private RadioButton Ans2_4;

    @FXML
    private Text SurveyQ3;

    @FXML
    private RadioButton Ans3_1;

    @FXML
    private RadioButton Ans3_2;

    @FXML
    private RadioButton Ans3_4;

    @FXML
    private RadioButton Ans3_3;

    @FXML
    private Text SurveyQ4;

    @FXML
    private RadioButton Ans4_2;

    @FXML
    private RadioButton Ans4_1;

    @FXML
    private RadioButton Ans4_3;

    @FXML
    private RadioButton Ans4_4;

    @FXML
    private Text SurveyQ5;

    @FXML
    private RadioButton Ans5_1;

    @FXML
    private RadioButton Ans5_2;

    @FXML
    private RadioButton Ans5_3;

    @FXML
    private RadioButton Ans5_4;

    @FXML
    private Text SurveyQ6;

    @FXML
    private RadioButton Ans6_1;

    @FXML
    private RadioButton Ans6_2;

    @FXML
    private RadioButton Ans6_3;

    @FXML
    private RadioButton Ans6_4;

    @FXML
    private Text SurveyQ7;

    @FXML
    private RadioButton Ans7_1;

    @FXML
    private RadioButton Ans7_2;

    @FXML
    private RadioButton Ans7_3;

    @FXML
    private RadioButton Ans7_4;

    @FXML
    private Text Question8;

    @FXML
    private RadioButton Ans8_1;

    @FXML
    private RadioButton Ans8_2;

    @FXML
    private RadioButton Ans8_3;

    @FXML
    private RadioButton Ans8_4;

    @FXML
    private Button BusinessTemplate4SubmitButton;

    @FXML
    private Button backButton;
    @FXML
    void BusinessTemplate4SubmitButtonClicked(ActionEvent event) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
    }
    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
    }
}

