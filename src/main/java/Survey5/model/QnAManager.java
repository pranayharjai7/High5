package Survey5.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class QnAManager implements QnADaoInterface{

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Survey5");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void setQnA(QnA qna) {
        entityManager.getTransaction().begin();
        entityManager.persist(qna);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteQnA(QnA qna) {
        entityManager.getTransaction().begin();
        entityManager.remove(qna);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateQnA(QnA qna) {
        setQnA(qna);
    }

    @Override
    public List<QnA> getAllQnA() {
        TypedQuery<QnA> query = entityManager.createQuery("SELECT qna FROM QnA qna", QnA.class);
        List<QnA> QnAList = query.getResultList();
        return QnAList;
    }

    @Override
    public List<QnA> getSurveyQnA(Survey survey) {
        TypedQuery<QnA> query = entityManager.createQuery("SELECT qna FROM QnA qna", QnA.class);
        List<QnA> QnAList = query.getResultList().stream()
                .filter(qnA -> qnA.getSurveyTemplate().getId()==survey.getId())
                .collect(Collectors.toList());
        return QnAList;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
