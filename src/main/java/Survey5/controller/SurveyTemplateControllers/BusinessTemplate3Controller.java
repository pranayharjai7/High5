package Survey5.controller.SurveyTemplateControllers;

import Survey5.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.controlsfx.control.Rating;

import java.io.IOException;


public class BusinessTemplate3Controller {


    @FXML
    private AnchorPane BusinessTemplate3AnchorPane;
    @FXML
    private Label BusinessTemplate3Label;

    @FXML
    private Text OnlineStoreLabelQ1;

    @FXML
    private ChoiceBox<?> OnlineStoreQ1ChoiceBox;

    @FXML
    private Text OnlineStoreLabelQ2;

    @FXML
    private ChoiceBox<?> OnlineStoreQ2ChoiceBox;

    @FXML
    private Text FriendlinessLabelQ1;

    @FXML
    private Text UsefulAnswerLabelQ;

    @FXML
    private Text HelpfulnessLabelQ;

    @FXML
    private Rating FriendlinessLabelQ1Rating;

    @FXML
    private Rating UsefulAnswerLabelQRating;

    @FXML
    private Rating HelpfulnessLabelQRating;

    @FXML
    private Text ProductQualityLabelQ;

    @FXML
    private Text PriceLabelQ;

    @FXML
    private Text ProductPackagingLabelQ;

    @FXML
    private Text RecommendationLabelQ;

    @FXML
    private Rating ProductQualityLabelQRating;

    @FXML
    private Rating PriceLabelQRating;

    @FXML
    private Rating ProductPackagingLabelQRating;

    @FXML
    private Rating RecommendationLabelQRating;

    @FXML
    private Text UserFriendlinessLabelQ;

    @FXML
    private Text PaymentEaseLabelQ;

    @FXML
    private Text EaseOfUSeLabelQ;

    @FXML
    private Rating UserFriendlinessLabelQRating;

    @FXML
    private Rating PaymentEaseLabelQRating;

    @FXML
    private Rating EaseOfUSeLabelQRating;

    @FXML
    private Text FinalReviewQ;

    @FXML
    private TextArea FinalREviewAnsBox;

    @FXML
    private Button BusinessTemplate2SubmitButton;

    @FXML
    void BusinessTemplate2SubmitButtonClicked(ActionEvent event) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
    }


    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
    }
}
