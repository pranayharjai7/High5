package Survey5.controller.SurveyTemplateControllers;

import Survey5.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.Rating;

import java.io.IOException;

public class SportsTemplate2Controller {

    @FXML
    private AnchorPane SportsTemplate2AnchorPane;

    @FXML
    private Label Question1;

    @FXML
    private RadioButton Answer1_1;

    @FXML
    private ToggleGroup answer1;

    @FXML
    private RadioButton Answer1_2;

    @FXML
    private Label Question2;

    @FXML
    private RadioButton Answer2_1;

    @FXML
    private ToggleGroup answer2;

    @FXML
    private RadioButton Answer2_2;

    @FXML
    private Label Question3;

    @FXML
    private RadioButton Answer3_1;

    @FXML
    private ToggleGroup answer3;

    @FXML
    private RadioButton Answer3_2;

    @FXML
    private Label Question4;

    @FXML
    private Rating Answer4;

    @FXML
    private Label Question5;

    @FXML
    private TextField Answer5;

    @FXML
    private Label Question6;

    @FXML
    private TextArea Answer6;

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    @FXML
    private Label SportsTemplate2;

    @FXML
    void backButtonClicked(ActionEvent event) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");

    }

    @FXML
    void saveButtonClicked(ActionEvent event) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");

    }

}
