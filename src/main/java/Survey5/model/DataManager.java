 package Survey5.model;

import java.util.List;
import javax.persistence.*;

public class DataManager implements DataDaoInterface{

    final EntityManagerFactory entityManagerFactory; 
    final EntityManager entityManager;
    public DataManager() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("Survey5");
        this.entityManager =  entityManagerFactory.createEntityManager();
    }

    public DataManager(String dataBaseName) {
    this.entityManagerFactory = Persistence.createEntityManagerFactory(dataBaseName);
    this.entityManager =  entityManagerFactory.createEntityManager();
    }
    //I made two constructors to be able to intialize an object 
    //for the test cases

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
        int id = data.getId();
        Data data_check = entityManager.find(Data.class, id);
        if (data_check != null){
        entityManager.getTransaction().begin();
        data_check.setEmail(data.getEmail());
        data_check.setName(data.getName());
        data_check.setUsername(data.getUsername());
        data_check.setPassword(data.getPassword());
        entityManager.getTransaction().commit();
        }
    }//the old way will create a new record instead of update the existing one

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

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
    public void rollBack() throws Exception {
        entityManager.getTransaction().rollback();
    }
}
