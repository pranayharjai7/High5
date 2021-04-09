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
public class JpaQnASurveyDAO implements QnASurveyDAO{
    
    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveQnASurvey(QnASurvey qna) {
        entityManager.getTransaction().begin();
        entityManager.persist(qna);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteQnASurvey(QnASurvey qna) {
        entityManager.getTransaction().begin();
        entityManager.remove(qna);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateQnASurvey(QnASurvey qna) {
        saveQnASurvey(qna);
    }

    @Override
    public List<QnASurvey> getQnASurvey() {
       TypedQuery<QnASurvey> query = entityManager.createQuery("SELECT qna FROM QnASurvey qna", QnASurvey.class);
        List<QnASurvey> qnaSurveys = query.getResultList();
        return qnaSurveys;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
    
}
