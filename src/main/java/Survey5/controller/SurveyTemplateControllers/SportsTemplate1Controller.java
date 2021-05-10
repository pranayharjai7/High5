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

public class SportsTemplate1Controller {

    private static Survey survey;
    private Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    private Alert warn = new Alert(Alert.AlertType.WARNING);
    private static Data userdata;
    SurveysDaoInterface surveyManager = new SurveyManager();
    QuestionsDaoInterface questionManager  = new QuestionsManager();
    AnswersDaoInterface answerManager = new AnswersManager();
    static String answer;
    int NumberOfQuestions = 7;

    @FXML
    private Label SportsTemplate1;
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
    private RadioButton Answer1_1;

    @FXML
    private ToggleGroup answer1;

    @FXML
    private RadioButton Answer1_2;

    @FXML
    private RadioButton Answer1_3;

    @FXML
    private RadioButton Answer1_4;

    @FXML
    private RadioButton Answer1_5;

    @FXML
    private RadioButton Answer1_6;

    @FXML
    private RadioButton Answer1_7;

    @FXML
    private RadioButton Answer1_8;

    @FXML
    private RadioButton Answer1_9;
    @FXML
    private ToggleGroup answer2;
    @FXML
    private RadioButton Answer2_1;
    @FXML
    private RadioButton Answer2_2;
    @FXML
    private RadioButton Answer2_3;
    @FXML
    private RadioButton Answer2_4;
    @FXML
    private RadioButton Answer2_5;
    @FXML
    private ToggleGroup answer3;
    @FXML
    private RadioButton Answer3_1;
    @FXML
    private RadioButton Answer3_2;
    @FXML
    private RadioButton Answer3_3;
    @FXML
    private RadioButton Answer3_4;
    @FXML
    private RadioButton Answer3_5;
    @FXML
    private CheckBox Answer4_1;
    @FXML
    private CheckBox Answer4_2;
    @FXML
    private CheckBox Answer4_3;
    @FXML
    private CheckBox Answer5_1;
    @FXML
    private CheckBox Answer5_2;
    @FXML
    private CheckBox Answer5_3;
    @FXML
    private CheckBox Answer5_4;
    @FXML
    private CheckBox Answer5_5;
    @FXML
    private CheckBox Answer5_6;
    @FXML
    private CheckBox Answer5_7;
    @FXML
    private CheckBox Answer5_8;
    @FXML
    private CheckBox Answer5_9;
    @FXML
    private CheckBox Answer5_10;
    @FXML
    private CheckBox Answer5_11;
    @FXML
    private CheckBox Answer5_12;
    @FXML
    private CheckBox Answer5_13;
    @FXML
    private CheckBox Answer5_14;
    @FXML
    private CheckBox Answer5_15;
    @FXML
    private CheckBox Answer5_16;
    @FXML
    private TextArea Answer6;
    @FXML
    private TextArea Answer7;
    @FXML
    private Button saveButton;
    @FXML
    private Button backButton;
    private String Answer1;
    private String Answer2;
    private String Answer3;
    private String Answer4 = "";
    private String Answer5 = "";

    public static void setData(Data userdata) {
        SportsTemplate1Controller.userdata=userdata;
    }

    public static void setCreateOrAnswerFunction(String answer){
        SportsTemplate1Controller.answer=answer;
    }

    public static void setCreateOrAnswerFunction(String answer, Survey survey){
        SportsTemplate1Controller.survey=survey;
        SportsTemplate1Controller.answer=answer;
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
        survey.setTypeOfTemplate(SportsTemplate1.getId());
        survey.setTitle(SportsTemplate1.getText());
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
        else if(!setCheckBoxes()){
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
                        answer.setAnswersType("CheckBox");
                        answer.setAnswerText(Answer4);
                        break;
                    }
                    case 5: {
                        question.setQuestion(Question5.getText());
                        answer.setAnswersType("CheckBox");
                        answer.setAnswerText(Answer5);
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
                    case 7: {
                        question.setQuestion(Question7.getText());
                        answer.setAnswersType("Textual");
                        if(Answer7.getText().equals("")){
                            answer.setAnswerText("None");
                        }
                        else {
                            answer.setAnswerText(Answer7.getText());
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

    private boolean setCheckBoxes() {
        if (!Answer4_1.isSelected() && !Answer4_2.isSelected() && !Answer4_3.isSelected()) {
            System.out.println("rofl");
            warn.setContentText("You Have to choose at least one option!");
            warn.showAndWait();
            return false;
        }
        if(!Answer5_1.isSelected() && !Answer5_2.isSelected() && !Answer5_3.isSelected()&&
                !Answer5_4.isSelected() && !Answer5_5.isSelected() && !Answer5_6.isSelected()&&
                !Answer5_7.isSelected() && !Answer5_8.isSelected() && !Answer5_9.isSelected()&&
                !Answer5_10.isSelected() && !Answer5_11.isSelected() && !Answer5_12.isSelected()&&
                !Answer5_13.isSelected() && !Answer5_14.isSelected() && !Answer5_15.isSelected()&&
                !Answer5_16.isSelected()){
            System.out.println("lmao");
            warn.setContentText("You Have to choose at least one option!");
            warn.showAndWait();
            return false;
        }
        if(Answer4_1.isSelected())
            Answer4 = Answer4+Answer4_1.getText()+" ";
        if(Answer4_2.isSelected())
            Answer4 = Answer4+Answer4_2.getText()+" ";
        if(Answer4_3.isSelected())
            Answer4 = Answer4+Answer4_3.getText()+" ";

        if(Answer5_1.isSelected())
            Answer5 = Answer5+Answer5_1.getText()+" ";
        if(Answer5_2.isSelected())
            Answer5 = Answer5+Answer5_2.getText()+" ";
        if(Answer5_3.isSelected())
            Answer5 = Answer5+Answer5_3.getText()+" ";
        if(Answer5_4.isSelected())
            Answer5 = Answer5+Answer5_4.getText()+" ";
        if(Answer5_5.isSelected())
            Answer5 = Answer5+Answer5_5.getText()+" ";
        if(Answer5_6.isSelected())
            Answer5 = Answer5+Answer5_6.getText()+" ";
        if(Answer5_7.isSelected())
            Answer5 = Answer5+Answer5_7.getText()+" ";
        if(Answer5_8.isSelected())
            Answer5 = Answer5+Answer5_8.getText()+" ";
        if(Answer5_9.isSelected())
            Answer5 = Answer5+Answer5_9.getText()+" ";
        if(Answer5_10.isSelected())
            Answer5 = Answer5+Answer5_10.getText()+" ";
        if(Answer5_11.isSelected())
            Answer5 = Answer5+Answer5_11.getText()+" ";
        if(Answer5_12.isSelected())
            Answer5 = Answer5+Answer5_12.getText()+" ";
        if(Answer5_13.isSelected())
            Answer5 = Answer5+Answer5_13.getText()+" ";
        if(Answer5_14.isSelected())
            Answer5 = Answer5+Answer5_14.getText()+" ";
        if(Answer5_15.isSelected())
            Answer5 = Answer5+Answer5_15.getText()+" ";
        if(Answer5_16.isSelected())
            Answer5 = Answer5+Answer5_16.getText()+" ";

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
