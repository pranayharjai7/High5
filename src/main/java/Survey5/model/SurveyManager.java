package Survey5.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class SurveyManager implements SurveysDaoInterface{
    final EntityManagerFactory entityManagerFactory;
    final EntityManager entityManager;

    public SurveyManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Survey5");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public SurveyManager(String dataBaseName) {
        entityManagerFactory = Persistence.createEntityManagerFactory(dataBaseName);
        entityManager = entityManagerFactory.createEntityManager();
    }

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

    public Survey getSurveyByName(String surveyName) {
        TypedQuery<Survey> query = entityManager.createQuery("SELECT survey FROM Survey survey where survey.title like : surveyName ",Survey.class).setParameter("surveyName", surveyName);
        List<Survey> surveyList = query.getResultList();
        return surveyList.get(0);
    }

    public int getSurveyID_ByName(String surveyName) {
        TypedQuery<Survey> query = entityManager.createQuery("SELECT survey FROM Survey survey where survey.title like : surveyName ",Survey.class).setParameter("surveyName", surveyName);
        List<Survey> surveyList = query.getResultList();
        return surveyList.get(0).getId();
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }

    public void deleteAllRecords() {
        entityManager.getTransaction().begin();
        int query = entityManager.createQuery("DELETE FROM Survey").executeUpdate();
        entityManager.getTransaction().commit();
    }//added delete records function /Salma
}
