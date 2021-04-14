package Survey5.controller.SurveyTemplateControllers;

import java.io.IOException;

import Survey5.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HealthTemplate1Controller
{
 
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
    void HealthSurveySubmitted(ActionEvent event) throws IOException {
        MainApp.setRoot("TemplateSurvey");
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

    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
    }
}
