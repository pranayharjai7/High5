package Survey5.controller;

import Survey5.MainApp;
import Survey5.controller.SurveyTemplateControllers.HealthTemplate1Controller;
import Survey5.model.Data;
import Survey5.model.Survey;
import Survey5.model.SurveyManager;
import Survey5.model.SurveysDaoInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnswerSurveyController {


    private SurveysDaoInterface sm = new SurveyManager();
    private List<Survey> sList;
    private List<Button> buttonList = new ArrayList<>();
    private static Data userdata;

    public static void setUserdata(Data userdata) {
        AnswerSurveyController.userdata = userdata;
    }

    @FXML
    private AnchorPane AnswerSurveyAnchorPane;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchBarField;

    @FXML
    private void initialize(){
        sList = sm.getAllSurveys();
        for (Survey survey: sList) {
            buttonList.add(new Button(survey.getTitle()));
            buttonList.get(buttonList.size()-1).setLayoutX(20);
            if(buttonList.size()<=1)
                buttonList.get(buttonList.size()-1).setLayoutY(searchBarField.getLayoutY()+50);
            else
                buttonList.get(buttonList.size() - 1).setLayoutY(buttonList.get(buttonList.size() - 2).getLayoutY() + 50);
            buttonList.get(buttonList.size()-1).setId(survey.getId()+"");
            buttonList.get(buttonList.size()-1).setOnAction(this::answerTheSurveyClicked);

            AnswerSurveyAnchorPane.getChildren().add(buttonList.get(buttonList.size()-1));
        }
    }

    private void answerTheSurveyClicked(ActionEvent actionEvent) {
        int surveyId = -1;
        for (Button button:buttonList) {
            if(actionEvent.getSource().equals(button)){
                surveyId = Integer.parseInt(button.getId());
            }
        }
        for (Survey survey:sList) {
            if (survey.getId() == surveyId) {
                System.out.println(survey.getId());
                try {
                    switchTemplate(survey);
                    MainApp.setRoot("/fxml/SurveyTemplates/"+survey.getTypeOfTemplate()+".fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void switchTemplate(Survey survey){
        switch (survey.getTypeOfTemplate()){
            case "HealthTemplate1": {
                HealthTemplate1Controller.setData(userdata);
                HealthTemplate1Controller.setCreateOrAnswerFunction("answer",survey);
                break;
            }
        }
    }

    @FXML
    private void searchButtonClicked(ActionEvent actionEvent) {

    }

    @FXML
    private void backButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/AfterLoginMenu.fxml");
    }
}