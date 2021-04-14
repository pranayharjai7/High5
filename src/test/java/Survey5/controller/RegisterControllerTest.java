package Survey5.controller;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;


@ExtendWith(ApplicationExtension.class)
class RegisterControllerTest{
    @Start
        public void startRegisterController(Stage stage) throws Exception {
        Scene scene = new Scene(loadFXMLRegisterController("/fxml/RegisterScene.fxml"));
        stage.setTitle("Survey5");
        stage.setScene(scene);
        stage.show();
    }
        
        public Parent loadFXMLRegisterController(String fxml) throws IOException{
            FXMLLoader loader = new FXMLLoader(RegisterControllerTest.class.getResource(fxml));
            return loader.load();
    }

    @Test
    public void testRegisterButton(FxRobot robot) {
    Button registerButtonTest = robot.lookup("#registerButton").queryAs(Button.class);
    assertNotNull(registerButtonTest);
    }
    
    @Test
    public void testNameFieldRegisterController(FxRobot robot) {
    assertNotNull(robot.lookup("#nameField"));
    }

    @Test
    public void testEmailFieldRegisterController(FxRobot robot) {
    assertNotNull(robot.lookup("#emailField"));
    }
    
    @Test
    public void testUserNameFieldRegisterController(FxRobot robot) {
    assertNotNull(robot.lookup("#usernameField"));
    }   

    @Test
    public void testPasswordFieldRegisterController(FxRobot robot) {
    assertNotNull(robot.lookup("#passwordField"));
    }  
    
    //Some Errors for First Testers
    @Test
    public void testInputRegisterController(FxRobot robot){
        TextField testNameInput =  robot.lookup("#nameField").queryAs(TextField.class);
        TextField testUserNameInput =  robot.lookup("#usernameField").queryAs(TextField.class);
        TextField testEmailInput =  robot.lookup("#emailField").queryAs(TextField.class);
        TextField testPasswordInput =  robot.lookup("#passwordField").queryAs(TextField.class);
        robot.clickOn("#nameField");
        robot.write("testName");
        robot.clickOn("#usernameField");
        robot.write("Unique username");
        robot.clickOn("#emailField");
        robot.write("email");
        robot.clickOn("#passwordField");
        robot.write("Password");
        robot.clickOn("#registerButton");
        assertEquals("testName", testNameInput.getText());
        assertEquals("Unique username", testUserNameInput.getText());
        assertEquals("email", testEmailInput.getText());
        assertEquals("Password", testPasswordInput.getText());


    }
    
    
    
    public RegisterControllerTest() {
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


}