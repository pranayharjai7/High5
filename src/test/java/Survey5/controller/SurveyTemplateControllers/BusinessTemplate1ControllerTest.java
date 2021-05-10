/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survey5.controller.SurveyTemplateControllers;

import Survey5.controller.NewSurveyController;
import Survey5.model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 *
 * @author L340
 */

@ExtendWith(ApplicationExtension.class)
@ExtendWith(MockitoExtension.class)
public class BusinessTemplate1ControllerTest {

    private BusinessTemplate1Controller b1ctrl;
    private static SurveyManager sm;
    private static QuestionsManager qm;
    private static DataManager dm;
    
    @BeforeEach
    public void setUp() {
    sm = new SurveyManager("Survey5");
    qm = new QuestionsManager("Survey5");
    dm = new DataManager("Survey5");
  
    }
 
    
   /* @AfterAll
    public static void tearDownClass() throws Exception {
        sm.entityManager.getTransaction().begin();
        int query = sm.entityManager.createQuery("DELETE FROM Survey").executeUpdate();
        sm.entityManager.getTransaction().commit();
        
        qm.entityManager.getTransaction().begin();
        int query2 = qm.entityManager.createQuery("DELETE FROM Questions").executeUpdate();
        qm.entityManager.getTransaction().commit();
        
        dm.entityManager.getTransaction().begin();
        int query3 = dm.entityManager.createQuery("DELETE FROM Data").executeUpdate();
        qm.entityManager.getTransaction().commit();
    }*/
    
        @Start
        public void startLoginController(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(NewSurveyController.class.getResource("/fxml/SurveyTemplates/BusinessTemplate1.fxml"));

        Scene scene = new Scene(loader.load(), 800, 800);
        b1ctrl = loader.<BusinessTemplate1Controller>getController();
        //b1ctrl = loader.<BusinessTemplate1Controller>getController();*/
        stage.setTitle("Survey5");
        stage.setScene(scene);
        stage.show();
        stage.toFront();

    }
    

    

    /**
     * Test of setData method, of class BusinessTemplate1Controller.
     */
        
