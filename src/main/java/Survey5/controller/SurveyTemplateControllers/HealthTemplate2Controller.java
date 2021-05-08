package Survey5.controller.SurveyTemplateControllers;

import Survey5.MainApp;
import Survey5.controller.ShowAnswersController;
import Survey5.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HealthTemplate2Controller
{

    private static Survey survey;
    private Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    private Alert warn = new Alert(Alert.AlertType.WARNING);
    private static Data userdata;
    SurveysDaoInterface surveyManager = new SurveyManager();
    QuestionsDaoInterface questionManager  = new QuestionsManager();
    AnswersDaoInterface answerManager = new AnswersManager();
    static String answer;
    int NumberOfQuestions = 9;

    public static void setData(Data userdata) {
        HealthTemplate2Controller.userdata=userdata;
    }

    public static void setCreateOrAnswerFunction(String answer){
        HealthTemplate2Controller.answer=answer;
    }

    public static void setCreateOrAnswerFunction(String answer,Survey survey){
        HealthTemplate2Controller.survey=survey;
        HealthTemplate2Controller.answer=answer;
    }

    @FXML
    private void initialize(){
        if(answer.equals("answer"))
            setAnswering();
        else if(answer.equals("create"))
            setCreating();
        else
            setShowAnswers();
    }

    private void setAnswering(){
        saveButton.setText("Submit");
        saveButton.setOnAction(this::submitButtonClicked);
        backButton.setOnAction(this::backToAnswerButtonClicked);
    }


    private void setCreating() {
        saveButton.setText("Save");
        saveButton.setOnAction(this::saveButtonClicked);
        backButton.setOnAction(this::backToTemplatesButtonClicked);
    }

    private void setShowAnswers(){
        saveButton.setText("Show Answers");
        saveButton.setPrefWidth(150);
        saveButton.setOnAction(this::showAnswersClicked);
        backButton.setOnAction(this::backToSavedSurveysButtonClicked);
    }


    @FXML
    private Label HealthTemplate2;

    @FXML
    private Text Question1;

    @FXML
    private Text Question2;

    @FXML
    private Text Question3;

    @FXML
    private Text Question4;

    @FXML
    private Text Question5;

    @FXML
    private Text Question6;

    @FXML
    private Text Question7;

    @FXML
    private Text Question8;

    @FXML
    private Text Question9;

    @FXML
    private TextField Answer1;

    @FXML
    private TextField Answer2;

    @FXML
    private TextField Answer3;

    @FXML
    private TextField Answer4;

    @FXML
    private TextField Answer6;

    @FXML
    private TextField Answer5;

    @FXML
    private TextField Answer7;

    @FXML
    private TextField Answer8;

    @FXML
    private TextArea Answer9;

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;


    @FXML
    private void saveButtonClicked(ActionEvent actionEvent) {
        Survey survey = new Survey();
        survey.setTypeOfTemplate(HealthTemplate2.getId());
        survey.setTitle(HealthTemplate2.getText());
        survey.setOwner(userdata);

        surveyManager.setSurvey(survey);
        try {
            surveyManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        confirm.setContentText("Template Saved Successfully!!");
        confirm.showAndWait();
        try {
            MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //submitting Questions and answers to database
    private List<Questions> qList = new ArrayList<>();
    private void submitButtonClicked(ActionEvent actionEvent) {
        int flag = 0;
        qList = questionManager.getSurveyQuestions(survey);
        for (Questions question: qList) {
            if(question.getAnsweredByUser().getId()== userdata.getId()){
                flag = 1;
                break;
            }
        }
        if(flag == 1){
            warn.setContentText("You have already answered this Survey!");
            warn.showAndWait();
        }
        else if(Answer1.getText().equals("") || Answer2.getText().equals("") || Answer3.getText().equals("") ||
                Answer4.getText().equals("") || Answer5.getText().equals("") || Answer6.getText().equals("") ||
                Answer7.getText().equals("") || Answer8.getText().equals("")){
            warn.setContentText("You didn't submit all the answers!");
            warn.showAndWait();
        }
        else if(qList.isEmpty() || flag==0){
            for (int i = 1; i <= NumberOfQuestions; i++) {
                Questions question = new Questions();
                question.setSurveyTemplate(survey);
                question.setQuestionNumber(i);
                question.setAnsweredByUser(userdata);

                Answers answer = new Answers();
                switch (i) {
                    case 1: {
                        question.setQuestion(Question1.getText());
                        answer.setAnswersType("Textual");
                        answer.setAnswerText(Answer1.getText());
                        break;
                    }
                    case 2: {
                        question.setQuestion(Question2.getText());
                        answer.setAnswersType("Textual");
                        answer.setAnswerText(Answer2.getText());
                        break;
                    }
                    case 3: {
                        question.setQuestion(Question3.getText());
                        answer.setAnswersType("Textual");
                        answer.setAnswerText(Answer3.getText());
                        break;
                    }
                    case 4: {
                        question.setQuestion(Question4.getText());
                        answer.setAnswersType("Textual");
                        answer.setAnswerText(Answer4.getText());
                        break;
                    }
                    case 5: {
                        question.setQuestion(Question5.getText());
                        answer.setAnswersType("Textual");
                        answer.setAnswerText(Answer5.getText());
                        break;
                    }
                    case 6: {
                        question.setQuestion(Question6.getText());
                        answer.setAnswersType("Textual");
                        answer.setAnswerText(Answer6.getText());
                        break;
                    }
                    case 7: {
                        question.setQuestion(Question7.getText());
                        answer.setAnswersType("Textual");
                        answer.setAnswerText(Answer7.getText());
                        break;
                    }
                    case 8: {
                        question.setQuestion(Question8.getText());
                        answer.setAnswersType("Textual");
                        answer.setAnswerText(Answer8.getText());
                        break;
                    }
                    case 9: {
                        question.setQuestion(Question9.getText());
                        answer.setAnswersType("Textual");
                        if(Answer9.getText().equals("")){
                            answer.setAnswerText("None");
                        }
                        else {
                            answer.setAnswerText(Answer9.getText());
                        }
                        break;
                    }
                }


                questionManager.setQuestions(question);
                answer.setQuestion(question);
                answerManager.setAnswers(answer);
            }

            confirm.setContentText("Answer Submitted Successfully!");
            confirm.showAndWait();
            try {
                questionManager.close();
                answerManager.close();
                MainApp.setRoot("/fxml/AnswerSurvey.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Shows saved Answers for the questions
    private void showAnswersClicked(ActionEvent actionEvent) {
        ShowAnswersController.setData(userdata,survey);
        try {
            MainApp.setRoot("/fxml/ShowAnswers.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void backToTemplatesButtonClicked(ActionEvent actionEvent) {
        try {
            MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void backToAnswerButtonClicked(ActionEvent actionEvent){
        try {
            MainApp.setRoot("/fxml/AnswerSurvey.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void backToSavedSurveysButtonClicked(ActionEvent actionEvent){
        try {
            MainApp.setRoot("/fxml/SavedSurveys.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private Button q1Agree;

    @FXML
    private Button q1rta;

    @FXML
    private Button q1sDisagree;

    @FXML
    private Button q1sAgree;

    @FXML
    private Button q1Disagree;


    @FXML
    void q1AnswerClicked(ActionEvent event) {

        if(event.getSource().equals(q1Agree)) {
            Answer1.setText(q1Agree.getText());
        }
        if(event.getSource().equals(q1Disagree)) {
            Answer1.setText(q1Disagree.getText());
        }
        if(event.getSource().equals(q1rta)) {
            Answer1.setText(q1rta.getText());
        }
        if(event.getSource().equals(q1sAgree)) {
            Answer1.setText(q1sAgree.getText());
        }
        if(event.getSource().equals(q1sDisagree)) {
            Answer1.setText(q1sDisagree.getText());
        }
    }

    @FXML
    private Button q2Agree;

    @FXML
    private Button q2sAgree;

    @FXML
    private Button q2rta;

    @FXML
    private Button q2sDisagree;

    @FXML
    private Button q2Disagree;

    @FXML
    void q2AnswerClicked(ActionEvent event) {
        if(event.getSource().equals(q2Agree)) {
            Answer2.setText(q2Agree.getText());
        }
        if(event.getSource().equals(q2Disagree)) {
            Answer2.setText(q2Disagree.getText());
        }
        if(event.getSource().equals(q2rta)) {
            Answer2.setText(q2rta.getText());
        }
        if(event.getSource().equals(q2sAgree)) {
            Answer2.setText(q2sAgree.getText());
        }
        if(event.getSource().equals(q2sDisagree)) {
            Answer2.setText(q2sDisagree.getText());
        }
    }

    @FXML
    private Button q3Agree;

    @FXML
    private Button q3sAgree;

    @FXML
    private Button q3Disagree;

    @FXML
    private Button q3sDisagree;

    @FXML
    private Button q3rta;

    @FXML
    void q3AnswerClicked(ActionEvent event) {
        if(event.getSource().equals(q3Agree)) {
            Answer3.setText(q3Agree.getText());
        }
        if(event.getSource().equals(q3Disagree)) {
            Answer3.setText(q3Disagree.getText());
        }
        if(event.getSource().equals(q3rta)) {
            Answer3.setText(q3rta.getText());
        }
        if(event.getSource().equals(q3sAgree)) {
            Answer3.setText(q3sAgree.getText());
        }
        if(event.getSource().equals(q3sDisagree)) {
            Answer3.setText(q3sDisagree.getText());
        }
    }

    @FXML
    private Button q4Agree;

    @FXML
    private Button q4sAgree;

    @FXML
    private Button q4Disagree;

    @FXML
    private Button q4sDisagree;

    @FXML
    private Button q4rta;

    @FXML
    void q4AnswerClicked(ActionEvent event) {
        if(event.getSource().equals(q4Agree)) {
            Answer4.setText(q4Agree.getText());
        }
        if(event.getSource().equals(q4Disagree)) {
            Answer4.setText(q4Disagree.getText());
        }
        if(event.getSource().equals(q4rta)) {
            Answer4.setText(q4rta.getText());
        }
        if(event.getSource().equals(q4sAgree)) {
            Answer4.setText(q4sAgree.getText());
        }
        if(event.getSource().equals(q4sDisagree)) {
            Answer4.setText(q4sDisagree.getText());
        }

    }


    @FXML
    private Button q5Agree;

    @FXML
    private Button q5sAgree;

    @FXML
    private Button q5Disagree;

    @FXML
    private Button q5sDisagree;

    @FXML
    private Button q5rta;

    @FXML
    void q5AnswerClicked(ActionEvent event) {
        if(event.getSource().equals(q5Agree)) {
            Answer5.setText(q5Agree.getText());
        }
        if(event.getSource().equals(q5Disagree)) {
            Answer5.setText(q5Disagree.getText());
        }
        if(event.getSource().equals(q5rta)) {
            Answer5.setText(q5rta.getText());
        }
        if(event.getSource().equals(q5sAgree)) {
            Answer5.setText(q5sAgree.getText());
        }
        if(event.getSource().equals(q5sDisagree)) {
            Answer5.setText(q5sDisagree.getText());
        }

    }


    @FXML
    private Button q6Agree;

    @FXML
    private Button q6sAgree;

    @FXML
    private Button q6Disagree;

    @FXML
    private Button q6sDisagree;

    @FXML
    private Button q6rta;

    @FXML
    void q6AnswerClicked(ActionEvent event) {
        if(event.getSource().equals(q6Agree)) {
            Answer6.setText(q6Agree.getText());
        }
        if(event.getSource().equals(q6Disagree)) {
            Answer6.setText(q6Disagree.getText());
        }
        if(event.getSource().equals(q6rta)) {
            Answer6.setText(q6rta.getText());
        }
        if(event.getSource().equals(q6sAgree)) {
            Answer6.setText(q6sAgree.getText());
        }
        if(event.getSource().equals(q6sDisagree)) {
            Answer6.setText(q6sDisagree.getText());
        }

    }


    @FXML
    private Button q7Agree;

    @FXML
    private Button q7sAgree;

    @FXML
    private Button q7Disagree;

    @FXML
    private Button q7sDisagree;

    @FXML
    private Button q7rta;

    @FXML
    void q7AnswerClicked(ActionEvent event) {
        if(event.getSource().equals(q7Agree)) {
            Answer7.setText(q7Agree.getText());
        }
        if(event.getSource().equals(q7Disagree)) {
            Answer7.setText(q7Disagree.getText());
        }
        if(event.getSource().equals(q7rta)) {
            Answer7.setText(q7rta.getText());
        }
        if(event.getSource().equals(q7sAgree)) {
            Answer7.setText(q7sAgree.getText());
        }
        if(event.getSource().equals(q7sDisagree)) {
            Answer7.setText(q7sDisagree.getText());
        }

    }


    @FXML
    private Button q8Agree;

    @FXML
    private Button q8sAgree;

    @FXML
    private Button q8Disagree;

    @FXML
    private Button q8sDisagree;

    @FXML
    private Button q8rta;

    @FXML
    void q8AnswerClicked(ActionEvent event) {
        if(event.getSource().equals(q8Agree)) {
            Answer8.setText(q8Agree.getText());
        }
        if(event.getSource().equals(q8Disagree)) {
            Answer8.setText(q8Disagree.getText());
        }
        if(event.getSource().equals(q8rta)) {
            Answer8.setText(q8rta.getText());
        }
        if(event.getSource().equals(q8sAgree)) {
            Answer8.setText(q8sAgree.getText());
        }
        if(event.getSource().equals(q8sDisagree)) {
            Answer8.setText(q8sDisagree.getText());
        }
    }

}
