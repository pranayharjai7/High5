package Survey5.controller.SurveyTemplateControllers;

import Survey5.MainApp;
import Survey5.model.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class TemplateSurveyController {

    private static Data userdata;

    public static void setData(Data userdata){
        TemplateSurveyController.userdata=userdata;
    }

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
        HealthTemplate1Controller.setData(userdata);
        HealthTemplate1Controller.setCreateOrAnswerFunction("create");
        MainApp.setRoot("/fxml/SurveyTemplates/HealthTemplate1.fxml");
    }

    @FXML
    void workHealthSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        HealthTemplate2Controller.setData(userdata);
        HealthTemplate2Controller.setCreateOrAnswerFunction("create");
        MainApp.setRoot("/fxml/SurveyTemplates/HealthTemplate2.fxml");
    }

    @FXML
    void CoronaVaccineSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        HealthTemplate3Controller.setData(userdata);
        HealthTemplate3Controller.setCreateOrAnswerFunction("create");
        MainApp.setRoot("/fxml/SurveyTemplates/HealthTemplate3.fxml");
    }

    @FXML
    void DrugsStudySurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        HealthTemplate4Controller.setData(userdata);
        HealthTemplate4Controller.setCreateOrAnswerFunction("create");
        MainApp.setRoot("/fxml/SurveyTemplates/HealthTemplate4.fxml");
    }

    @FXML
    void FoodSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        FoodTemplate1Controller.setData(userdata);
        FoodTemplate1Controller.setCreateOrAnswerFunction("create");
        MainApp.setRoot("/fxml/SurveyTemplates/FoodTemplate1.fxml");
    }

    @FXML
    void FoodAllergyTemplateButtonClicked(ActionEvent event) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/FoodTemplate2.fxml");
    }

    @FXML
    void MalnutritionSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/FoodTemplate3.fxml");
    }

    @FXML
    void ObesitySurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/FoodTemplate4.fxml");
    }

    @FXML
    void GeneralSportsSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/SportsTemplate1.fxml");
    }

    @FXML
    void WaterpoloSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/SportsTemplate2.fxml");
    }

    @FXML
    void CyclingSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/SportsTemplate3.fxml");
    }

    @FXML
    void PhysicalSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/SportsTemplate4.fxml");
    }

    @FXML
    void CustomerSatisfactionSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        BusinessTemplate1Controller.setData(userdata);
        BusinessTemplate1Controller.setCreateOrAnswerFunction("create");
        MainApp.setRoot("/fxml/SurveyTemplates/BusinessTemplate1.fxml");
    }

    @FXML
    void WebsiteReviewSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        BusinessTemplate2Controller.setData(userdata);
        BusinessTemplate2Controller.setCreateOrAnswerFunction("create");
        MainApp.setRoot("/fxml/SurveyTemplates/BusinessTemplate2.fxml");
    }

    @FXML
    void ShopBusinessReviewSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        BusinessTemplate3Controller.setData(userdata);
        BusinessTemplate3Controller.setCreateOrAnswerFunction("create");
        MainApp.setRoot("/fxml/SurveyTemplates/BusinessTemplate3.fxml");
    }

    @FXML
    void AppSoftwareReviewSurveyTemplateButtonClicked(ActionEvent event) throws IOException {
        BusinessTemplate4Controller.setData(userdata);
        BusinessTemplate4Controller.setCreateOrAnswerFunction("create");
        MainApp.setRoot("/fxml/SurveyTemplates/BusinessTemplate4.fxml");
    }

    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/TemplateOrCreate.fxml");
    }
}