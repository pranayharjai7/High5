package Survey5.controller.SurveyTemplateControllers;

import java.io.IOException;

import Survey5.MainApp;
import Survey5.model.Data;
import Survey5.model.Survey;
import Survey5.model.SurveyManager;
import Survey5.model.SurveysDaoInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class HealthTemplate1Controller
{
    private Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    private static Data userdata;
    SurveysDaoInterface surveyManager = new SurveyManager();

    @FXML
    private Label HealthTemplate1;

    @FXML
    private TextField AgeFeild;

    @FXML
    private TextField BMIfeild;

    @FXML
    private RadioButton MedicationYes;

    @FXML
    private RadioButton MedicationNo;

    @FXML
    private RadioButton VaccineYes;

    @FXML
    private RadioButton VaccineNo;

    @FXML
    private RadioButton DrugHistoryNo;

    @FXML
    private RadioButton DrugHistoryYes;

    @FXML
    private Text DrugHistory;

    @FXML
    private Text VaccineQuestion;

    @FXML
    private Text MedicationQuestion;

    @FXML
    private Text BMI;

    @FXML
    private Text Age;

    @FXML
    private Text PhysicalExam;

    @FXML
    private DatePicker PhysicalExamDate;

    @FXML
    private Text DiseaseQuestion;

    @FXML
    private Button HealthSurveyButton;

    @FXML
    private RadioButton DiseaseAnsNo;

    @FXML
    private RadioButton DiseaseANS;

    @FXML
    void DiseaseAnsNoClicked(ActionEvent event) {

    }

    @FXML
    void DiseaseAnsYesClicked(ActionEvent event) {

    }

    @FXML
    void DrugHistoryNoClicked(ActionEvent event) {

    }

    @FXML
    void DrugHistoryYes(ActionEvent event) {

    }

    @FXML
    void MedicationYesClicked(ActionEvent event) {

    }

    @FXML
    void PhysicalExamDateSelected(ActionEvent event) {

    }

    @FXML
    void VaccineNoClicked(ActionEvent event) {

    }

    @FXML
    void VaccineYesClicked(ActionEvent event) {

    }

    public static void setData(Data userdata) {
        HealthTemplate1Controller.userdata=userdata;
    }

    @FXML
    void HealthSurveySubmitted(ActionEvent event) throws Exception {
        Survey survey = new Survey();
        survey.setTypeOfTemplate(HealthTemplate1.getId());
        survey.setTitle(HealthTemplate1.getText());
        survey.setOwner(userdata);

        surveyManager.setSurvey(survey);
        surveyManager.close();
        confirm.setContentText("Template Saved Successfully!!");
        confirm.showAndWait();
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
    }

    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
    }
}
