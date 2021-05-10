package Survey5.controller.SurveyTemplateControllers;

import Survey5.MainApp;
import Survey5.controller.ShowAnswersController;
import Survey5.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.controlsfx.control.Rating;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BusinessTemplate2Controller {
    private static Survey survey;
    private Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    private Alert warn = new Alert(Alert.AlertType.WARNING);
    private static Data userdata;
    SurveysDaoInterface surveyManager = new SurveyManager();
    QuestionsDaoInterface questionManager  = new QuestionsManager();
    AnswersDaoInterface answerManager = new AnswersManager();
    static String answer;
    int NumberOfQuestions = 15;
    int flag;

    public BusinessTemplate2Controller() {
        if(userdata == null && answer == null){
            this.answer = "none";
            this.userdata = new Data("none", "none", "none", "none");
        }
    }

    @FXML
    private AnchorPane BusinessTemplate2AnchorPane;
    @FXML
    private Label BusinessTemplate2;
    @FXML
    private Text Question1;
    @FXML
    private Text Question2;
    @FXML
    private Label Question3;
    @FXML
    private Label Question4;
    @FXML
    private Label Question5;
    @FXML
    private Label Question6;
    @FXML
    private Label Question7;
    @FXML
    private Label Question8;
    @FXML
    private Label Question9;
    @FXML
    private Label Question10;
    @FXML
    private Label Question11;
    @FXML
    private Label Question12;
    @FXML
    private Label Question13;
    @FXML
    private Label Question14;
    @FXML
    private Text Question15;

    @FXML
    private TextField Answer1;
    @FXML
    private TextField Answer2;
    @FXML
    private Rating Answer3;
    @FXML
    private Rating Answer4;
    @FXML
    private Rating Answer5;
    @FXML
    private Rating Answer6;
    @FXML
    private Rating Answer7;
    @FXML
    private Rating Answer8;
    @FXML
    private Rating Answer9;
    @FXML
    private Rating Answer10;
    @FXML
    private Rating Answer11;
    @FXML
    private Rating Answer12;
    @FXML
    private Rating Answer13;
    @FXML
    private Rating Answer14;
    @FXML
    private TextArea Answer15;
    @FXML
    private Button saveButton;
    @FXML
    private Button backButton;

    public static void setData(Data userdata) {
        BusinessTemplate2Controller.userdata=userdata;
    }

    public static void setCreateOrAnswerFunction(String answer){
        BusinessTemplate2Controller.answer=answer;
    }

    public static void setCreateOrAnswerFunction(String answer, Survey survey){
        BusinessTemplate2Controller.survey=survey;
        BusinessTemplate2Controller.answer=answer;
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

        Answer3.setRating(0);
        Answer4.setRating(0);
        Answer5.setRating(0);
        Answer6.setRating(0);
        Answer7.setRating(0);
        Answer8.setRating(0);
        Answer9.setRating(0);
        Answer10.setRating(0);
        Answer11.setRating(0);
        Answer12.setRating(0);
        Answer13.setRating(0);
        Answer14.setRating(0);
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
        survey.setTypeOfTemplate(BusinessTemplate2.getId());
        survey.setTitle(BusinessTemplate2.getText());
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
                        answer.setAnswersType("Rating");
                        answer.setAnswerText("Rating: "+Answer3.getRating());
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
                        answer.setAnswersType("Rating");
                        answer.setAnswerText("Rating: "+Answer5.getRating());
                        break;
                    }
                    case 6: {
                        question.setQuestion(Question6.getText());
                        answer.setAnswersType("Rating");
                        answer.setAnswerText("Rating: "+Answer6.getRating());
                        break;
                    }
                    case 7: {
                        question.setQuestion(Question7.getText());
                        answer.setAnswersType("Rating");
                        answer.setAnswerText("Rating: "+Answer7.getRating());
                        break;
                    }
                    case 8: {
                        question.setQuestion(Question8.getText());
                        answer.setAnswersType("Rating");
                        answer.setAnswerText("Rating: "+Answer8.getRating());
                        break;
                    }
                    case 9: {
                        question.setQuestion(Question9.getText());
                        answer.setAnswersType("Rating");
                        answer.setAnswerText("Rating: "+Answer9.getRating());
                        break;
                    }
                    case 10: {
                        question.setQuestion(Question10.getText());
                        answer.setAnswersType("Rating");
                        answer.setAnswerText("Rating: "+Answer10.getRating());
                        break;
                    }
                    case 11: {
                        question.setQuestion(Question11.getText());
                        answer.setAnswersType("Rating");
                        answer.setAnswerText("Rating: "+Answer11.getRating());
                        break;
                    }
                    case 12: {
                        question.setQuestion(Question12.getText());
                        answer.setAnswersType("Rating");
                        answer.setAnswerText("Rating: "+Answer12.getRating());
                        break;
                    }
                    case 13: {
                        question.setQuestion(Question13.getText());
                        answer.setAnswersType("Rating");
                        answer.setAnswerText("Rating: "+Answer13.getRating());
                        break;
                    }
                    case 14: {
                        question.setQuestion(Question14.getText());
                        answer.setAnswersType("Rating");
                        answer.setAnswerText("Rating: "+Answer14.getRating());
                        break;
                    }
                    case 15: {
                        question.setQuestion(Question15.getText());
                        answer.setAnswersType("Textual");
                        if(Answer15.getText().equals(""))
                            answer.setAnswerText("None");
                        else
                            answer.setAnswerText(Answer15.getText());
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
    public boolean setRating() {
        if(Answer3.getRating()==0||Answer4.getRating()==0 || Answer5.getRating()==0|| Answer6.getRating()==0
                || Answer7.getRating()==0|| Answer8.getRating()==0|| Answer9.getRating()==0|| Answer10.getRating()==0
                || Answer11.getRating()==0 || Answer12.getRating()==0|| Answer13.getRating()==0|| Answer14.getRating()==0){
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
