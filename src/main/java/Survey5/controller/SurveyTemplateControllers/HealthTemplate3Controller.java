package Survey5.controller.SurveyTemplateControllers;

import Survey5.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HealthTemplate3Controller
{
    @FXML
    private AnchorPane HealthTemplate3AnchorPane;

    @FXML
    private Label Q1;

    @FXML
    private RadioButton Ans1_2;

    @FXML
    private ToggleGroup group1;

    @FXML
    private RadioButton Ans1_3;

    @FXML
    private RadioButton Ans1_4;

    @FXML
    private Label Q2;

    @FXML
    private RadioButton Ans2_1;

    @FXML
    private ToggleGroup group2;

    @FXML
    private RadioButton Ans2_2;

    @FXML
    private RadioButton Ans2_3;

    @FXML
    private RadioButton Ans2_4;

    @FXML
    private Label Q3;

    @FXML
    private RadioButton Ans3_1;

    @FXML
    private ToggleGroup group3;

    @FXML
    private RadioButton Ans3_2;

    @FXML
    private RadioButton Ans3_3;

    @FXML
    private RadioButton Ans3_4;

    @FXML
    private Button submitButtonClicked;

    @FXML
    private Label Q5;

    @FXML
    private RadioButton Ans4_1;

    @FXML
    private ToggleGroup group4;

    @FXML
    private RadioButton Ans4_2;

    @FXML
    private RadioButton Ans5_1;

    @FXML
    private ToggleGroup group5;

    @FXML
    private RadioButton Ans5_2;

    @FXML
    private Label Q6;

    @FXML
    private RadioButton Ans6_1;

    @FXML
    private ToggleGroup group6;

    @FXML
    private RadioButton Ans6_2;

    @FXML
    private Label Q7;

    @FXML
    private RadioButton Ans7_2;

    @FXML
    private ToggleGroup group7;

    @FXML
    private RadioButton Ans7_1;

    @FXML
    private Label Q8;

    @FXML
    private RadioButton Ans8_1;

    @FXML
    private ToggleGroup group8;

    @FXML
    private RadioButton Ans8_2;

    @FXML
    private Label Q9;

    @FXML
    private RadioButton Ans9_1;

    @FXML
    private ToggleGroup group9;

    @FXML
    private RadioButton Ans9_2;

    @FXML
    private Label Q10;

    @FXML
    private RadioButton Ans10_1;

    @FXML
    private ToggleGroup group10;

    @FXML
    private RadioButton Ans10_2;

    @FXML
    private Label HealthTemplate3;

    @FXML
    private RadioButton Ans1_1;

    @FXML
    private Button backButton;

    @FXML
    void SubmitButtonClicked(ActionEvent event) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");

    }

    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
    }
}
