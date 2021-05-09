/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survey5.controller.SurveyTemplateControllers;

import Survey5.controller.LoginController;
import Survey5.model.Data;
import Survey5.model.Survey;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

/**
 *
 * @author L340
 */
@ExtendWith(ApplicationExtension.class)
public class HealthTemplate1ControllerTest {
    

    private static HealthTemplate1Controller health1Test;
    private static Data userDataTest;
    @Start
        public void startLoginController(Stage stage) throws Exception {
        Scene scene = new Scene(loadFXMLLoginController("/fxml/SurveyTemplates/HealthTemplate1.fxml"));
        stage.setTitle("Survey5");
        stage.setScene(scene);
        stage.show();
        health1Test = new HealthTemplate1Controller();
    }
        public Parent loadFXMLLoginController(String fxml) throws IOException{
        FXMLLoader loader = new FXMLLoader(HealthTemplate1Controller.class.getResource(fxml));
        return loader.load();
    } 

    
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    @Test
    public void saveButtonClicked(FxRobot robot){
        HealthTemplate1Controller.setCreateOrAnswerFunction("create");

    
    
    }
}
