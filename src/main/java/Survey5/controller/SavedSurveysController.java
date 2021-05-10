package Survey5.controller;

import Survey5.MainApp;
import Survey5.controller.SurveyTemplateControllers.*;
import Survey5.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SavedSurveysController{
    private static Data userdata;
    private SurveysDaoInterface sm = new SurveyManager();
    private List<Survey> sList;
    private List<Button> buttonList = new ArrayList<>();


    public static void setUserdata(Data userdata) {
        SavedSurveysController.userdata = userdata;
    }

    @FXML
    private AnchorPane MySurveysAnchorPane;

    @FXML
    private TextField searchBarField;

    @FXML
    private Button searchButton;

    @FXML
    private void initialize(){
        sList = sm.getUserSurveys(userdata);
        for (Survey survey:sList) {
            buttonList.add(new Button(survey.getTitle()));
            buttonList.get(buttonList.size()-1).setLayoutX(20);
            if(buttonList.size()<=1)
                buttonList.get(buttonList.size() - 1).setLayoutY(searchBarField.getLayoutY()+50);
            else
                buttonList.get(buttonList.size() - 1).setLayoutY(buttonList.get(buttonList.size() - 2).getLayoutY() + 50);
            buttonList.get(buttonList.size()-1).setId(survey.getId()+"");
            buttonList.get(buttonList.size() - 1).setOnAction(this::savedSurveyClicked);

            MySurveysAnchorPane.getChildren().add(buttonList.get(buttonList.size()-1));
        }
    }

    @FXML
    private void searchButtonClicked(ActionEvent actionEvent) {
    }

    private void savedSurveyClicked(ActionEvent actionEvent){
        int SurveyId = -1;
        for (Button button:buttonList) {
            if(actionEvent.getSource().equals(button)){
                SurveyId = Integer.parseInt(button.getId());
            }
        }
        for (Survey survey:sList) {
            if(survey.getId()==SurveyId){
                switchTemplate(survey);
                try {
                    if(survey.getTypeOfTemplate().equals("CreateOwnSurvey")){
                        MainApp.setRoot("/fxml/NewSurvey.fxml");
                    }
                    else{
                        MainApp.setRoot("/fxml/SurveyTemplates/"+survey.getTypeOfTemplate()+".fxml");
                    }
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
                HealthTemplate1Controller.setCreateOrAnswerFunction("ShowAnswer",survey);
                break;
            }
            case "HealthTemplate2": {
                HealthTemplate2Controller.setData(userdata);
                HealthTemplate2Controller.setCreateOrAnswerFunction("ShowAnswer",survey);
                break;
            }
            case "HealthTemplate3": {
                HealthTemplate3Controller.setData(userdata);
                HealthTemplate3Controller.setCreateOrAnswerFunction("ShowAnswer",survey);
                break;
            }
            case "HealthTemplate4": {
                HealthTemplate4Controller.setData(userdata);
                HealthTemplate4Controller.setCreateOrAnswerFunction("ShowAnswer",survey);
                break;
            }
            case "BusinessTemplate1": {
                BusinessTemplate1Controller.setData(userdata);
                BusinessTemplate1Controller.setCreateOrAnswerFunction("ShowAnswer",survey);
                break;
            }
            case "BusinessTemplate2": {
                BusinessTemplate2Controller.setData(userdata);
                BusinessTemplate2Controller.setCreateOrAnswerFunction("ShowAnswer",survey);
                break;
            }
            case "BusinessTemplate3": {
                BusinessTemplate3Controller.setData(userdata);
                BusinessTemplate3Controller.setCreateOrAnswerFunction("ShowAnswer",survey);
                break;
            }
            case "BusinessTemplate4": {
                BusinessTemplate4Controller.setData(userdata);
                BusinessTemplate4Controller.setCreateOrAnswerFunction("ShowAnswer",survey);
                break;
            }
            case "FoodTemplate1": {
                FoodTemplate1Controller.setData(userdata);
                FoodTemplate1Controller.setCreateOrAnswerFunction("ShowAnswer",survey);
                break;
            }
            case "FoodTemplate2": {
                FoodTemplate2Controller.setData(userdata);
                FoodTemplate2Controller.setCreateOrAnswerFunction("ShowAnswer",survey);
                break;
            }
            case "FoodTemplate3": {
                FoodTemplate3Controller.setData(userdata);
                FoodTemplate3Controller.setCreateOrAnswerFunction("ShowAnswer",survey);
                break;
            }
            case "FoodTemplate4": {
                FoodTemplate4Controller.setData(userdata);
                FoodTemplate4Controller.setCreateOrAnswerFunction("ShowAnswer",survey);
                break;
            }
            case "SportsTemplate2": {
                SportsTemplate2Controller.setData(userdata);
                SportsTemplate2Controller.setCreateOrAnswerFunction("ShowAnswer",survey);
                break;
            }
            case "SportsTemplate3": {
                SportsTemplate3Controller.setData(userdata);
                SportsTemplate3Controller.setCreateOrAnswerFunction("ShowAnswer",survey);
                break;
            }
            case "CreateOwnSurvey": {
                NewSurveyController.setData(userdata);
                NewSurveyController.setCreateOrAnswerFunction("ShowAnswer",survey);
                break;
            }
        }
    }

    @FXML
    private void backButtonClicked(ActionEvent actionEvent) throws IOException {
        MainApp.setRoot("/fxml/AfterLoginMenu.fxml");
    }
}
