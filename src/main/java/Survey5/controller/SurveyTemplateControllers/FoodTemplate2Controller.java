package Survey5.controller.SurveyTemplateControllers;

import Survey5.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import org.controlsfx.control.Rating;

import java.io.IOException;


public class FoodTemplate2Controller
{
    @FXML
    private TextField AgeFoodBox;
    @FXML
    private Label FoodAndNutritionLabel;
    @FXML
    private Button Back;
    @FXML
    private Button next1;
    
    @FXML
    void agefoodboxclicked (ActionEvent event) throws IOException {
                    
} 
    @FXML
    private Rating stars;

    void starsclicked (ActionEvent event) throws IOException {
                

    }

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
    private TextField BMIfieldFoodBox;
    
    @FXML
    void BMIclicked (ActionEvent event) throws IOException {
                

    }

    @FXML
    private Text AgeFoodSurveyQuestion;

    @FXML
    private Text PhysicalSatisfactionQuestion;

    @FXML
    private Text FoodAllergyQuestion;


    @FXML
    private TextField FoodAllergyAnswerBox;
    
    @FXML
    void Allergyclicked (ActionEvent event) throws IOException {
                

    }
    
    @FXML
    private Slider ExerciseSliderbox;

    void sliderclicked (ActionEvent event) throws IOException {
               
    }
    

    @FXML
    void BackButtonClicked (ActionEvent event) throws IOException {
                MainApp.setRoot("SurveyTemplates");

    }
    
   
     @FXML
    void next1clicked (ActionEvent event) throws IOException {
               

    }

    @FXML
    void supplementsNoClicked(ActionEvent event) {
        
    }

    @FXML
    void supplementsYesClicked(ActionEvent event) {
        
    }

    @FXML
    private void sliderclicked(MouseEvent event) {
    }

    @FXML
    private void starsclicked(MouseEvent event) {
    }

    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
    }
}
