/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mohdkhedr.db_survey5;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author mohdk
 */
public class JpaSurveyDAO implements SurveyDAO {

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveSurvey(Survey ss) {
        entityManager.getTransaction().begin();
        entityManager.persist(ss);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteSurvey(Survey ss) {
        entityManager.getTransaction().begin();
        entityManager.remove(ss);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateSurvey(Survey ss) {
        saveSurvey(ss);
    }

    @Override
    public List<Survey> getSurvey() {
        TypedQuery<Survey> query = entityManager.createQuery("SELECT ss FROM Survey ss", Survey.class);
        List<Survey> surveys = query.getResultList();
        return surveys;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }

}
