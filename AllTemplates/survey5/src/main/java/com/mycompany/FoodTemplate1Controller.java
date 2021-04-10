/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
    private Text PhyicalSatisfactionQuestion;

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
                App.setRoot("SurveyTemplates");

    }

    @FXML
    void supplementsNoClicked(ActionEvent event) {
    }

    @FXML
    void supplementsYesClicked(ActionEvent event) {
    }
}
