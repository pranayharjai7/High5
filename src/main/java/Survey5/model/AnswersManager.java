package Survey5.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class AnswersManager implements AnswersDaoInterface{
    
    public EntityManagerFactory entityManagerFactory;
    public EntityManager entityManager;

    public AnswersManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Survey5");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public AnswersManager(String dataBaseName) {
        entityManagerFactory = Persistence.createEntityManagerFactory(dataBaseName);
        entityManager = entityManagerFactory.createEntityManager();
    }
    @Override
    public void setAnswers(Answers ans) {
        entityManager.getTransaction().begin();
        entityManager.persist(ans);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteAnswers(Answers ans) {
        entityManager.getTransaction().begin();
        entityManager.remove(ans);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateAnswers(Answers ans) {
        entityManager.getTransaction().begin();//replaced by merge to check because it check if the record exists or not
        entityManager.merge(ans);       //salma
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Answers> getAllAnswers() {
        TypedQuery<Answers> query = entityManager.createQuery("SELECT answers FROM Answers answers", Answers.class);
        List<Answers> answersList = query.getResultList();
        return answersList;    
    }

    @Override
    public List<Answers> getQuestionAnswers(Questions questions) {
        TypedQuery<Answers> query = entityManager.createQuery("SELECT answers FROM Answers answers", Answers.class);
        List<Answers> answersList = query.getResultList().stream()
                .filter(answers -> answers.getQuestion().getId() == questions.getId())
                .collect(Collectors.toList());
        return answersList;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
    
    
}
