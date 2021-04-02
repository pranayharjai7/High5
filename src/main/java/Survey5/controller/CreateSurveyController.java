package Survey5.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class CreateSurveyController{
    Button addQuestionButton = new Button("Add Question");
    Button doneButton = new Button("Done");
    Label surveyHeadingLabel = new Label();
    TextField newQuestion = new TextField();
    Button submitButton = new Button("OK");
    Alert warn = new Alert(Alert.AlertType.WARNING);

    ArrayList<Label> questionList = new ArrayList<>();

    @FXML
    private AnchorPane newSurveyAnchorPane;
    @FXML
    private Label logoLabel;

    @FXML
    private Label nameOfSurveyLabel;

    @FXML
    private TextField nameField;

    @FXML
    private Button OKButton;

    @FXML
    private void OKButtonClicked(ActionEvent actionEvent) {
        nameField.setVisible(false);
        OKButton.setVisible(false);
        logoLabel.setVisible(false);
        nameOfSurveyLabel.setVisible(false);

        surveyHeadingLabel.setText(nameField.getText());
        surveyHeadingLabel.setFont(logoLabel.getFont());
        surveyHeadingLabel.setLayoutX((newSurveyAnchorPane.getPrefWidth()/2)-(surveyHeadingLabel.getText().length()*15)/2);
        surveyHeadingLabel.setLayoutY(logoLabel.getLayoutY());
        addQuestionButton.setLayoutX((newSurveyAnchorPane.getPrefWidth()/4)-addQuestionButton.getWidth());
        addQuestionButton.setLayoutY(surveyHeadingLabel.getLayoutY()+50);
        addQuestionButton.setPrefWidth(100);
        addQuestionButton.setPrefHeight(20);
        addQuestionButton.setId("addQuestionButton");
        addQuestionButton.setOnAction(this::addQuestionButtonClicked);
        doneButton.setLayoutX(addQuestionButton.getLayoutX()+200);
        doneButton.setLayoutY(addQuestionButton.getLayoutY());
        doneButton.setPrefWidth(addQuestionButton.getPrefWidth());
        doneButton.setPrefHeight(addQuestionButton.getPrefHeight());
        doneButton.setOnAction(this::doneButtonClicked);

        newSurveyAnchorPane.getChildren().addAll(addQuestionButton,surveyHeadingLabel,doneButton);
        newSurveyAnchorPane.getChildren().removeAll(nameField,OKButton,logoLabel,nameOfSurveyLabel);
    }

    @FXML
    private void addQuestionButtonClicked(ActionEvent event){
        newQuestion.setText("");
        newQuestion.setPromptText("Enter Question..");
        newQuestion.setPrefWidth(200);
        newQuestion.setLayoutX(20);
        newQuestion.setLayoutY(addQuestionButton.getLayoutY());
        addQuestionButton.setLayoutY(addQuestionButton.getLayoutY()+50);
        doneButton.setLayoutY(addQuestionButton.getLayoutY());
        submitButton.setLayoutX(newQuestion.getLayoutX()+newQuestion.getPrefWidth()+20);
        submitButton.setLayoutY(newQuestion.getLayoutY());
        submitButton.setOnAction(this::submitButtonClicked);

        newSurveyAnchorPane.getChildren().addAll(newQuestion,submitButton);
    }

    @FXML
    private void submitButtonClicked(ActionEvent event){
        if(newQuestion.getText().equals("")){
            warn.setContentText("Question Can't be empty");
            warn.showAndWait();
        }
        else {
            Label question = new Label(newQuestion.getText());
            question.setLayoutX(newQuestion.getLayoutX());
            question.setLayoutY(newQuestion.getLayoutY());

            newSurveyAnchorPane.getChildren().removeAll(newQuestion, submitButton);
            newSurveyAnchorPane.getChildren().add(question);
            questionList.add(question);
        }
    }

    @FXML
    private void doneButtonClicked(ActionEvent event){

    }
}
