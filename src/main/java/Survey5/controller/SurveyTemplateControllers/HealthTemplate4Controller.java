package Survey5.controller.SurveyTemplateControllers;

import Survey5.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class HealthTemplate4Controller {
    @FXML
    private AnchorPane HealthTemplate4AnchorPane;

    @FXML
    private Label HealthTemplate4;

    @FXML
    private Label NameLAbel;

    @FXML
    private Label AgeLabel;

    @FXML
    private TextField NameLabelTextField;

    @FXML
    private ChoiceBox<?> AgeLabelTextField;

    @FXML
    private Label DrugLabel;

    @FXML
    private TextField DrugNameTextField;

    @FXML
    private Text Q1;

    @FXML
    private RadioButton Ans1_1;

    @FXML
    private ToggleGroup group1;

    @FXML
    private RadioButton Ans2_2;

    @FXML
    private Text Q2;

    @FXML
    private RadioButton Ans2_1;

    @FXML
    private ToggleGroup group2;

    @FXML
    private Text Q3;

    @FXML
    private RadioButton Ans3_1;

    @FXML
    private ToggleGroup group3;

    @FXML
    private RadioButton Ans3_2;

    @FXML
    private Text Q4;

    @FXML
    private RadioButton Ans4_1;

    @FXML
    private ToggleGroup group4;

    @FXML
    private RadioButton Ans4_2;

    @FXML
    private Text Q5;

    @FXML
    private RadioButton Ans5_1;

    @FXML
    private ToggleGroup group5;

    @FXML
    private RadioButton Ans5_2;

    @FXML
    private Text Q6;

    @FXML
    private RadioButton Ans6_1;

    @FXML
    private ToggleGroup group6;

    @FXML
    private RadioButton Ans6_2;

    @FXML
    private Text Q7;

    @FXML
    private RadioButton Ans7_1;

    @FXML
    private ToggleGroup group7;

    @FXML
    private RadioButton Ans7_2;

    @FXML
    private Text Q8;

    @FXML
    private RadioButton Ans8_1;

    @FXML
    private ToggleGroup group8;

    @FXML
    private RadioButton Ans8_2;

    @FXML
    private Text Q9;

    @FXML
    private RadioButton Ans9_1;

    @FXML
    private ToggleGroup group9;

    @FXML
    private RadioButton Ans9_2;

    @FXML
    private Text Q10;

    @FXML
    private RadioButton Ans10_1;

    @FXML
    private ToggleGroup group10;

    @FXML
    private RadioButton Ans10_2;

    @FXML
    private Text Q11;

    @FXML
    private RadioButton Ans11_1;

    @FXML
    private ToggleGroup group11;

    @FXML
    private RadioButton Ans11_2;

    @FXML
    private Text Q12;

    @FXML
    private TextArea Ans12;

    @FXML
    private Button SaveSurvey;

    @FXML
    private Button backButton;
    @FXML
    private Button SaveButton;

    public void SaveButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
    }

    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
    }
}
