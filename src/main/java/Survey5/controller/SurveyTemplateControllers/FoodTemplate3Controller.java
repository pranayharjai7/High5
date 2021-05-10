package Survey5.controller.SurveyTemplateControllers;


import Survey5.MainApp;
import Survey5.controller.ShowAnswersController;
import Survey5.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import org.controlsfx.control.Rating;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FoodTemplate3Controller {

    private static Survey survey;
    private Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    private Alert warn = new Alert(Alert.AlertType.WARNING);
    private static Data userdata;
    SurveysDaoInterface surveyManager = new SurveyManager();
    QuestionsDaoInterface questionManager  = new QuestionsManager();
    AnswersDaoInterface answerManager = new AnswersManager();
    static String answer;
    int NumberOfQuestions = 7;
    int flag;

    public FoodTemplate3Controller() {
        if(userdata == null && answer == null){
            this.answer = "none";
            this.userdata = new Data("none", "none", "none", "none");
        }
    }

    @FXML
    private Label FoodTemplate3;
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
    private TextField Answer1;
    @FXML
    private TextField Answer2;
    @FXML
    private ToggleGroup answer3;
    @FXML
    private RadioButton Answer3_1;
    @FXML
    private RadioButton Answer3_2;
    @FXML
    private ToggleGroup answer4;
    @FXML
    private RadioButton Answer4_1;
    @FXML
    private RadioButton Answer4_2;
    @FXML
    private ToggleGroup answer5;
    @FXML
    private RadioButton Answer5_1;
    @FXML
    private RadioButton Answer5_2;
    @FXML
    private Slider Answer6;
    @FXML
    private Rating Answer7;
    @FXML
    private Button backButton;
    @FXML
    private Button saveButton;
    private String Answer3;
    private String Answer4;
    private String Answer5;

    public static void setData(Data userdata) {
        FoodTemplate3Controller.userdata=userdata;
    }

    public static void setCreateOrAnswerFunction(String answer){
        FoodTemplate3Controller.answer=answer;
    }

    public static void setCreateOrAnswerFunction(String answer, Survey survey){
        FoodTemplate3Controller.survey=survey;
        FoodTemplate3Controller.answer=answer;
    }

    @FXML
    public void initialize(){
        if(answer.equals("answer")){
            setAnswering();
        }
        else if(answer.equals("create"))
            setCreating();
        else
            setShowAnswers();

        Answer7.setRating(0);
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
    public void saveButtonClicked(ActionEvent event){
        Survey survey = new Survey();
        survey.setTypeOfTemplate(FoodTemplate3.getId());
        survey.setTitle(FoodTemplate3.getText());
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
    public void submitButtonClicked(ActionEvent actionEvent) {

        flag = 0;
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
        else if(Answer1.getText().equals("") || Answer2.getText().equals("")){
            warn.setContentText("You didn't submit all the answers!");
            warn.showAndWait();
        }
        else if(!setRadioButtons()){
            warn.setContentText("You didn't submit all the answers!");
            warn.showAndWait();
        }else if(!setRating()){
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
                        answer.setAnswersType("Slider");
                            answer.setAnswerText("Value: "+(int)Answer6.getValue());
                        break;
                    }
                    case 7: {
                        question.setQuestion(Question7.getText());
                        answer.setAnswersType("Rating");
                        answer.setAnswerText("Rating: "+ Answer7.getRating());
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

    public boolean setRadioButtons(){
        if(answer3.getSelectedToggle()==null||answer4.getSelectedToggle()==null||answer5.getSelectedToggle()==null){
            return false;
        }
        else{
            Answer3 = answer3.getSelectedToggle().toString().substring(51,answer3.getSelectedToggle().toString().length()-1);
            Answer4 = answer4.getSelectedToggle().toString().substring(51,answer4.getSelectedToggle().toString().length()-1);
            Answer5 = answer5.getSelectedToggle().toString().substring(51,answer5.getSelectedToggle().toString().length()-1);
            return true;
        }
    }

    public boolean setRating() {
        if(Answer7.getRating()==0){
            warn.setContentText("Ratings can't be empty!!");
            warn.showAndWait();
            return false;
        }
        return true;
    }

    //Shows saved Answers for the questions
    public void showAnswersClicked(ActionEvent actionEvent) {
        ShowAnswersController.setData(userdata,survey);
        try {
            MainApp.setRoot("/fxml/ShowAnswers.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backToAnswerButtonClicked(ActionEvent actionEvent) {
        try {
            MainApp.setRoot("/fxml/AnswerSurvey.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void backToTemplatesButtonClicked(ActionEvent actionEvent){
        try {
            MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backToSavedSurveysButtonClicked(ActionEvent actionEvent) {
        try {
            MainApp.setRoot("/fxml/SavedSurveys.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getAnswer() {
        return answer;
    }

    public Alert getConfirm() {
        return confirm;
    }

    public int getFlag() {
        return flag;
    }

    public Button getSaveButton() {
        return saveButton;
    }
}
