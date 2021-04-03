package Survey5.model;

import javax.persistence.*;
import java.util.List;

public class DataManager implements DataDaoInterface{

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Survey5");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void setData(Data data) {
        entityManager.getTransaction().begin();
        entityManager.persist(data);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteData(Data data) {
        entityManager.getTransaction().begin();
        entityManager.remove(data);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateData(Data data) {
        setData(data);
    }

    @Override
    public List<Data> getAllData() {
        TypedQuery<Data> query = entityManager.createQuery("SELECT data FROM Data data",Data.class);
        List<Data> dataList = query.getResultList();
        return dataList;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
