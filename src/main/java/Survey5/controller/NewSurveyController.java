package Survey5.controller;

import Survey5.MainApp;
import Survey5.model.Data;
import Survey5.model.Questions;
import Survey5.model.QuestionsDaoInterface;
import Survey5.model.QuestionsManager;
import Survey5.model.Survey;
import Survey5.model.SurveyManager;
import Survey5.model.SurveysDaoInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import static java.sql.JDBCType.NULL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import java.lang.Object;

public class NewSurveyController {

    private static Alert warn = new Alert(Alert.AlertType.WARNING);
    private static Label titleLabel = new Label();


    private static TextField questionField = new TextField();
    private static Button questionOkButton = new Button("OK");
    private static List<Label> questionList = new ArrayList<>();
    private static ChoiceBox<String> questionChoice = new ChoiceBox<>();
    private  static Button questionChoiceOkButton = new Button("OK");
    private  String qType1="Choose Type..";
    private  String qType2="Textual Answer";
    private  String qType3="Radio Button";
    private  String qType4="CheckBox";
     Button addRadioButton = new Button("Add Option..");
     Button radioDoneButton = new Button("Done");
     
     
             //model declarations
    private SurveysDaoInterface sm = new SurveyManager();
    private QuestionsDaoInterface qm = new QuestionsManager();
    private Survey survey1;
    private static Data userdata;


    @FXML
    private  AnchorPane newSurveyAnchorPane;

    @FXML
    private  TextField titleTextField;

    @FXML
    private  Button okButton;

    @FXML
    private  Button addQuestionButton;

    @FXML
    private  Button doneButton;

    //For Title
    @FXML
    private  void okButtonClicked(ActionEvent event) {
        if(titleTextField.getText().equals("")){
            warn.setContentText("Title can't be empty..");
            warn.showAndWait();
        }
        else{
            titleLabel.setText(titleTextField.getText());
            titleLabel.setFont(titleTextField.getFont());
            titleLabel.setLayoutX((newSurveyAnchorPane.getPrefWidth()/2)-(titleLabel.getText().length()*11)/2);
            titleLabel.setLayoutY(titleTextField.getLayoutY());
            newSurveyAnchorPane.getChildren().add(titleLabel);
            newSurveyAnchorPane.getChildren().removeAll(titleTextField,okButton);
            
        if( userdata != null) {
            
        survey1 = new Survey(null, titleTextField.getText(), userdata);    
        sm.setSurvey(survey1);
            System.out.println(userdata.getName());
            System.out.println("\n\nuserdata is not null\n\n");

        }
        }
    }

    //To Add Question in Survey
    @FXML
    private  void addQuestionButtonClicked(ActionEvent event) {
        questionChoice.getItems().removeAll(qType1,qType2,qType3,qType4);
        questionChoice.getItems().addAll(qType1,qType2,qType3,qType4);
        questionChoice.setValue("Choose Type..");
        questionChoice.setLayoutX(20);
        questionChoice.setLayoutY(addQuestionButton.getLayoutY());
        questionChoiceOkButton.setLayoutX(questionChoice.getLayoutX()+120);
        questionChoiceOkButton.setLayoutY(questionChoice.getLayoutY());
        questionChoiceOkButton.setOnAction(this::questionChoiceOkButtonClicked);

        addQuestionButton.setLayoutY(addQuestionButton.getLayoutY()+50);
        doneButton.setLayoutY(addQuestionButton.getLayoutY());
        newSurveyAnchorPane.getChildren().addAll(questionChoice,questionChoiceOkButton);

        /*
        questionField.setText("");
        questionField.setPromptText("Enter Question Here");
        questionField.setPrefWidth(200);
        questionField.setLayoutX(20);
        questionField.setLayoutY(addQuestionButton.getLayoutY());
        questionOkButton.setLayoutY(questionField.getLayoutY());
        questionOkButton.setLayoutX(questionField.getLayoutX()+questionField.getPrefWidth()+20);
        questionOkButton.setOnAction(this::questionOkButtonClicked);

        addQuestionButton.setLayoutY(addQuestionButton.getLayoutY()+50);
        doneButton.setLayoutY(addQuestionButton.getLayoutY());
        newSurveyAnchorPane.getChildren().addAll(questionField,questionOkButton);

         */
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
            else if(questionChoice.getValue().equals(qType3))
                questionOkButton.setOnAction(this::radioOkButtonClicked);
            else if(questionChoice.getValue().equals(qType4))
                questionOkButton.setOnAction(this::checkboxOkButtonClicked);
        }
    }

    /*
    AFTER ENTERING THE QUESTION
     */

    //if answer has checkboxes
    private void checkboxOkButtonClicked(ActionEvent actionEvent) {
        if(questionField.getText().equals("")){
            warn.setContentText("Question Can't be empty");
            warn.showAndWait();
        }
    }

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
            doneButton.setLayoutY(addQuestionButton.getLayoutY());

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
        doneButton.setLayoutY(addQuestionButton.getLayoutY());

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
        doneButton.setLayoutY(addQuestionButton.getLayoutY());
        newSurveyAnchorPane.getChildren().removeAll(addRadioButton,radioDoneButton);
    }

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
            doneButton.setLayoutY(addQuestionButton.getLayoutY());

            newSurveyAnchorPane.getChildren().removeAll(questionField, questionOkButton);
            newSurveyAnchorPane.getChildren().addAll(question,answerArea);
            questionList.add(question);
        }
    }

    //Submit Survey
    @FXML
    private void doneButtonClicked(ActionEvent event) throws IOException {
       if(userdata != null) {
           int i = 1;
           for(Label qs : questionList){
               Questions questionToBeAdded = new Questions(qs.getText(), i, survey1, userdata);
               qm.setQuestions(questionToBeAdded);
               System.out.println("data added");
               i++;
           }
            System.out.println("\n\nuserdata is not null\n\n");
           try {
               qm.close();
               sm.close();
           } catch (Exception ex) {
               Logger.getLogger(NewSurveyController.class.getName()).log(Level.SEVERE, null, ex);
           }
       } 
        MainApp.setRoot("/fxml/TemplateOrCreate.fxml");
    }

    @FXML
    private void backButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/TemplateOrCreate.fxml");
    }

    public static Alert getWarn() {
        return warn;
    }
    
    public static Label getTitleLabel() {
        return titleLabel;
    }
    

    public static Button getQuestionChoiceOkButton() {
        return questionChoiceOkButton;
    }
    

    
    public static ChoiceBox<String> getQuestionChoice() {
        return questionChoice;
    }

    public static TextField getQuestionField() {
        return questionField;
    }

    public static Button getQuestionOkButton() {
        return questionOkButton;
    }

    public static List<Label> getQuestionList() {
        return questionList;
    }

    public static void setUserdata(Data userdata) {
        NewSurveyController.userdata = userdata;
    }
            
        
        
}
