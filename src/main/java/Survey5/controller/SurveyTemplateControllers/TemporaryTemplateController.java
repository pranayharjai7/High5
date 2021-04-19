package Survey5.controller.SurveyTemplateControllers;

import Survey5.MainApp;
import Survey5.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TemporaryTemplateController {
    private Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    private static Data userdata;
    private static Survey survey;


    public static void setSurvey(Survey survey) {
        TemporaryTemplateController.survey = survey;
    }

    SurveysDaoInterface surveyManager = new SurveyManager();
    QnADaoInterface qnAManager = new QnAManager();

    @FXML
    private AnchorPane temporaryTemplate;
    @FXML
    private Label titleLabel;

    @FXML
    private Label question1Label;

    @FXML
    private TextArea answer1Area;

    @FXML
    private Label question2Label;

    @FXML
    private TextField answer2Field;

    @FXML
    private Button submitButton;

    @FXML
    private Button backButton;

    public static void setData(Data userdata) {
        TemporaryTemplateController.userdata=userdata;
    }

    @FXML
    private void submitButtonClicked(ActionEvent actionEvent) throws Exception {
        Survey survey = new Survey();
        survey.setTypeOfTemplate(temporaryTemplate.getId());
        survey.setTitle(titleLabel.getText());
        survey.setOwner(userdata);

        QnA question1 = new QnA();
        QnA question2 = new QnA();
        question1.setQuestion(question1Label.getText());
        question1.setSurveyTemplate(survey);
        question2.setQuestion(question2Label.getText());
        question2.setSurveyTemplate(survey);


        surveyManager.setSurvey(survey);
        qnAManager.setQnA(question1);
        qnAManager.setQnA(question2);
        qnAManager.close();
        surveyManager.close();
        confirm.setContentText("Template Saved Successfully!!");
        confirm.showAndWait();
        MainApp.setRoot("/fxml/TemplateOrCreate.fxml");
    }


    @FXML
    private void backButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/AfterLoginMenu.fxml");
    }
}
