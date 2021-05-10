package Survey5.controller.SurveyTemplateControllers;

import Survey5.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.io.IOException;

public class SportsTemplate1Controller {

    @FXML
    private Text Question1;

    @FXML
    private RadioButton Answer1_1;

    @FXML
    private ToggleGroup answer1;

    @FXML
    private RadioButton Answer1_2;

    @FXML
    private RadioButton Answer1_3;

    @FXML
    private RadioButton Answer1_4;

    @FXML
    private RadioButton Answer1_5;

    @FXML
    private RadioButton Answer1_6;

    @FXML
    private RadioButton Answer1_7;

    @FXML
    private RadioButton Answer1_8;

    @FXML
    private RadioButton Answer1_9;

    @FXML
    private Text Question2;

    @FXML
    private RadioButton Answer2_1;

    @FXML
    private ToggleGroup answer2;

    @FXML
    private RadioButton Answer2_2;

    @FXML
    private RadioButton Answer2_3;

    @FXML
    private RadioButton Answer2_4;

    @FXML
    private RadioButton Answer2_5;

    @FXML
    private Text Question3;

    @FXML
    private RadioButton Answer3_1;

    @FXML
    private ToggleGroup answer3;

    @FXML
    private RadioButton Answer3_2;

    @FXML
    private RadioButton Answer3_3;

    @FXML
    private RadioButton Answer3_4;

    @FXML
    private RadioButton Answer3_5;

    @FXML
    private Text Question5;

    @FXML
    private CheckBox Answer5_1;

    @FXML
    private CheckBox Answer5_2;

    @FXML
    private CheckBox Answer5_8;

    @FXML
    private CheckBox Answer5_6;

    @FXML
    private CheckBox Answer5_16;

    @FXML
    private CheckBox Answer5_14;

    @FXML
    private CheckBox Answer5_11;

    @FXML
    private CheckBox Answer5_12;

    @FXML
    private CheckBox Answer5_4;

    @FXML
    private CheckBox Answer5_7;

    @FXML
    private CheckBox Answer5_15;

    @FXML
    private CheckBox Answer5_10;

    @FXML
    private CheckBox Answer5_3;

    @FXML
    private CheckBox Answer5_5;

    @FXML
    private Text Question4;

    @FXML
    private CheckBox Answer4_1;

    @FXML
    private CheckBox Answer4_2;

    @FXML
    private CheckBox Answer4_3;

    @FXML
    private CheckBox Answer5_9;

    @FXML
    private CheckBox Answer5_13;

    @FXML
    private Text Question6;

    @FXML
    private TextArea Answer6;

    @FXML
    private Text Question7;

    @FXML
    private TextArea Answer7;

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    @FXML
    void backButtonClicked(ActionEvent event) throws IOException {
        MainApp.setRoot("../resources/fxml/SurveyTemplates/TemplateSurvey.fxml");

    }

    @FXML
    void saveButtonClicked(ActionEvent event) {

    }

}
