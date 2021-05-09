/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survey5.controller;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

/**
 *
 * @author L340
 */
@ExtendWith(ApplicationExtension.class)
public class NewSurveyControllerTest2 {
        private static NewSurveyController newSurveyTester;
        @Start
        public void startLoginController(Stage stage) throws Exception {
        Scene scene = new Scene(loadFXMLLoginController("/fxml/NewSurvey.fxml"));
        stage.setTitle("Survey5");
        stage.setScene(scene);
        stage.show();
        stage.toFront();
        newSurveyTester = new NewSurveyController();
    }
        public Parent loadFXMLLoginController(String fxml) throws IOException{
        FXMLLoader loader = new FXMLLoader(NewSurveyController.class.getResource(fxml));
        return loader.load();
    } 

    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass(FxRobot robot) throws TimeoutException {
        FxToolkit.hideStage();
        robot.release(new KeyCode[0]);
        robot.release(new javafx.scene.input.MouseButton[0]);
    }
    
    @BeforeEach
    public void setUp(FxRobot robot) {
       
    }
    
    @AfterEach
        public void tearDown(FxRobot robot) throws TimeoutException {
        FxToolkit.hideStage();
        robot.release(new KeyCode[0]);
        robot.release(new javafx.scene.input.MouseButton[0]);
    }
        
        @Test
    public void OkButtonClickedTest_WhenEmpty(FxRobot robot) {
        
        TextField SurveyTitleField =  robot.lookup("#titleTextField").queryAs(TextField.class);
        robot.clickOn("#titleTextField");
        robot.write("");
        robot.clickOn("#okButton");
        assertEquals("Title can't be empty..", NewSurveyController.getWarn().getContentText());
        
    }
    
        @Test
    public void questionChoiceOkButtonClicked_WhenTypeOfQ_IsEmpty(FxRobot robot) {
        
        TextField SurveyTitleField =  robot.lookup("#titleTextField").queryAs(TextField.class);
        robot.clickOn("#titleTextField");
        robot.write("Test");
        robot.clickOn("#okButton");
        assertEquals("Test", NewSurveyController.getTitleLabel().getText());
        robot.clickOn("#addQuestionButton");
        robot.clickOn(NewSurveyController.getQuestionChoice());
        robot.clickOn(NewSurveyController.getQuestionChoiceOkButton());  
        assertEquals("You have to choose a type of question..", NewSurveyController.getWarn().getContentText());
        //Button addQuestionButtonTest = robot.lookup("#addQuestionButton").queryAs(Button.class);
        //assertNotNull(addQuestionButtonTest );
        
    }
    
        @Test
    public void questionChoiceOkButtonClicked_WhenCheckBox_WhenEmpty(FxRobot robot) {
        
        TextField SurveyTitleField =  robot.lookup("#titleTextField").queryAs(TextField.class);
        robot.clickOn("#titleTextField");
        robot.write("Test");
        robot.clickOn("#okButton");
        robot.clickOn("#addQuestionButton");
        robot.clickOn(NewSurveyController.getQuestionChoice());
        robot.type(KeyCode.DOWN);
        robot.type(KeyCode.DOWN);       
        robot.type(KeyCode.DOWN);
        robot.type(KeyCode.ENTER);
        robot.clickOn(NewSurveyController.getQuestionChoiceOkButton());
        robot.clickOn(NewSurveyController.getQuestionField());
        robot.write("");
        robot.clickOn(NewSurveyController.getQuestionOkButton());
       
        assertEquals("CheckBox", NewSurveyController.getQuestionChoice().getValue());
        assertEquals("Question Can't be empty", NewSurveyController.getWarn().getContentText()); 
    }
    
        @Test
    public void questionChoiceOkButtonClicked_WhenText_WhenEmpty(FxRobot robot) {
        
        TextField SurveyTitleField =  robot.lookup("#titleTextField").queryAs(TextField.class);
        robot.clickOn("#titleTextField");
        robot.write("Test");
        robot.clickOn("#okButton");
        robot.clickOn("#addQuestionButton");
        robot.clickOn(NewSurveyController.getQuestionChoice());
        robot.type(KeyCode.DOWN);
        robot.type(KeyCode.ENTER);
        robot.clickOn(NewSurveyController.getQuestionChoiceOkButton());
        robot.clickOn(NewSurveyController.getQuestionField());
        robot.write("");
        robot.clickOn(NewSurveyController.getQuestionOkButton());
        
        
        assertEquals("Textual Answer", NewSurveyController.getQuestionChoice().getValue());
        assertEquals("Question Can't be empty", NewSurveyController.getWarn().getContentText());  
    } 
}