    @Test
    public void SaveButtonest(FxRobot robot) {
        //String smock = mock(String.class);
        Platform.runLater(new Runnable(){
        @Override
        public void run(){  
            try {
                ActionEvent aeMock = mock(ActionEvent.class);
                Data dtest_sb = new Data("name", "email", "username", "password");
                dm.setData(dtest_sb); dm.close();

                BusinessTemplate1Controller.setCreateOrAnswerFunction("create");
                BusinessTemplate1Controller.setData(dtest_sb);
                b1ctrl.initialize();
                b1ctrl.saveButtonClicked(aeMock);
                assertEquals("Template Saved Successfully!!", b1ctrl.getConfirm().getContentText());
                
                assertNotNull(b1ctrl.getAnswer());
                assertEquals("Save", b1ctrl.getSaveButton().getText());
                
            } catch (Exception ex) {
                Logger.getLogger(BusinessTemplate1ControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }
        });

    }
        @Test
    public void testAnswerButt_whenAnsweredBefore(FxRobot robot) {
        //String smock = mock(String.class);
        Platform.runLater(new Runnable(){
        @Override
        public void run(){   

            try {
                ActionEvent aeMock = mock(ActionEvent.class);
                Data dtest = new Data("name", "email", "username", "password");
                Survey surTest = new Survey("typeOfTemplate", "title", dtest);
                Questions qTest = new Questions("q1", 1, surTest, dtest);
                sm.setSurvey(surTest); sm.close();
                dm.setData(dtest); dm.close();
                qm.setQuestions(qTest); qm.close();
                
                BusinessTemplate1Controller.setCreateOrAnswerFunction("answer", surTest);
                BusinessTemplate1Controller.setData(dtest);
                b1ctrl.initialize();
                b1ctrl.submitButtonClicked(aeMock);
                
                assertNotNull(BusinessTemplate1Controller.getAnswer());
                assertEquals("Submit", b1ctrl.getSaveButton().getText());
                assertEquals(1, b1ctrl.getFlag());
                assertEquals("You have already answered this Survey!", b1ctrl.getConfirm().getContentText());
            } catch (Exception ex) {
                Logger.getLogger(BusinessTemplate1ControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });

    }
    
            @Test
    public void testAnswerButt_whenNot_AnsweredBefore(FxRobot robot) {
        //String smock = mock(String.class);
        Platform.runLater(new Runnable(){
        @Override
        public void run(){   

            try {
                ActionEvent aeMock = mock(ActionEvent.class);
                Data dtest_ab2 = new Data("name", "email", "username", "password");
                Data dtest_ab = new Data("name", "email", "username", "password");
                Survey surTest_ab= new Survey("typeOfTemplate", "title", dtest_ab);
                Questions qTest_ab = new Questions("q1", 1, surTest_ab, dtest_ab);
                sm.setSurvey(surTest_ab); sm.close();
                dm.setData(dtest_ab); dm.close();
                dm.setData(dtest_ab); dm.close();
                qm.setQuestions(qTest_ab); qm.close();
                
                BusinessTemplate1Controller.setCreateOrAnswerFunction("answer", surTest_ab);
                BusinessTemplate1Controller.setData(dtest_ab2);
                b1ctrl.initialize();
                b1ctrl.submitButtonClicked(aeMock);
                
                assertNotNull(BusinessTemplate1Controller.getAnswer());
                assertEquals("Submit", b1ctrl.getSaveButton().getText());
                assertEquals(0, b1ctrl.getFlag());
                assertEquals("You didn't submit all the answers!", b1ctrl.getConfirm().getContentText());
            } catch (Exception ex) {
                Logger.getLogger(BusinessTemplate1ControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });

    }
   
    
                @Test
    public void testAnswerButt_when_SurveyEmpty(FxRobot robot) {
        //String smock = mock(String.class);
        Platform.runLater(new Runnable(){
        @Override
        public void run(){   

            try {
                ActionEvent aeMock = mock(ActionEvent.class);
                Data dtest_se2 = new Data("name", "email", "username", "password");
                Data dtest_se = new Data("name", "email", "username", "password");
                Survey surTest_se= new Survey("typeOfTemplate", "title", dtest_se);
                sm.setSurvey(surTest_se); sm.close();
                dm.setData(dtest_se2); dm.close();
                dm.setData(dtest_se); dm.close();
                
                BusinessTemplate1Controller.setCreateOrAnswerFunction("answer", surTest_se);
                BusinessTemplate1Controller.setData(dtest_se2);
                b1ctrl.initialize();
                
                assertEquals("Submit", b1ctrl.getSaveButton().getText());
                b1ctrl.submitButtonClicked(aeMock);
                
                assertNotNull(BusinessTemplate1Controller.getAnswer());
               
                assertEquals(0, b1ctrl.getFlag());
                assertEquals("Answer Submitted Successfully!", b1ctrl.getConfirm().getContentText());
            } catch (Exception ex) {
                Logger.getLogger(BusinessTemplate1ControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });

    }
    
    
        @Test
    public void ShowAnsButtonTest(FxRobot robot) {
        //String smock = mock(String.class);
        Platform.runLater(new Runnable(){
        @Override
        public void run(){  
            try {
                ActionEvent aeMock = mock(ActionEvent.class);
                Data dtest_sha = new Data("name", "email", "username", "password");
                dm.setData(dtest_sha); dm.close();
                Survey surTest_sha = new Survey("typeOfTemplate", "title", dtest_sha);
                sm.setSurvey(surTest_sha); sm.close();

                BusinessTemplate1Controller.setCreateOrAnswerFunction("ShowAnswer",surTest_sha);
                BusinessTemplate1Controller.setData(dtest_sha);
                b1ctrl.initialize();
                b1ctrl.showAnswersClicked(aeMock);                
                assertNotNull(b1ctrl.getAnswer());
                assertEquals("Show Answers", b1ctrl.getSaveButton().getText());
                
            } catch (Exception ex) {
                Logger.getLogger(BusinessTemplate1ControllerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }
        });

    }
}
