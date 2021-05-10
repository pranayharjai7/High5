package Survey5.controller.SurveyTemplateControllers;

import Survey5.MainApp;
import Survey5.controller.ShowAnswersController;
import Survey5.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.Rating;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SportsTemplate4Controller {
    private static Survey survey;
    private Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    private Alert warn = new Alert(Alert.AlertType.WARNING);
    private static Data userdata;
    SurveysDaoInterface surveyManager = new SurveyManager();
    QuestionsDaoInterface questionManager  = new QuestionsManager();
    AnswersDaoInterface answerManager = new AnswersManager();
    static String answer;
    int NumberOfQuestions = 6;

    @FXML
    private AnchorPane SportsTemplate4AnchorPane;
    @FXML
    private Label SportsTemplate4;
    @FXML
    private Label Question1;
    @FXML
    private Label Question2;
    @FXML
    private Label Question3;
    @FXML
    private Label Question4;
    @FXML
    private Label Question5;
    @FXML
    private Label Question6;
    @FXML
    private ToggleGroup answer1;
    @FXML
    private RadioButton Answer1_1;
    @FXML
    private RadioButton Answer1_2;
    @FXML
    private ToggleGroup answer2;
    @FXML
    private RadioButton Answer2_1;
    @FXML
    private RadioButton Answer2_2;
    @FXML
    private ToggleGroup answer3;
    @FXML
    private RadioButton Answer3_1;
    @FXML
    private RadioButton Answer3_2;
    @FXML
    private Rating Answer4;
    @FXML
    private TextField Answer5;
    @FXML
    private TextArea Answer6;
    @FXML
    private Button saveButton;
    @FXML
    private Button backButton;
    private String Answer1;
    private String Answer2;
    private String Answer3;

    public static void setData(Data userdata) {
        SportsTemplate4Controller.userdata=userdata;
    }

    public static void setCreateOrAnswerFunction(String answer){
        SportsTemplate4Controller.answer=answer;
    }

    public static void setCreateOrAnswerFunction(String answer, Survey survey){
        SportsTemplate4Controller.survey=survey;
        SportsTemplate4Controller.answer=answer;
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
        Answer4.setRating(0);
    }

    private void setCreating() {
        saveButton.setText("Save");
        saveButton.setOnAction(this::saveButtonClicked);
        backButton.setOnAction(this::backToTemplatesButtonClicked);
    }

    private void setAnswering(){
        saveButton.setText("Submit");
        saveButton.setOnAction(this::submitButtonClicked);
        backButton.setOnAction(this::backToAnswerButtonClicked);
    }

    private void setShowAnswers(){
        saveButton.setText("Show Answers");
        saveButton.setPrefWidth(150);
        saveButton.setOnAction(this::showAnswersClicked);
        backButton.setOnAction(this::backToSavedSurveysButtonClicked);
    }

    //submitting template to database of current user
    @FXML
    private void saveButtonClicked(ActionEvent event){
        Survey survey = new Survey();
        survey.setTypeOfTemplate(SportsTemplate4.getId());
        survey.setTitle(SportsTemplate4.getText());
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
        for (Questions question : qList) {
            if (question.getAnsweredByUser().getId() == userdata.getId()) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            warn.setContentText("You have already answered this Survey!");
            warn.showAndWait();
        }
        else if(!setRadioButtons()){
            warn.setContentText("You didn't submit all the answers!");
            warn.showAndWait();
        }
        else if(!setRating()){
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
                        answer.setAnswersType("RadioButton");
                        answer.setAnswerText(Answer1);
                        break;
                    }
                    case 2: {
                        question.setQuestion(Question2.getText());
                        answer.setAnswersType("RadioButton");
                        answer.setAnswerText(Answer2);
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
                        answer.setAnswersType("Rating");
                        answer.setAnswerText("Rating: "+Answer4.getRating());
                        break;
                    }
                    case 5: {
                        question.setQuestion(Question5.getText());
                        answer.setAnswersType("Textual");
                        if(Answer5.getText().equals("")){
                            answer.setAnswerText("None");
                        }
                        else {
                            answer.setAnswerText(Answer5.getText());
                        }
                        break;
                    }
                    case 6: {
                        question.setQuestion(Question6.getText());
                        answer.setAnswersType("Textual");
                        if(Answer6.getText().equals("")){
                            answer.setAnswerText("None");
                        }
                        else {
                            answer.setAnswerText(Answer6.getText());
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

    private boolean setRadioButtons(){
        if(answer1.getSelectedToggle()==null||answer2.getSelectedToggle()==null||answer3.getSelectedToggle()==null){
            return false;
        }
        else{
            Answer1 = answer1.getSelectedToggle().toString().substring(51,answer1.getSelectedToggle().toString().length()-1);
            Answer2 = answer2.getSelectedToggle().toString().substring(51,answer2.getSelectedToggle().toString().length()-1);
            Answer3 = answer3.getSelectedToggle().toString().substring(51,answer3.getSelectedToggle().toString().length()-1);
            return true;
        }
    }

    private boolean setRating() {
        if(Answer4.getRating()==0){
            warn.setContentText("Ratings can't be empty!!");
            warn.showAndWait();
            return false;
        }
        return true;
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
