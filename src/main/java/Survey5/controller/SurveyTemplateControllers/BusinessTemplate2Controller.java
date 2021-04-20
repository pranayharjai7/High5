package Survey5.controller.SurveyTemplateControllers;

import Survey5.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.controlsfx.control.Rating;


import java.io.IOException;

public class BusinessTemplate2Controller
{

    @FXML
    private AnchorPane BusinessTemplate2AnchorPane;

    @FXML
    private Label BusinessTemplate2Label;

    @FXML
    private Text WebsiteReviewIntroQ1;

    @FXML
    private ChoiceBox<?> WebsiteReviewIntroQ1ChoiceBox;

    @FXML
    private Text WebsiteReviewIntroQ2;

    @FXML
    private ChoiceBox<?> WebsiteReviewIntroQ2ChoiceBox;

    @FXML
    private Label UserInterfaceLabel;

    @FXML
    private Label ImagesLabelQ;

    @FXML
    private Label ColourAndFontQLabel;

    @FXML
    private Rating UserInterfaceLabelRating;

    @FXML
    private Rating ColourAndFontLabelRating;

    @FXML
    private Rating ImagesLabelRating;

    @FXML
    private Rating LayoutLabelRating;

    @FXML
    private Label EfficencyOfToolbarQ;

    @FXML
    private Rating ComprehensivnessLabelRating;

    @FXML
    private Label ComprehensivnessLabelQ;

    @FXML
    private Rating EfficencyOfToolbarRating;

    @FXML
    private Label HelpSystemLabelQ;

    @FXML
    private Rating HelpSystemLabelRating;

    @FXML
    private Label ControlledInteractionLabelQ;

    @FXML
    private Rating ControlledInteractionLabelQRating;

    @FXML
    private Label EaseOfUSeConnectionQ;

    @FXML
    private Label EntryGuidanceConnectionQ;

    @FXML
    private Label HyperlinkConnotationQ;

    @FXML
    private Label ConnectionSpeedQ;

    @FXML
    private Rating ConnectionSpeedRating;

    @FXML
    private Rating EaseOfUSeConnectionQRating;

    @FXML
    private Rating EntryGuidanceConnectionRating;

    @FXML
    private Rating HyperlinkConnotationRating;

    @FXML
    private Text WebsiteReviewQ;

    @FXML
    private TextArea WebsiteReviewAnswerBox;

    @FXML
    private Button SubmitButton;

    @FXML
    private Button backButton;

    @FXML
    void SubmitButtonClicked(ActionEvent event) throws IOException {

        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");

    }
    @FXML
    void backButtonClicked(ActionEvent event) throws IOException
    {
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
    }

}
