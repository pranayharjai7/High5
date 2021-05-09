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
import Survey5.controller.LoginController;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Disabled;


@ExtendWith(ApplicationExtension.class)
class LoginControllerTest{
    private static LoginController LogInTester;
    @Start
        public void startLoginController(Stage stage) throws Exception {
        Scene scene = new Scene(loadFXMLLoginController("/fxml/LoginScene.fxml"));
        stage.setTitle("Survey5");
        stage.setScene(scene);
        stage.show();
        LogInTester = new LoginController();
    }
        public Parent loadFXMLLoginController(String fxml) throws IOException{
        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource(fxml));
        return loader.load();
    } 

    @Test
    public void testInputLoginController(FxRobot robot){
        clearOutInputFields(robot);
        TextField UserNameField =  robot.lookup("#usernameTextField").queryAs(TextField.class);
        PasswordField PasswordField =  robot.lookup("#passwordField").queryAs(PasswordField.class);
        robot.clickOn("#usernameTextField");
        robot.write("Unique username");
        robot.clickOn("#passwordField");
        robot.write("Password");
        robot.clickOn("#loginButton");
        assertEquals("Unique username", UserNameField.getText());
        assertEquals("Password", PasswordField.getText());
        assertEquals("Login was Successful!", LoginController.getConfirm().getContentText());

    }
    
    @Test
    @Disabled
    public void testInputLoginController_WhenWrong_Username(FxRobot robot){
        clearOutInputFields(robot);
        TextField UserNameField =  robot.lookup("#usernameTextField").queryAs(TextField.class);
        PasswordField PasswordField =  robot.lookup("#passwordField").queryAs(PasswordField.class);
        robot.clickOn("#usernameTextField");
        robot.write("wrong username");
        robot.clickOn("#passwordField");
        robot.write("Password");
        robot.clickOn("#loginButton");
        assertEquals("wrong username", UserNameField.getText());
        assertEquals("Password", PasswordField.getText());
        assertEquals("Either username or password was incorrect..\n Please try again..", LoginController.getWarn().getContentText());
        } 
    
        @Test
    public void testInputLoginController_WhenWrong_Password(FxRobot robot){
        clearOutInputFields(robot);
        TextField UserNameField =  robot.lookup("#usernameTextField").queryAs(TextField.class);
        PasswordField PasswordField =  robot.lookup("#passwordField").queryAs(PasswordField.class);
        robot.clickOn("#usernameTextField");
        robot.write("Unique username");
        robot.clickOn("#passwordField");
        robot.write("Wrong Password");
        robot.clickOn("#loginButton");
        assertEquals("Unique username", UserNameField.getText());
        assertEquals("Wrong Password", PasswordField.getText());
        assertEquals("Either username or password was incorrect..\n Please try again..", LoginController.getWarn().getContentText());

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
    public void tearDown(FxRobot robot) throws TimeoutException {
        FxToolkit.hideStage();
        robot.release(new KeyCode[0]);
        robot.release(new javafx.scene.input.MouseButton[0]);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    private void clearOutInputFields(FxRobot robot) {
        final int NUM_CHARS_TO_ERASE = 20; // ensure fields are empty
        robot.clickOn("#usernameTextField").eraseText(NUM_CHARS_TO_ERASE);
        robot.clickOn("#passwordField").eraseText(NUM_CHARS_TO_ERASE);
    }
   

}