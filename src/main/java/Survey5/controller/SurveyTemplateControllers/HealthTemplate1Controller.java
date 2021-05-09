package Survey5.controller.SurveyTemplateControllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Survey5.MainApp;
import Survey5.controller.ShowAnswersController;
import Survey5.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class HealthTemplate1Controller
{
    private static Survey survey;
    private Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    private Alert warn = new Alert(Alert.AlertType.WARNING);
    private static Data userdata;
    SurveysDaoInterface surveyManager = new SurveyManager();
    QuestionsDaoInterface questionManager  = new QuestionsManager();
    AnswersDaoInterface answerManager = new AnswersManager();

    int NumberOfQuestions = 7;

    static String answer;

    @FXML
    private Label HealthTemplate1;

    @FXML
    private TextField Answer1;

    @FXML
    private TextField Answer2;

    @FXML
    private ToggleGroup answer3;

    @FXML
    private RadioButton Answer3_1;

    @FXML
    private RadioButton Answer3_2;

    private String Answer3;

    @FXML
    private ToggleGroup answer4;

    @FXML
    private RadioButton Answer4_1;

    @FXML
    private RadioButton Answer4_2;

    private String Answer4;

    @FXML
    private ToggleGroup answer5;

    @FXML
    private RadioButton Answer5_1;

    @FXML
    private RadioButton Answer5_2;

    private String Answer5;

    @FXML
    private ToggleGroup answer6;

    @FXML
    private RadioButton Answer6_1;

    @FXML
    private RadioButton Answer6_2;

    private String Answer6;

    @FXML
    private TextField Answer7;

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
    private Button saveButton;

    @FXML
    private Button backButton;

    @FXML
    private AnchorPane HealthTemplate1AnchorPane;

    public static void setData(Data userdata) {
        HealthTemplate1Controller.userdata=userdata;
    }

    public static void setCreateOrAnswerFunction(String answer){
        HealthTemplate1Controller.answer=answer;
    }

    public static void setCreateOrAnswerFunction(String answer,Survey survey){
        HealthTemplate1Controller.survey=survey;
        HealthTemplate1Controller.answer=answer;
    }
    @FXML
    private void initialize(){
        if(answer.equals("answer")){
            setAnswering();
        }
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
        else if(Answer1.getText().equals("") || Answer2.getText().equals("") || Answer7.getText().equals("")){
            warn.setContentText("You didn't submit all the answers!");
            warn.showAndWait();
        }
        else if(!setRadioButtons()){
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
                        answer.setAnswersType("RadioButton");
                        answer.setAnswerText(Answer3);
                        break;
                    }
                    case 4: {
                        question.setQuestion(Question4.getText());
                        answer.setAnswersType("RadioButton");
                        answer.setAnswerText(Answer4);
                        break;
                    }
                    case 5: {
                        question.setQuestion(Question5.getText());
                        answer.setAnswersType("RadioButton");
                        answer.setAnswerText(Answer5);
                        break;
                    }
                    case 6: {
                        question.setQuestion(Question6.getText());
                        answer.setAnswersType("RadioButton");
                        answer.setAnswerText(Answer6);
                        break;
                    }
                    case 7: {
                        question.setQuestion(Question7.getText());
                        answer.setAnswersType("Textual");
                        answer.setAnswerText(Answer7.getText());
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

    private boolean setRadioButtons(){
        if(Answer3_1.getToggleGroup().getSelectedToggle()==null||Answer4_1.getToggleGroup().getSelectedToggle()==null
            ||Answer5_1.getToggleGroup().getSelectedToggle()==null||Answer6_1.getToggleGroup().getSelectedToggle()==null){
            warn.setContentText("RadioButtons can't be empty!!");
            warn.showAndWait();
            return false;
        }
        else{
            if(Answer3_1.getToggleGroup().getSelectedToggle().toString().contains("YES")){
                Answer3=Answer3_1.getText();
            }
            else{
                Answer3=Answer3_2.getText();
            }

            if(Answer4_1.getToggleGroup().getSelectedToggle().toString().contains("YES")){
                Answer4 = Answer4_1.getText();
            }
            else{
                Answer4=Answer4_2.getText();
            }

            if(Answer5_1.getToggleGroup().getSelectedToggle().toString().contains("YES")){
                Answer5=Answer5_1.getText();
            }
            else{
                Answer5=Answer5_2.getText();
            }

            if(Answer6_1.getToggleGroup().getSelectedToggle().toString().contains("YES")){
                Answer6=Answer6_1.getText();
            }
            else{
                Answer6=Answer6_2.getText();
            }
            return true;
        }
    }

    //submitting template to database of current user
    @FXML
    private void saveButtonClicked(ActionEvent event){
        Survey survey = new Survey();
        survey.setTypeOfTemplate(HealthTemplate1.getId());
        survey.setTitle(HealthTemplate1.getText());
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


    //Shows saved Answers for the questions
    private void showAnswersClicked(ActionEvent actionEvent) {
        ShowAnswersController.setData(userdata,survey);
        try {
            MainApp.setRoot("/fxml/ShowAnswers.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void backToAnswerButtonClicked(ActionEvent actionEvent) {
        try {
            MainApp.setRoot("/fxml/AnswerSurvey.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void backToTemplatesButtonClicked(ActionEvent actionEvent){
        try {
            MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void backToSavedSurveysButtonClicked(ActionEvent actionEvent) {
        try {
            MainApp.setRoot("/fxml/SavedSurveys.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    


}
