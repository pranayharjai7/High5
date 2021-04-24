package Survey5.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionsManager implements QuestionsDaoInterface {

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Survey5");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void setQuestions(Questions questions) {
        entityManager.getTransaction().begin();
        entityManager.persist(questions);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteQuestions(Questions questions) {
        entityManager.getTransaction().begin();
        entityManager.remove(questions);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateQuestions(Questions questions) {
        setQuestions(questions);
    }

    @Override
    public List<Questions> getAllQuestions() {
        TypedQuery<Questions> query = entityManager.createQuery("SELECT questions FROM Questions questions", Questions.class);
        List<Questions> questionsList = query.getResultList();
        return questionsList;
    }

    @Override
    public List<Questions> getSurveyQuestions(Survey survey) {
        TypedQuery<Questions> query = entityManager.createQuery("SELECT questions FROM Questions questions", Questions.class);
        List<Questions> questionsList = query.getResultList().stream()
                .filter(questions -> questions.getSurveyTemplate().getId()==survey.getId())
                .collect(Collectors.toList());
        return questionsList;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
