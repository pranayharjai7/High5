package com.mycompany;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class TemplateSurveyController {
    @FXML
    private Label HealthAndSafetyLabel;

    @FXML
    private Button GeneralHealthSurveyTemplateButton;

    @FXML
    private Button workHealthSurveyTemplateButton;

    @FXML
    private Button CoronaVaccineSurveyTemplateButton;

    @FXML
    private Label SurveyTemplateHeadingLabel;

    @FXML
    private Button DrugsStudySurveyTemplateButton;

    @FXML
    private Label FoodAndNutritionLabel;

    @FXML
    private Button foodTemplateSurveyButton;

    @FXML
    private Button FoodAllergyTemplateButton;

    @FXML
    private Button MalnutritionSurveyTemplateButton;

    @FXML
    private Button ObesitySurveyTemplateButton;

    @FXML
    private TextField TemplateSearchTextField;

    @FXML
    private Button TemplateSearchButton;

    @FXML
    private Label SportsAndFitnessLabel;

    @FXML
    private Button GeneralSportsSurveyTemplateButton;

    @FXML
    private Button WaterpoloSurveyTemplateButton;

    @FXML
    private Button cyclingSurveyTemplateButton;

    @FXML
    private Button PhysicalSurveyTemplateButton;

    @FXML
    private Label BusinessAndReviewLabel;

    @FXML
    private Button CustomerSatisfactionSurveyTemplateButton;

    @FXML
    private Button WebsiteReviewSurveyTemplateButton;

    @FXML
    private Button ShopBusinessReviewSurveyTemplateButton;

    @FXML
    private Button AppSoftwareReviewSurveyTemplateButton;


    @FXML
    void TemplateSearchButtonClicked(ActionEvent event) {

    }

    @FXML
    void GeneralHealthSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        App.setRoot("HealthTemplate1");
    }

    @FXML
    void workHealthSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        App.setRoot("HealthTemplate2");
    }

    @FXML
    void CoronaVaccineSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        App.setRoot("HealthTemplate3");
    }

    @FXML
    void DrugsStudySurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        App.setRoot("HealthTemplate4");
    }

    @FXML
    void FoodSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        App.setRoot("FoodTemplate1");
    }

    @FXML
    void FoodAllergyTemplateButtonClicked(ActionEvent event) throws IOException {
        App.setRoot("FoodTemplate2");
    }

    @FXML
    void MalnutritionSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        App.setRoot("FoodTemplate3");
    }

    @FXML
    void ObesitySurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        App.setRoot("FoodTemplate4");
    }

    @FXML
    void GeneralSportsSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        App.setRoot("SportsTemplate1");
    }

    @FXML
    void WaterpoloSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        App.setRoot("SportsTemplate2");
    }

    @FXML
    void CyclingSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        App.setRoot("SportsTemplate3");
    }

    @FXML
    void PhysicalSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        App.setRoot("SportsTemplate4");
    }

    @FXML
    void CustomerSatisfactionSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        App.setRoot("BusinessTemplate1");
    }

    @FXML
    void WebsiteReviewSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        App.setRoot("BusinessTemplate2");
    }

    @FXML
    void ShopBusinessReviewSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        App.setRoot("BusinessTemplate3");
    }

    @FXML
    void AppSoftwareReviewSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        App.setRoot("BusinessTemplate2");
    }

}