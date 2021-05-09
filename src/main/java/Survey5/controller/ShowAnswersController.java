package Survey5.controller;

import Survey5.MainApp;
import Survey5.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShowAnswersController {

        private static Data userData;
        private static Survey survey;
        private SurveysDaoInterface surveyManager = new SurveyManager();
        private QuestionsDaoInterface questionsManager = new QuestionsManager();
        private AnswersDaoInterface answersManager = new AnswersManager();
        private List<Questions> qList = new ArrayList<>();
        private List<Questions> qUserSurveyList = new ArrayList<>();
        private List<Questions> qNumSurveyList = new ArrayList<>();
        private List<Answers> aList = new ArrayList<>();
        private List<Label> qLabelList = new ArrayList<>();
        private List<Label> aLabelList = new ArrayList<>();
        private List<Integer> qNumberList = new ArrayList<>();
        private Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        private Alert warn = new Alert(Alert.AlertType.WARNING);

        @FXML
        private AnchorPane showAnswersAnchorPane;

        @FXML
        private Label titleLabel;

        public static void setData(Data userData, Survey survey){
                ShowAnswersController.userData = userData;
                ShowAnswersController.survey = survey;
        }

        @FXML
        private void initialize(){
                qList = questionsManager.getSurveyQuestions(survey);
                if(qList.isEmpty()){
                        warn.setContentText("No Answers yet!");
                        warn.showAndWait();
                        try {
                                MainApp.setRoot("/fxml/SavedSurveys.fxml");
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
                else {
                        addQuestions();
                        addAnswers();
                }
        }

        private void addQuestions(){
                qUserSurveyList = qList.stream()
                        .filter(questions -> questions.getAnsweredByUser().equals(qList.get(0).getAnsweredByUser()))
                        .collect(Collectors.toList());
                for(int i = 0; i<qUserSurveyList.size(); i++){
                        qLabelList.add(new Label());
                        qLabelList.get(qLabelList.size()-1).setText(qUserSurveyList.get(i).getQuestionNumber()+" "+qUserSurveyList.get(i).getQuestion());
                        qLabelList.get(qLabelList.size()-1).setId(qUserSurveyList.get(i).getQuestionNumber()+"");
                        qLabelList.get(qLabelList.size()-1).setLayoutX(20);
                        if(i==0){
                                qLabelList.get(qLabelList.size()-1).setLayoutY(titleLabel.getLayoutY()+50);
                        }
                        else{
                                qLabelList.get(qLabelList.size()-1).setLayoutY(qLabelList.get(qLabelList.size()-2).getLayoutY()+50);
                        }
                        showAnswersAnchorPane.getChildren().add(qLabelList.get(qLabelList.size()-1));
                }
        }

        //sort questions by question number
        private void addAnswers(){
                for (Questions question:qList) {
                        if(!qNumberList.contains(question.getQuestionNumber())){
                                qNumberList.add(question.getQuestionNumber());
                        }
                }
                for (Integer qNum:qNumberList) {
                        qNumSurveyList = qList.stream()
                                        .filter(questions -> questions.getQuestionNumber()==qNum)
                                        .collect(Collectors.toList());
                        aLabelList.clear();
                        for (Questions question: qNumSurveyList) {
                                aList = answersManager.getQuestionAnswers(question);
                                for (Answers answer:aList) {
                                        for (Label qLabel: qLabelList) {
                                                if(answer.getQuestion().getQuestionNumber()==Integer.parseInt(qLabel.getId())){
                                                        aLabelList.add(new Label());
                                                        aLabelList.get(aLabelList.size()-1).setText(answer.getAnswerText());
                                                        aLabelList.get(aLabelList.size()-1).setLayoutX(40);
                                                        if(aLabelList.size()<=1){
                                                                aLabelList.get(aLabelList.size()-1).setLayoutY(qLabel.getLayoutY()+30);
                                                        }
                                                        else{
                                                                aLabelList.get(aLabelList.size()-1)
                                                                        .setLayoutY(aLabelList.get(aLabelList.size()-2).getLayoutY()+30);
                                                        }
                                                        for (int i = qLabelList.indexOf(qLabel)+1; i< qLabelList.size();i++){
                                                                qLabelList.get(i).setLayoutY(qLabelList.get(i).getLayoutY()+30);
                                                        }
                                                        showAnswersAnchorPane.getChildren().add(aLabelList.get(aLabelList.size()-1));
                                                }
                                        }
                                }
                        }
                }

        }

        //sort questions by user and then add to screen
        /*
        private void addAnswers() {
                checkedUserList = new ArrayList<>();
                for (Questions question: qList) {
                        if (!checkedUserList.contains(question.getAnsweredByUser())) {
                                checkedUserList.add(question.getAnsweredByUser());
                        }
                }

                for (Data user: checkedUserList) {
                        qUserSurveyList = questionsManager.getSurveyQuestions(survey).stream()
                                                .filter(questions -> questions.getAnsweredByUser().equals(user))
                                                .collect(Collectors.toList());
                        for (Questions question:qUserSurveyList) {
                                aList=answersManager.getQuestionAnswers(question);
                                for (Answers answer: aList) {
                                        for (Label qLabel:qLabelList) {
                                                if(question.getQuestionNumber()== Integer.parseInt(qLabel.getId())){
                                                        aLabelList.add(new Label());
                                                        aLabelList.get(aLabelList.size()-1).setText(answer.getAnswerText());
                                                        aLabelList.get(aLabelList.size()-1).setLayoutX(40);
                                                        if(aLabelList.size()<=qLabelList.size()) {
                                                                aLabelList.get(aLabelList.size()-1).setLayoutY(qLabel.getLayoutY() + 30);
                                                        }
                                                        else{
                                                                aLabelList.get(aLabelList.size()-1).setLayoutY(aLabelList.get(aLabelList.size()-qLabelList.size()-1).getLayoutY()+30);
                                                        }
                                                        for (int i = qLabelList.indexOf(qLabel)+1; i< qLabelList.size();i++){
                                                                qLabelList.get(i).setLayoutY(qLabelList.get(i).getLayoutY()+30);
                                                        }
                                                        showAnswersAnchorPane.getChildren().add(aLabelList.get(aLabelList.size()-1));
                                                }
                                        }

                                }
                        }
                }
        }

         */

        public void backButtonClicked(ActionEvent actionEvent) {
                try {
                        MainApp.setRoot("/fxml/SavedSurveys.fxml");
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
}
