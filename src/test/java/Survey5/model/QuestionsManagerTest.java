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
public class QuestionsManagerTest {

    private static QuestionsManager questionsManagerTester;
    private static Data dataTest = new Data("name", "email", "usernameTest", "passwordTest");
    private static Data dataTest2 = new Data("name2", "email2", "usernameTest2", "passwordTest2");

    private static DataManager dmTest = new DataManager("Survey5Test");

    private static Survey surveyTest = new Survey("Health", "Health1", dataTest);
    private static Survey surveyTest2 = new Survey("Health2", "Health2", dataTest2);

    private static SurveyManager smTest = new SurveyManager("Survey5Test");


    public QuestionsManagerTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        questionsManagerTester = new QuestionsManager("Survey5Test");
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
        dmTest.entityManager.remove(dataTest);
        smTest.entityManager.remove(surveyTest);
        dmTest.entityManager.remove(dataTest2);
        smTest.entityManager.remove(surveyTest2);
        questionsManagerTester.close();
    }

    @BeforeEach
    public void setUp() {
        dmTest.setData(dataTest);
        smTest.setSurvey(surveyTest);
        dmTest.setData(dataTest2);
        smTest.setSurvey(surveyTest2);
    }

    @AfterEach
    public void tearDown() {
        questionsManagerTester.entityManager.getTransaction().begin();
        int query = questionsManagerTester.entityManager.createQuery("DELETE FROM Questions").executeUpdate();
        questionsManagerTester.entityManager.getTransaction().commit();
    }

    /**
     * Test of setQuestions method, of class QuestionsManager.
     */
    @Test
    public void testSetQuestions() {

        Questions qtest = new Questions("Question Test", 1,surveyTest, dataTest);
        questionsManagerTester.setQuestions(qtest);
        assertNotNull(qtest.getId());

    }

    /**
     * Test of deleteQuestions method, of class QuestionsManager.
     */
    @Test
    public void testDeleteQuestions() {
        Questions qtest = new Questions("Question Test", 1, surveyTest, dataTest);
        questionsManagerTester.setQuestions(qtest);
        assertNotNull(qtest.getId());
        int id = qtest.getId();
        questionsManagerTester.deleteQuestions(qtest);
        Questions q_after_delete = questionsManagerTester.entityManager.find(Questions.class, id);
        assertNull(q_after_delete);

    }

    /**
     * Test of updateQuestions method, of class QuestionsManager.
     */
    @Test
    public void testUpdateQuestions() {
        Questions qtest = new Questions("Question Test", 1, surveyTest, dataTest);
        questionsManagerTester.setQuestions(qtest);
        qtest.setQuestionNumber(1);
        qtest.setQuestion("new question");
        questionsManagerTester.updateQuestions(qtest);
        Questions qAfterUpdate = questionsManagerTester.entityManager.find((Questions.class), qtest.getId());
        assertEquals(1, qAfterUpdate.getQuestionNumber());
        assertEquals("new question", qAfterUpdate.getQuestion());
        assertSame(qtest, qAfterUpdate);
    }

    @Test
    public void testUpdateQuestions_IfNotExist() {
        //if
        Questions qtest = new Questions("Question Test", 1, surveyTest, dataTest);//qtest object not added to the table
        qtest.setQuestionNumber(1);
        qtest.setQuestion("new question");;
        questionsManagerTester.updateQuestions(qtest);
        Questions qAfterUpdate = questionsManagerTester.entityManager.find((Questions.class), qtest.getId());
        //then
        assertNull(qAfterUpdate);

    }

    /**
     * Test of getAllQuestions method, of class QuestionsManager.
     */
    @Test
    public void testGetAllQuestions() {
        Questions qtest = new Questions("Question Test1",1, surveyTest, dataTest);
        questionsManagerTester.setQuestions(qtest);
        Questions qtest2 = new Questions("Question Test2",1, surveyTest, dataTest);
        questionsManagerTester.setQuestions(qtest2);
        Questions qtest3 = new Questions("Question Test3",1, surveyTest, dataTest);
        questionsManagerTester.setQuestions(qtest3);
        List<Questions> result = questionsManagerTester.getAllQuestions();
        assertFalse(result.isEmpty());
        assertEquals(3, result.size());
    }

    @Test
    public void testGetAllQuestions_IfEmpty() {
        List<Questions> result = questionsManagerTester.getAllQuestions();
        assertTrue(result.isEmpty());
    }

    /**
     * Test of getSurveyQuestions method, of class QuestionsManager.
     */
    @Test
    public void testGetSurveyQuestions() {
        Questions qtest = new Questions("Question Test1", 1, surveyTest, dataTest);
        questionsManagerTester.setQuestions(qtest);
        Questions qtest2 = new Questions("Question Test2", 1, surveyTest, dataTest);
        questionsManagerTester.setQuestions(qtest2);
        Questions qtest3 = new Questions("Question Test3", 1,surveyTest2, dataTest2);
        questionsManagerTester.setQuestions(qtest3);
        List<Questions> result = questionsManagerTester.getSurveyQuestions(surveyTest);
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
    }

    /**
     * Test of getUserQuestions method, of class QuestionsManager.
     */
    @Test
    public void testGetUserQuestions() {
        Questions qtest = new Questions("Question Test1", 1, surveyTest, dataTest);
        questionsManagerTester.setQuestions(qtest);
        Questions qtest2 = new Questions("Question Test2", 1, surveyTest, dataTest);
        questionsManagerTester.setQuestions(qtest2);
        Questions qtest3 = new Questions("Question Test3", 1,surveyTest2, dataTest2);
        questionsManagerTester.setQuestions(qtest3);
        List<Questions> result1 = questionsManagerTester.getUserQuestions(dataTest);
        assertFalse(result1.isEmpty());
        assertEquals(2, result1.size());
        List<Questions> result2 = questionsManagerTester.getUserQuestions(dataTest2);
        assertFalse(result2.isEmpty());
        assertEquals(1, result2.size());
    }


}
