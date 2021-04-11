package Survey5.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class SurveyManager implements SurveysDaoInterface{
    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Survey5");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void setSurvey(Survey survey) {
        entityManager.getTransaction().begin();
        entityManager.persist(survey);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteSurvey(Survey survey) {
        entityManager.getTransaction().begin();
        entityManager.remove(survey);
        entityManager.getTransaction().commit();

    }

    @Override
    public void updateSurvey(Survey survey) {
        setSurvey(survey);
    }

    @Override
    public List<Survey> getAllSurveys() {
        TypedQuery<Survey> query = entityManager.createQuery("SELECT survey FROM Survey survey", Survey.class);
        List<Survey> surveyList = query.getResultList();
        return surveyList;
    }

    @Override
    public List<Survey> getUserSurveys(Data data) {
        TypedQuery<Survey> query = entityManager.createQuery("SELECT survey FROM Survey survey", Survey.class);
        List<Survey> surveyList = query.getResultList().stream()
                                                                .filter(survey -> survey.getOwner().getId()==data.getId())
                                                                .collect(Collectors.toList());

        return surveyList;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
