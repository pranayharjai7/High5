package Survey5.controller.SurveyTemplateControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Survey5.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


public class FoodTemplate1Controller
{
      @FXML
    private TextField AgeFoodBox;

    @FXML
    private TextField BMIfeildFoodBox;

    @FXML
    private RadioButton VitaminsYes;

    @FXML
    private RadioButton VitaminsNo;

    @FXML
    private Text ExerciseQuestion;

    @FXML
    private Text SupplementsQuestion;

    @FXML
    private Text BMIFoodSurveyquestion;

    @FXML
    private Text AgeFoodSurveyQuestion;

    @FXML
    private Text PhysicalSatisfactionQuestion;

    @FXML
    private Text FoodAllergyQuestion;

    @FXML
    private Button FoodSurveyButton;

    @FXML
    private TextField FoodAllergyAnswerBox;

    @FXML
    private Slider ExerciseSliderbox;

    @FXML
    void FoodSurveySubmitted(ActionEvent event) throws IOException {
                MainApp.setRoot("SurveyTemplates");

    }

    @FXML
    void supplementsNoClicked(ActionEvent event) {
    }

    @FXML
    void supplementsYesClicked(ActionEvent event) {
    }

    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
    }
}
