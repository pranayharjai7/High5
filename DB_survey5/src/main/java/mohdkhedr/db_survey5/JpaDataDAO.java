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
public class JpaDataDAO implements DataDAO {

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveData(Data d) {
        entityManager.getTransaction().begin();
        entityManager.persist(d);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteData(Data d) {
        entityManager.getTransaction().begin();
        entityManager.remove(d);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateData(Data d) {
        saveData(d);
    }

    @Override
    public List<Data> getData() {
        TypedQuery<Data> query = entityManager.createQuery("SELECT d FROM Data d", Data.class);
 List<Data> dataes = query.getResultList();
 return dataes;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }

}
