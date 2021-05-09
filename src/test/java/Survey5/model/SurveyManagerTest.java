/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survey5.model;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author L340
 */
public class SurveyManagerTest {
    
    private static SurveyManager surveyManagerTester;
    private static Data dataTest = new Data("name", "email", "usernameTest", "passwordTest");
    private static DataManager dmTest = new DataManager("Survey5Test");
        
    
    public SurveyManagerTest() {        
    }
    
    @BeforeAll
    public static void setUpClass() {
        surveyManagerTester = new SurveyManager("Survey5Test");
        
    }
    
    @AfterAll
    public static void tearDownClass() throws Exception {
        dmTest.entityManager.remove(dataTest);
        surveyManagerTester.close();
    }
    
    @BeforeEach
    public void setUp() {
        dmTest.setData(dataTest);
    }
    
    @AfterEach
    public void tearDown() throws Exception {

        surveyManagerTester.entityManager.getTransaction().begin();
        int query = surveyManagerTester.entityManager.createQuery("DELETE FROM Survey").executeUpdate();
        surveyManagerTester.entityManager.getTransaction().commit();
    }

    /**
     * Test of setSurvey method, of class SurveyManager.
     */
    @Test
    public void testSetSurvey() {
        Survey surveyTest = new Survey("Health", "Health1", dataTest);
        surveyManagerTester.setSurvey(surveyTest);
        assertNotNull(surveyTest.getId());        
    }

    /**
     * Test of deleteSurvey method, of class SurveyManager.
     */
    @Test
    public void testDeleteSurvey() {
        Survey surveyTest = new Survey("Health", "Health1", dataTest);
        surveyManagerTester.setSurvey(surveyTest);
        assertNotNull(surveyTest.getId()); 
        int id = surveyTest.getId();
        surveyManagerTester.deleteSurvey(surveyTest);
        Survey survey_after_delete = surveyManagerTester.entityManager.find(Survey.class, id);
        assertNull(survey_after_delete);               
    }

    /**
     * Test of updateSurvey method, of class SurveyManager.
     */
    @Test
    public void testUpdateSurvey() {
        Survey surveyTest = new Survey("Health", "Health1", dataTest);
        surveyManagerTester.setSurvey(surveyTest);
        surveyTest.setTitle("new title");
        surveyTest.setTypeOfTemplate("new template");
        surveyManagerTester.updateSurvey(surveyTest);
        Survey survetAfterUpdate = surveyManagerTester.entityManager.find(Survey.class, surveyTest.getId());
        assertEquals("new title", survetAfterUpdate.getTitle());
        assertEquals("new template", survetAfterUpdate.getTypeOfTemplate());
        assertEquals(surveyTest, survetAfterUpdate);

    }
    
    @Test
    public void testUpdateSurvey_IfNotExist() {
        //if
        Survey surveyTest = new Survey("Health", "Health1", dataTest);//Surveytest object not added to the table
        surveyTest.setTitle("new title");
        surveyTest.setTypeOfTemplate("new template");
        surveyManagerTester.updateSurvey(surveyTest);
        Survey survetAfterUpdate = surveyManagerTester.entityManager.find(Survey.class, surveyTest.getId());
        //then
        assertNull(survetAfterUpdate);
        

    }

    /**
     * Test of getAllSurveys method, of class SurveyManager.
     */
    @Test
    public void testGetAllSurveys() {
        Survey surveyTest = new Survey("Health", "Health1", dataTest);
        surveyManagerTester.setSurvey(surveyTest);
        Survey surveyTest2 = new Survey("Health", "Health2", dataTest);
        surveyManagerTester.setSurvey(surveyTest2);
        Survey surveyTest3 = new Survey("Health", "Health3", dataTest);
        surveyManagerTester.setSurvey(surveyTest3);
        List<Survey> result = surveyManagerTester.getAllSurveys();
        assertFalse(result.isEmpty());
        assertEquals(3, result.size());
    }
    
    @Test
    public void testGetAllSurveys_IfEmpty() {
        List<Survey> result = surveyManagerTester.getAllSurveys();
        assertTrue(result.isEmpty());
    }
    
    

    /**
     * Test of getUserSurveys method, of class SurveyManager.
     */
    @Test
    public void testGetUserSurveys() {
        Survey surveyTest = new Survey("Health", "Health1", dataTest);
        surveyManagerTester.setSurvey(surveyTest);
        Survey surveyTest2 = new Survey("Health", "Health2", dataTest);
        surveyManagerTester.setSurvey(surveyTest2);
        Survey surveyTest3 = new Survey("Health", "Health3", dataTest);
        surveyManagerTester.setSurvey(surveyTest3);
        List<Survey> result = surveyManagerTester.getUserSurveys(dataTest);
        assertFalse(result.isEmpty());
        assertEquals(3, result.size());
    }

    /**
     * Test of getSurveyByName method, of class SurveyManager.
     */
    @Test
    public void testGetSurveyByName() {
        Survey surveyTest = new Survey("food", "Health1", dataTest);
        surveyManagerTester.setSurvey(surveyTest);
        Survey surveyTest2 = new Survey("Health", "Health2", dataTest);
        surveyManagerTester.setSurvey(surveyTest2);
        Survey surveyTest3 = new Survey("Health", "Health3", dataTest);
        surveyManagerTester.setSurvey(surveyTest3);
        Survey result = surveyManagerTester.getSurveyByName("Health1");
        assertSame(surveyTest, result);
    }

    /**
     * Test of getSurveyID_ByName method, of class SurveyManager.
     */
    @Test
    public void testGetSurveyID_ByName() {
        Survey surveyTest = new Survey("food", "Health1", dataTest);
        surveyManagerTester.setSurvey(surveyTest);
        Survey surveyTest2 = new Survey("Health", "Health2", dataTest);
        surveyManagerTester.setSurvey(surveyTest2);
        Survey surveyTest3 = new Survey("Health", "Health3", dataTest);
        surveyManagerTester.setSurvey(surveyTest3);
        int result = surveyManagerTester.getSurveyID_ByName("Health1");
        assertEquals(surveyTest.getId(), result);
    }

    
}
