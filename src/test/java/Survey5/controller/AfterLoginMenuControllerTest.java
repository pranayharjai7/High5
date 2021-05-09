/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survey5.controller;

import Survey5.MainApp;
import Survey5.model.Data;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

/**
 *
 * @author L340
 */
@ExtendWith(ApplicationExtension.class)

public class AfterLoginMenuControllerTest {
        @Start
        public void startLoginController(Stage stage) throws Exception {
        Scene scene1 = new Scene(loadFXMLLoginController("/fxml/AfterLoginMenu.fxml"));

        stage.setTitle("Survey5");
        stage.setScene(scene1);
        stage.show();
        stage.toFront();

    }
        public Parent loadFXMLLoginController(String fxml) throws IOException{
        FXMLLoader loader = new FXMLLoader(MyProfileController.class.getResource(fxml));
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
    public void setUp() {
    }
    
    @AfterEach
        public void tearDown() throws TimeoutException {

    }

    /**
     * Test of setUserdata method, of class AfterLoginMenuController.
     */
    @Test
    public void testMyProfileButtonIfExist(FxRobot robot) {
    Button myProfileButton = robot.lookup("#profileButton").queryAs(Button.class);
    assertNotNull(myProfileButton);
    }
    
    @Test
    public void testAnswerSurveyButtonIfExist(FxRobot robot) {
    Button answerSurveyButton = robot.lookup("#answerSurveyButton").queryAs(Button.class);
    assertNotNull(answerSurveyButton);
    }
    
    @Test
    public void testCreateSurveyButtonIfExist(FxRobot robot) {
    Button createSurveyButton = robot.lookup("#createSurveyButton").queryAs(Button.class);
    assertNotNull(createSurveyButton);
    }
    
    @Test
    public void testLogoutButtonIfExist(FxRobot robot) {
    Button logoutButton = robot.lookup("#logoutButton").queryAs(Button.class);
    assertNotNull(logoutButton);
    }
}
