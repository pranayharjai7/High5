/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survey5.controller;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
class LoginControllerTest{
    @Start
        public void startLoginController(Stage stage) throws Exception {
        Scene scene = new Scene(loadFXMLLoginController("/fxml/LoginScene.fxml"));
        stage.setTitle("Survey5");
        stage.setScene(scene);
        stage.show();
    }
        public Parent loadFXMLLoginController(String fxml) throws IOException{
        FXMLLoader loader = new FXMLLoader(LoginControllerTest.class.getResource(fxml));
        return loader.load();
    } 

    @Test
    public void testUserNameFieldLoginController(FxRobot robot) {
    Label UserNameLable = robot.lookup("#usernameLabel").queryAs(Label.class);
    assertNotNull(robot.lookup("#usernameTextField")); 
    assertEquals("User Name:", UserNameLable.getText());
    }
    

    @Test
    public void testPasswordFiedLoginController(FxRobot robot) {
    Label PasswordLable = robot.lookup("#passwordLabel").queryAs(Label.class);
    assertNotNull(robot.lookup("#passwordField")); 
    assertEquals("Password:", PasswordLable.getText());
    }
    
    @Test
    public void testLogInButtonIfExist(FxRobot robot) {
    assertNotNull(robot.lookup("#loginButton")); 
    }

    @Test
    public void testInputLoginController(FxRobot robot){
        TextField UserNameField =  robot.lookup("#usernameTextField").queryAs(TextField.class);
        PasswordField PasswordField =  robot.lookup("#passwordField").queryAs(PasswordField.class);
        robot.clickOn("#usernameTextField");
        robot.write("Unique username");
        robot.clickOn("#passwordField");
        robot.write("Password");
        robot.clickOn("#loginButton");
        assertEquals("Unique username", UserNameField.getText());
        assertEquals("Password", PasswordField.getText());

    }
    
    
    
    public LoginControllerTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //


   

}