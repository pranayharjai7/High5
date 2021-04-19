package Survey5.controller.SurveyTemplateControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Survey5.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.controlsfx.control.Rating;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

public class BusinessTemplate1Controller {

    @FXML
    private AnchorPane FeedbackSurveyCanvas;

    @FXML
    private Label PhoneLabel;

    @FXML
    private Label EmailLabel;

    @FXML
    private Label NameLabel;

    @FXML
    private TextField NameTextField;

    @FXML
    private TextField PhoneTextFeild;

    @FXML
    private TextField EmailTextFeild;

    @FXML
    private Text ProductQuality;

    @FXML
    private Text DeliverySpeed;

    @FXML
    private Text CustomerService;

    @FXML
    private Text Communication;

    @FXML
    private Rating ProductRating;

    @FXML
    private Rating DeliveryRating;

    @FXML
    private Rating CommunicationRating;

    @FXML
    private Rating CustomerServiceRating;

    @FXML
    private Text Review;

    @FXML
    private TextArea ReviewBox;

    @FXML
    private Button SubmitButton;

    @FXML
    private Button backButton;

    @FXML
    void SubmitButtonClicked(ActionEvent event) throws IOException {

        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
    }

    @FXML
    void backButtonClicked(ActionEvent event) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
    }

}
