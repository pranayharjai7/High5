package Survey5.model;

import javax.persistence.*;
import java.util.List;

public class DataManager implements DataDaoInterface{

    final EntityManagerFactory entityManagerFactory;
    final EntityManager entityManager;

    public DataManager() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("Survey5");
        this.entityManager =  entityManagerFactory.createEntityManager();
    }

    //Constructor for Test Case
    public DataManager(String dataBaseName) {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(dataBaseName);
        this.entityManager =  entityManagerFactory.createEntityManager();
    }

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
        entityManager.getTransaction().begin();
        entityManager.merge(data);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Data> getAllData() {
        TypedQuery<Data> query = entityManager.createQuery("SELECT data FROM Data data",Data.class);
        List<Data> dataList = query.getResultList();
        return dataList;
    }

    @Override
    public List<Data> getAllDataByEmail(String email) {
        TypedQuery<Data> query = entityManager.createQuery("SELECT data FROM Data data where data.email like : email ",Data.class).setParameter("email", email);
        List<Data> dataList = query.getResultList();
        return dataList;
    }

    @Override
    public List<Data> getAllDataByUserName(String username) {
        TypedQuery<Data> query = entityManager.createQuery("SELECT data FROM Data data where data.username like : username ",Data.class).setParameter("username", username);
        List<Data> dataList = query.getResultList();
        return dataList;
    }

    public boolean findDataById(int id){
        Data data_check = entityManager.find(Data.class, id);
        if (data_check == null){
            return false;
        }
        return true;
    }

    public void rollBack() throws Exception {
        entityManager.getTransaction().rollback();
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
