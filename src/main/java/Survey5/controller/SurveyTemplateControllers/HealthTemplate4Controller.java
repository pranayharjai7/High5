package Survey5.controller.SurveyTemplateControllers;

import Survey5.MainApp;
import Survey5.controller.ShowAnswersController;
import static Survey5.controller.SurveyTemplateControllers.HealthTemplate1Controller.answer;
import Survey5.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HealthTemplate4Controller {
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
    
        public HealthTemplate4Controller() {
        if(userdata == null && answer == null){
        this.answer = "none";
        this.userdata = new Data("none", "none", "none", "none");
        }
    }

    @FXML
    private AnchorPane HealthTemplate4AnchorPane;
    @FXML
    private Label HealthTemplate4;

    @FXML
    private Label Question1;
    @FXML
    private Label Question2;
    @FXML
    private Label Question3;
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
    private Text Question10;
    @FXML
    private Text Question11;
    @FXML
    private Text Question12;
    @FXML
    private Text Question13;
    @FXML
    private Text Question14;
    @FXML
    private Text Question15;

    @FXML
    private TextField Answer1;
    @FXML
    private TextField Answer2;
    @FXML
    private TextField Answer3;
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
    private ToggleGroup answer6;
    @FXML
    private RadioButton Answer6_1;
    @FXML
    private RadioButton Answer6_2;
    @FXML
    private ToggleGroup answer7;
    @FXML
    private RadioButton Answer7_1;
    @FXML
    private RadioButton Answer7_2;
    @FXML
    private ToggleGroup answer8;
    @FXML
    private RadioButton Answer8_1;
    @FXML
    private RadioButton Answer8_2;
    @FXML
    private ToggleGroup answer9;
    @FXML
    private RadioButton Answer9_1;
    @FXML
    private RadioButton Answer9_2;
    @FXML
    private ToggleGroup answer10;
    @FXML
    private RadioButton Answer10_1;
    @FXML
    private RadioButton Answer10_2;
    @FXML
    private ToggleGroup answer11;
    @FXML
    private RadioButton Answer11_1;
    @FXML
    private RadioButton Answer11_2;
    @FXML
    private ToggleGroup answer12;
    @FXML
    private RadioButton Answer12_1;
    @FXML
    private RadioButton Answer12_2;
    @FXML
    private ToggleGroup answer13;
    @FXML
    private RadioButton Answer13_1;
    @FXML
    private RadioButton Answer13_2;
    @FXML
    private ToggleGroup answer14;
    @FXML
    private RadioButton Answer14_1;
    @FXML
    private RadioButton Answer14_2;
    @FXML
    private TextArea Answer15;
    private String Answer4;
    private String Answer5;
    private String Answer6;
    private String Answer7;
    private String Answer8;
    private String Answer9;
    private String Answer10;
    private String Answer11;
    private String Answer12;
    private String Answer13;
    private String Answer14;

    @FXML
    private Button saveButton;
    @FXML
    private Button backButton;

    public static void setData(Data userdata) {
        HealthTemplate4Controller.userdata=userdata;
    }

    public static void setCreateOrAnswerFunction(String answer){
        HealthTemplate4Controller.answer=answer;
    }

    public static void setCreateOrAnswerFunction(String answer,Survey survey){
        HealthTemplate4Controller.survey=survey;
        HealthTemplate4Controller.answer=answer;
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

    @FXML
    public void saveButtonClicked(ActionEvent actionEvent) {
        Survey survey = new Survey();
        survey.setTypeOfTemplate(HealthTemplate4.getId());
        survey.setTitle(HealthTemplate4.getText());
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
        else if(Answer1.getText().equals("") || Answer2.getText().equals("") || Answer3.getText().equals("")){
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
                        answer.setAnswersType("Textual");
                        answer.setAnswerText(Answer3.getText());
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
                        answer.setAnswersType("RadioButton");
                        answer.setAnswerText(Answer7);
                        break;
                    }
                    case 8: {
                        question.setQuestion(Question8.getText());
                        answer.setAnswersType("RadioButton");
                        answer.setAnswerText(Answer8);
                        break;
                    }
                    case 9: {
                        question.setQuestion(Question9.getText());
                        answer.setAnswersType("RadioButton");
                        answer.setAnswerText(Answer9);
                        break;
                    }
                    case 10: {
                        question.setQuestion(Question10.getText());
                        answer.setAnswersType("RadioButton");
                        answer.setAnswerText(Answer10);
                        break;
                    }
                    case 11: {
                        question.setQuestion(Question11.getText());
                        answer.setAnswersType("RadioButton");
                        answer.setAnswerText(Answer11);
                        break;
                    }
                    case 12: {
                        question.setQuestion(Question12.getText());
                        answer.setAnswersType("RadioButton");
                        answer.setAnswerText(Answer12);
                        break;
                    }
                    case 13: {
                        question.setQuestion(Question13.getText());
                        answer.setAnswersType("RadioButton");
                        answer.setAnswerText(Answer13);
                        break;
                    }
                    case 14: {
                        question.setQuestion(Question14.getText());
                        answer.setAnswersType("RadioButton");
                        answer.setAnswerText(Answer14);
                        break;
                    }
                    case 15: {
                        question.setQuestion(Question15.getText());
                        answer.setAnswersType("Textual");
                        if(Answer15.getText().equals("")){
                            answer.setAnswerText("None");
                        }else {
                            answer.setAnswerText(Answer15.getText());
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

    public boolean setRadioButtons(){
        if(answer4.getSelectedToggle()==null||answer5.getSelectedToggle()==null||answer6.getSelectedToggle()==null||
                answer7.getSelectedToggle()==null||answer8.getSelectedToggle()==null||answer9.getSelectedToggle()==null||
                answer10.getSelectedToggle()==null||answer11.getSelectedToggle()==null||answer12.getSelectedToggle()==null||
                answer13.getSelectedToggle()==null||answer14.getSelectedToggle()==null){
            return false;
        }
        else{
            Answer4 = answer4.getSelectedToggle().toString().substring(51,answer4.getSelectedToggle().toString().length()-1);
            Answer5 = answer5.getSelectedToggle().toString().substring(51,answer5.getSelectedToggle().toString().length()-1);
            Answer6 = answer6.getSelectedToggle().toString().substring(51,answer6.getSelectedToggle().toString().length()-1);
            Answer7 = answer7.getSelectedToggle().toString().substring(51,answer7.getSelectedToggle().toString().length()-1);
            Answer8 = answer8.getSelectedToggle().toString().substring(51,answer8.getSelectedToggle().toString().length()-1);
            Answer9 = answer9.getSelectedToggle().toString().substring(51,answer9.getSelectedToggle().toString().length()-1);
            Answer10 = answer10.getSelectedToggle().toString().substring(52,answer10.getSelectedToggle().toString().length()-1);
            Answer11 = answer11.getSelectedToggle().toString().substring(52,answer11.getSelectedToggle().toString().length()-1);
            Answer12 = answer12.getSelectedToggle().toString().substring(52,answer12.getSelectedToggle().toString().length()-1);
            Answer13 = answer13.getSelectedToggle().toString().substring(52,answer13.getSelectedToggle().toString().length()-1);
            Answer14 = answer14.getSelectedToggle().toString().substring(52,answer14.getSelectedToggle().toString().length()-1);
            return true;
        }
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

    @FXML
    public void backToTemplatesButtonClicked(ActionEvent actionEvent){
        try {
            MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
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
