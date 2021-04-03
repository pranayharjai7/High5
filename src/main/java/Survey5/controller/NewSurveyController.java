package Survey5.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class NewSurveyController {

    private Alert warn = new Alert(Alert.AlertType.WARNING);
    private Label titleLabel = new Label();
    private TextField questionField = new TextField();
    private Button questionOkButton = new Button("OK");
    private List<Label> questionList = new ArrayList<>();
    private ChoiceBox<String> questionChoice = new ChoiceBox<>();
    private Button questionChoiceOkButton = new Button("OK");
    private String qType1="Choose Type..";
    private String qType2="Textual Answer";
    private String qType3="Radio Button";
    private String qType4="CheckBox";
    Button addRadioButton = new Button("Add Option..");
    Button radioDoneButton = new Button("Done");



    @FXML
    private AnchorPane newSurveyAnchorPane;

    @FXML
    private TextField titleTextField;

    @FXML
    private Button okButton;

    @FXML
    private Button addQuestionButton;

    @FXML
    private Button doneButton;

    //For Title
    @FXML
    void okButtonClicked(ActionEvent event) {
        if(titleTextField.getText().equals("")){
            warn.setContentText("Title can't be empty..");
        }
        else{
            titleLabel.setText(titleTextField.getText());
            titleLabel.setFont(titleTextField.getFont());
            titleLabel.setLayoutX((newSurveyAnchorPane.getPrefWidth()/2)-(titleLabel.getText().length()*11)/2);
            titleLabel.setLayoutY(titleTextField.getLayoutY());
            newSurveyAnchorPane.getChildren().add(titleLabel);
            newSurveyAnchorPane.getChildren().removeAll(titleTextField,okButton);
        }
    }

    //To Add Question in Survey
    @FXML
    void addQuestionButtonClicked(ActionEvent event) {
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
    private void questionChoiceOkButtonClicked(ActionEvent actionEvent) {
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
    private List<RadioButton> rButtons = new ArrayList<>();
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
    void doneButtonClicked(ActionEvent event) {

    }

}