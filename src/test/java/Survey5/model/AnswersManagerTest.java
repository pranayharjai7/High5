package Survey5.model;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

public class AnswersManagerTest {
    private static AnswersManager answersManagerTester;
    private static Data dataTest = new Data("name", "email", "usernameTest", "passwordTest");
    private static DataManager dmTest = new DataManager("Survey5Test");

    private static Survey surveyTest = new Survey("Health", "Health1", dataTest);
    private static SurveyManager smTest = new SurveyManager("Survey5Test");

    private static Questions qtest = new Questions("Qtest1", 1, surveyTest, dataTest);
    private static final Questions qtest2 = new Questions("Qtest2", 1, surveyTest, dataTest);
    private static QuestionsManager qmTest = new QuestionsManager("Survey5Test");
    public AnswersManagerTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        answersManagerTester = new AnswersManager("Survey5Test");
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
        dmTest.entityManager.remove(dataTest);
        smTest.entityManager.remove(surveyTest);
        qmTest.entityManager.remove(qtest);
        qmTest.entityManager.remove(qtest2);
        answersManagerTester.close();
    }

    @BeforeEach
    public void setUp() {
        dmTest.setData(dataTest);
        smTest.setSurvey(surveyTest);
        qmTest.setQuestions(qtest);
        qmTest.setQuestions(qtest2);


    }

    @AfterEach
    public void tearDown() {
        answersManagerTester.entityManager.getTransaction().begin();
        int query = answersManagerTester.entityManager.createQuery("DELETE FROM Answers").executeUpdate();
        answersManagerTester.entityManager.getTransaction().commit();
    }

    /**
     * Test of setAnswers method, of class AnswersManager.
     */
    @Test
    public void testSetAnswers() {
        Answers ansTest = new Answers("typeTest", "Answer", qtest);
        answersManagerTester.setAnswers(ansTest);
        assertNotNull(ansTest.getId());
    }

    /**
     * Test of deleteAnswers method, of class AnswersManager.
     */
    @Test
    public void testDeleteAnswers() {
        Answers ansTest = new Answers("typeTest", "Answer", qtest);
        answersManagerTester.setAnswers(ansTest);
        assertNotNull(ansTest.getId());
        int id = ansTest.getId();
        answersManagerTester.deleteAnswers(ansTest);
        Answers ans_after_delete = answersManagerTester.entityManager.find(Answers.class, id);
        assertNull(ans_after_delete);
    }

    /**
     * Test of updateAnswers method, of class AnswersManager.
     */
    @Test
    public void testUpdateAnswers() {
        Answers ansTest = new Answers("typeTest", "Answer", qtest);
        answersManagerTester.setAnswers(ansTest);
        ansTest.setAnswerText("new ans");
        ansTest.setAnswersType("new type");
        answersManagerTester.updateAnswers(ansTest);
        Answers ansUpdated = answersManagerTester.entityManager.find(Answers.class, ansTest.getId());
        assertEquals("new ans", ansUpdated.getAnswerText());
        assertEquals("new type", ansUpdated.getAnswersType());
        assertSame(ansUpdated, ansTest);
    }


    @Test
    public void testUpdateAnswers_IfNotExist() {
        Answers ansTest = new Answers("typeTest", "Answer", qtest);
        ansTest.setAnswerText("new ans");
        ansTest.setAnswersType("new type");
        answersManagerTester.updateAnswers(ansTest);
        Answers ansUpdated = answersManagerTester.entityManager.find(Answers.class, ansTest.getId());
        assertNull(ansUpdated);

    }
    /**
     * Test of getAllAnswers method, of class AnswersManager.
     */
    @Test
    public void testGetAllAnswers() {
        Answers ansTest = new Answers("typeTest", "Answer", qtest);
        answersManagerTester.setAnswers(ansTest);
        Answers ansTest2 = new Answers("typeTest2", "Answer2", qtest);
        answersManagerTester.setAnswers(ansTest2);
        Answers ansTest3 = new Answers("typeTest3", "Answer3", qtest);
        answersManagerTester.setAnswers(ansTest3);
        List<Answers> result = answersManagerTester.getAllAnswers();
        assertFalse(result.isEmpty());
        assertEquals(3, result.size());
    }

    /**
     * Test of getQuestionAnswers method, of class AnswersManager.
     */
    @Test
    public void testGetQuestionAnswers() {
        Answers ansTest = new Answers("typeTest", "Answer", qtest);
        answersManagerTester.setAnswers(ansTest);
        Answers ansTest2 = new Answers("typeTest2", "Answer2", qtest);
        answersManagerTester.setAnswers(ansTest2);
        Answers ansTest3 = new Answers("typeTest3", "Answer3", qtest2);
        answersManagerTester.setAnswers(ansTest3);
        List<Answers> result = answersManagerTester.getQuestionAnswers(qtest);
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());

        List<Answers> result2 = answersManagerTester.getQuestionAnswers(qtest2);
        assertFalse(result2.isEmpty());
        assertEquals(1, result2.size());
    }



}
