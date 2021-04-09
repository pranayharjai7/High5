/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survey5.test;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;


@ExtendWith(ApplicationExtension.class)
class RegisterControllerTest{
    @Start
        public void start(Stage stage) throws Exception {
        Scene scene = new Scene(loadFXML("/fxml/RegisterScene.fxml"));
        stage.setTitle("Survey5");
        stage.setScene(scene);
        stage.show();

    }

    @Test
    public void testRegisterButton(FxRobot robot) {
    Button registerButtonTest = robot.lookup("#registerButton").queryAs(Button.class);
    assertNotNull(registerButtonTest);
    /*robot.clickOn("#nameField");
    robot.write("testName");
    robot.clickOn("#emailField");
    robot.write("email");
    robot.clickOn("#usernameField");
    robot.write("Unique username");
    robot.clickOn("#passwordField");
    robot.write("passwordField");
    robot.clickOn("#registerButton");
    //assertEquals("testName", controltester.getNameField());*/
    }
    
    @Test
    public void testNameField(FxRobot robot) {
    assertNotNull(robot.lookup("#nameField"));
    }

    @Test
    public void testEmailField(FxRobot robot) {
    assertNotNull(robot.lookup("#emailField"));
    }
    
    @Test
    public void testUserNameField(FxRobot robot) {
    assertNotNull(robot.lookup("#usernameField"));
    }   

    @Test
    public void testPasswordField(FxRobot robot) {
    assertNotNull(robot.lookup("#passwordField"));
    }  
    
    
    @Test
    public void testInput(FxRobot robot){
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
    public static void tearDownClass() {
    
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //


    private static Parent loadFXML(String fxml) throws IOException{
        FXMLLoader loader = new FXMLLoader(RegisterControllerTest.class.getResource(fxml));
        return loader.load();
    }    

}