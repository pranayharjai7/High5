package Survey5.controller;

import Survey5.MainApp;
import Survey5.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NewSurveyController {

    private Alert warn = new Alert(Alert.AlertType.WARNING);
    private Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    private Label CreateOwnSurvey = new Label();
    SurveysDaoInterface surveyManager = new SurveyManager();
    QuestionsDaoInterface questionManager  = new QuestionsManager();
    AnswersDaoInterface answerManager = new AnswersManager();
    private static Data userdata;
    private static Survey survey;
    private static String answer;
    private TextField questionField = new TextField();
    private Button questionOkButton = new Button("OK");
    private List<Label> questionList = new ArrayList<>();
    private ChoiceBox<String> questionChoice = new ChoiceBox<>();
    private Button questionChoiceOkButton = new Button("OK");
    private  String qType1="Choose Type..";
    private  String qType2="Textual";
    private  String qType3="RadioButton";
    private  String qType4="CheckBox";
     Button addRadioButton = new Button("Add Option..");
     Button radioDoneButton = new Button("Done");


    @FXML
    private  AnchorPane newSurveyAnchorPane;
    @FXML
    private  TextField titleTextField;
    @FXML
    private  Button okButton;
    @FXML
    private  Button addQuestionButton;
    @FXML
    private  Button saveButton;
    @FXML
    private Button backButton;

    public static void setData(Data userdata) {
        NewSurveyController.userdata=userdata;
    }

    public static void setCreateOrAnswerFunction(String answer){
        NewSurveyController.answer=answer;
    }

    public static void setCreateOrAnswerFunction(String answer, Survey survey){
        NewSurveyController.survey=survey;
        NewSurveyController.answer=answer;
    }

    @FXML
    private void initialize(){
        CreateOwnSurvey.setId("CreateOwnSurvey");
        CreateOwnSurvey.setFont(titleTextField.getFont());
        if(answer.equals("answer")){
            setAnswering();
        }
        else if(answer.equals("create"))
            setCreating();
        else
            setShowAnswers();
    }
    private void setCreating(){
        saveButton.setText("Save");
        saveButton.setOnAction(this::saveButtonClicked);
        backButton.setOnAction(this::backToTemplatesButtonClicked);
    }

    List<Label> QuestionLabelList = new ArrayList<>();
    List<TextArea> AnswerLabelList = new ArrayList<>();
    private void setAnswering(){
        saveButton.setText("Submit");
        saveButton.setOnAction(this::submitButtonClicked);
        backButton.setOnAction(this::backToAnswerButtonClicked);
        newSurveyAnchorPane.getChildren().removeAll(titleTextField,okButton,addQuestionButton);
        CreateOwnSurvey.setText(survey.getTitle());
        CreateOwnSurvey.setLayoutX((newSurveyAnchorPane.getPrefWidth()/2)-(CreateOwnSurvey.getText().length()*11)/2);
        CreateOwnSurvey.setLayoutY(titleTextField.getLayoutY());
        newSurveyAnchorPane.getChildren().add(CreateOwnSurvey);
        List<Questions> qList = new ArrayList<>();
        qList = questionManager.getSurveyQuestions(survey);
        Data user = qList.get(0).getAnsweredByUser();
        qList = qList.stream()
                .filter(questions -> questions.getAnsweredByUser().equals(user))
                .collect(Collectors.toList());
        for (Questions question:qList) {
            Label questions = new Label(question.getQuestion());
            questions.setLayoutX(20);
            if(QuestionLabelList.isEmpty()){
                questions.setLayoutY(CreateOwnSurvey.getLayoutY()+50);
            }
            else {
                questions.setLayoutY(saveButton.getLayoutY());
            }
            QuestionLabelList.add(questions);
            saveButton.setLayoutY(saveButton.getLayoutY()+50);

            TextArea answerArea = new TextArea();
            answerArea.setText("");
            answerArea.setPromptText("Enter Answer here..");
            answerArea.setPrefWidth(400);
            answerArea.setPrefHeight(75);
            answerArea.setLayoutX(20);
            answerArea.setLayoutY(questions.getLayoutY()+30);

            AnswerLabelList.add(answerArea);
            saveButton.setLayoutY(saveButton.getLayoutY()+80);
            newSurveyAnchorPane.getChildren().addAll(questions,answerArea);
        }

    }

    private void setShowAnswers(){
        saveButton.setText("Show Answers");
        saveButton.setPrefWidth(200);
        saveButton.setOnAction(this::showAnswersClicked);
        backButton.setOnAction(this::backToSavedSurveysButtonClicked);
        newSurveyAnchorPane.getChildren().removeAll(titleTextField,okButton,addQuestionButton);
        CreateOwnSurvey.setText(survey.getTitle());
        CreateOwnSurvey.setLayoutX((newSurveyAnchorPane.getPrefWidth()/2)-(CreateOwnSurvey.getText().length()*11)/2);
        CreateOwnSurvey.setLayoutY(titleTextField.getLayoutY());
        newSurveyAnchorPane.getChildren().add(CreateOwnSurvey);
        List<Questions> qList = new ArrayList<>();
        qList = questionManager.getSurveyQuestions(survey);
        Data user = qList.get(0).getAnsweredByUser();
        qList = qList.stream()
                .filter(questions -> questions.getAnsweredByUser().equals(user))
                .collect(Collectors.toList());
        for (Questions question:qList) {
            Label questions = new Label(question.getQuestion());
            questions.setLayoutX(20);
            if(QuestionLabelList.isEmpty()){
                questions.setLayoutY(CreateOwnSurvey.getLayoutY()+50);
            }
            else {
                questions.setLayoutY(saveButton.getLayoutY());
            }
            QuestionLabelList.add(questions);
            saveButton.setLayoutY(saveButton.getLayoutY()+50);

            TextArea answerArea = new TextArea();
            answerArea.setText("");
            answerArea.setPromptText("Enter Answer here..");
            answerArea.setPrefWidth(400);
            answerArea.setPrefHeight(75);
            answerArea.setLayoutX(20);
            answerArea.setLayoutY(questions.getLayoutY()+30);

            AnswerLabelList.add(answerArea);
            saveButton.setLayoutY(saveButton.getLayoutY()+80);
            newSurveyAnchorPane.getChildren().addAll(questions,answerArea);
        }
    }

    private void showAnswersClicked(ActionEvent actionEvent) {
        ShowAnswersController.setData(userdata,survey);
        try {
            MainApp.setRoot("/fxml/ShowAnswers.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Save Survey
    @FXML
    private void saveButtonClicked(ActionEvent event){
        if(questionList.isEmpty()){
            warn.setContentText("Please add Questions!");
            warn.showAndWait();
        }
        else {
            Survey survey = new Survey();
            survey.setTypeOfTemplate(CreateOwnSurvey.getId());
            survey.setTitle(CreateOwnSurvey.getText());
            survey.setOwner(userdata);
            surveyManager.setSurvey(survey);
            int i = 1;
            for (Label question : questionList) {
                Questions questions = new Questions();
                questions.setQuestion(question.getText());
                questions.setQuestionNumber(i++);
                questions.setAnsweredByUser(userdata);
                questions.setSurveyTemplate(survey);
                questionManager.setQuestions(questions);
                Answers answers = new Answers();
                answers.setQuestion(questions);
                answers.setAnswersType("Textual");
                answers.setAnswerText(" ");
                answerManager.setAnswers(answers);
            }


            try {
                questionManager.close();
                answerManager.close();
                surveyManager.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            confirm.setContentText("Template Saved Successfully!!");
            confirm.showAndWait();
            try {
                MainApp.setRoot("/fxml/TemplateOrCreate.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        else if(qList.isEmpty() || flag==0){
            for (TextArea answer:AnswerLabelList) {
                if(answer.getText().equals("")){
                    flag = 2;
                    break;
                }
            }
            if(flag==2){
                warn.setContentText("Please Enter all The answers!");
                warn.showAndWait();
            }
            else if(flag==0){
                for (int i = 1; i <= QuestionLabelList.size(); i++) {
                    Questions question = new Questions();
                    question.setSurveyTemplate(survey);
                    question.setQuestionNumber(i);
                    question.setAnsweredByUser(userdata);
                    question.setQuestion(QuestionLabelList.get(i - 1).getText());
                    Answers answer = new Answers();
                    answer.setAnswersType("Textual");
                    answer.setAnswerText(AnswerLabelList.get(i - 1).getText());
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
    }

    //For Title
    @FXML
    private  void okButtonClicked(ActionEvent event) {
        if(titleTextField.getText().equals("")){
            warn.setContentText("Title can't be empty..");
            warn.showAndWait();
        }
        else{
            CreateOwnSurvey.setText(titleTextField.getText());
            CreateOwnSurvey.setFont(titleTextField.getFont());
            CreateOwnSurvey.setLayoutX((newSurveyAnchorPane.getPrefWidth()/2)-(CreateOwnSurvey.getText().length()*11)/2);
            CreateOwnSurvey.setLayoutY(titleTextField.getLayoutY());
            newSurveyAnchorPane.getChildren().add(CreateOwnSurvey);
            newSurveyAnchorPane.getChildren().removeAll(titleTextField,okButton);
        }
    }

    //To Add Question in Survey
    @FXML
    private  void addQuestionButtonClicked(ActionEvent event) {
        questionChoice.getItems().removeAll(qType1,qType2);
        questionChoice.getItems().addAll(qType1,qType2);
        questionChoice.setValue("Choose Type..");
        questionChoice.setLayoutX(20);
        questionChoice.setLayoutY(addQuestionButton.getLayoutY());
        questionChoiceOkButton.setLayoutX(questionChoice.getLayoutX()+120);
        questionChoiceOkButton.setLayoutY(questionChoice.getLayoutY());
        questionChoiceOkButton.setOnAction(this::questionChoiceOkButtonClicked);

        addQuestionButton.setLayoutY(addQuestionButton.getLayoutY()+50);
        saveButton.setLayoutY(addQuestionButton.getLayoutY());
        newSurveyAnchorPane.getChildren().addAll(questionChoice,questionChoiceOkButton);

    }

    //After Choosing question type from drop down menu
    private  void questionChoiceOkButtonClicked(ActionEvent actionEvent) {
        if(questionChoice.getValue().equals(qType1)){
            warn.setContentText("You have to choose a type of question..");
            warn.showAndWait();
        }
        else{
            questionField.setText("");
            questionField.setPromptText("Enter Question Here");
            questionField.setPrefWidth(200);
            questionField.setLayoutX(20);
            questionField.setLayoutY(questionChoice.getLayoutY());

            questionOkButton.setLayoutX(questionField.getLayoutX()+questionField.getPrefWidth()+20);
            questionOkButton.setLayoutY(questionField.getLayoutY());
            newSurveyAnchorPane.getChildren().removeAll(questionChoice,questionChoiceOkButton);
            newSurveyAnchorPane.getChildren().addAll(questionField,questionOkButton);

            if(questionChoice.getValue().equals(qType2))
                questionOkButton.setOnAction(this::textQuestionOkButtonClicked);
            /*
            else if(questionChoice.getValue().equals(qType3))
                questionOkButton.setOnAction(this::radioOkButtonClicked);
            else if(questionChoice.getValue().equals(qType4))
                questionOkButton.setOnAction(this::checkboxOkButtonClicked);

             */
        }
    }

    /*
    AFTER ENTERING THE QUESTION
     */

    //if answer is textual
    private void textQuestionOkButtonClicked(ActionEvent actionEvent) {

        if(questionField.getText().equals("")){
            warn.setContentText("Question Can't be empty");
            warn.showAndWait();
        }
        else {
            Label question = new Label(questionField.getText());
            question.setLayoutX(questionField.getLayoutX());
            question.setLayoutY(questionField.getLayoutY());

            TextArea answerArea = new TextArea();
            answerArea.setText("");
            answerArea.setPromptText("Enter Answer here..");
            answerArea.setPrefWidth(400);
            answerArea.setPrefHeight(75);
            answerArea.setLayoutX(20);
            answerArea.setLayoutY(questionField.getLayoutY()+30);

            addQuestionButton.setLayoutY(addQuestionButton.getLayoutY()+80);
            saveButton.setLayoutY(addQuestionButton.getLayoutY());

            newSurveyAnchorPane.getChildren().removeAll(questionField, questionOkButton);
            newSurveyAnchorPane.getChildren().addAll(question,answerArea);
            questionList.add(question);
        }
    }



    /*
    //if answer has radio buttons
    private void radioOkButtonClicked(ActionEvent actionEvent) {
        if(questionField.getText().equals("")){
            warn.setContentText("Question Can't be empty");
            warn.showAndWait();
        }
        else{
            Label question = new Label(questionField.getText());
            question.setLayoutX(questionField.getLayoutX());
            question.setLayoutY(questionField.getLayoutY());

            addRadioButton.setLayoutX(20);
            addRadioButton.setLayoutY(question.getLayoutY()+30);
            addRadioButton.setOnAction(this::addRadioOptionClicked);

            radioDoneButton.setLayoutX(addRadioButton.getLayoutX()+100);
            radioDoneButton.setLayoutY(addRadioButton.getLayoutY());
            radioDoneButton.setOnAction(this::radioOptionsDoneClicked);


            addQuestionButton.setLayoutY(addQuestionButton.getLayoutY()+50);
            saveButton.setLayoutY(addQuestionButton.getLayoutY());

            newSurveyAnchorPane.getChildren().removeAll(questionField, questionOkButton);
            newSurveyAnchorPane.getChildren().addAll(question,addRadioButton,radioDoneButton);
        }
    }


     TextField radioField  = new TextField();
     Button radioTextEnteredButton = new Button("Ok");
    private  List<RadioButton> rButtons = new ArrayList<>();
    private List<List<RadioButton>> listOfrButtons = new ArrayList<>();
    private List<ToggleGroup> tgList = new ArrayList<>();
    //To add radio option
    private void addRadioOptionClicked(ActionEvent actionEvent) {
        RadioButton radioButton = new RadioButton();
        radioButton.setLayoutX(20);
        radioButton.setLayoutY(addRadioButton.getLayoutY());

        radioField.setText("");
        radioField.setPromptText("Enter Option Text Here");
        radioField.setPrefWidth(200);
        radioField.setLayoutX(40);
        radioField.setLayoutY(radioButton.getLayoutY());

        rButtons.add(radioButton);

        radioTextEnteredButton.setLayoutX(radioField.getLayoutX()+radioField.getPrefWidth()+10);
        radioTextEnteredButton.setLayoutY(radioField.getLayoutY());
        radioTextEnteredButton.setOnAction(this::RadioOptionConfirmed);

        addRadioButton.setLayoutY(radioButton.getLayoutY()+50);
        radioDoneButton.setLayoutY(addRadioButton.getLayoutY());
        addQuestionButton.setLayoutY(addQuestionButton.getLayoutY()+50);
        saveButton.setLayoutY(addQuestionButton.getLayoutY());

        newSurveyAnchorPane.getChildren().addAll(radioButton,radioField,radioTextEnteredButton);
    }

    //option Confirmed
    private void RadioOptionConfirmed(ActionEvent actionEvent) {
        if(radioField.getText().equals("")){
            warn.setContentText("Option Can't be empty");
            warn.showAndWait();
        }
        else {
            rButtons.get(rButtons.size() - 1).setText(radioField.getText());
            newSurveyAnchorPane.getChildren().removeAll(radioField, radioTextEnteredButton);
        }
    }

    //To submit all the radio options
    private void radioOptionsDoneClicked(ActionEvent actionEvent) {

        ToggleGroup tg = new ToggleGroup();
        tgList.add(tg);
        listOfrButtons.add(rButtons);
        for(int i=0; i<rButtons.size();i++)
        {
            listOfrButtons.get(listOfrButtons.size()-1).get(i).setToggleGroup(tgList.get(tgList.size()-1));
        }

        addQuestionButton.setLayoutY(addQuestionButton.getLayoutY()-50);
        saveButton.setLayoutY(addQuestionButton.getLayoutY());
        newSurveyAnchorPane.getChildren().removeAll(addRadioButton,radioDoneButton);
    }




    //if answer has checkboxes
    private void checkboxOkButtonClicked(ActionEvent actionEvent) {
        if(questionField.getText().equals("")){
            warn.setContentText("Question Can't be empty");
            warn.showAndWait();
        }
    }


     */

    @FXML
    private void backToTemplatesButtonClicked(ActionEvent actionEvent){
        try {
            MainApp.setRoot("/fxml/SurveyTemplates/TemplateSurvey.fxml");
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

    private void backToSavedSurveysButtonClicked(ActionEvent actionEvent) {
        try {
            MainApp.setRoot("/fxml/SavedSurveys.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        
        
}
