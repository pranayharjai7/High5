/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Survey5.model;

import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author L340
 */
public class DataManagerTest {
    
    private static DataManager DataManagerTester;
    
    public DataManagerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        DataManagerTester = new DataManager("Survey5Test");
    }
    
    @AfterAll
    public static void tearDownClass() throws Exception {
        DataManagerTester.close();
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setData method, of class DataManager.
     */
    @Test
    public void testSetData() {
        Data dataTest = new Data("nameTest", "email@test.com", "userNameTest", "passwordTest");
        DataManagerTester.setData(dataTest);
        assertNotNull(dataTest.getId());
    }

    /**
     * Test of deleteData method, of class DataManager.
     */
    @Test
    public void testDeleteData() {
        Data dataTest = new Data("nameTest", "email@test.com", "userNameTest", "passwordTest");
        DataManagerTester.setData(dataTest);
        int id = dataTest.getId();
        DataManagerTester.deleteData(dataTest);
        Data data_after_delete = DataManagerTester.entityManager.find(Data.class, id);
        assertNull(data_after_delete);
        
    }

    /**
     * Test of updateData method, of class DataManager.
     */
    @Test
    public void testUpdateData() {
        Data dataTest = new Data("nameTest", "email@test.com", "userNameTest", "passwordTest");
        DataManagerTester.setData(dataTest);
        dataTest.setEmail("email@test.com_updated");
        dataTest.setUsername("userNameTest_updated");
        dataTest.setPassword("passwordTest_updated");
        dataTest.setName("nameTest_updated");
        DataManagerTester.updateData(dataTest);
        Data data_after_update = DataManagerTester.entityManager.find(Data.class, dataTest.getId());
        Assertions.assertEquals("email@test.com_updated", data_after_update.getEmail());
        Assertions.assertEquals("userNameTest_updated", data_after_update.getUsername());
        Assertions.assertEquals("passwordTest_updated", data_after_update.getPassword());
        Assertions.assertEquals("nameTest_updated", data_after_update.getName());
    }
    /**
     * Test of getAllData method, of class DataManager.
     */
    @Test
    public void testGetAllData_ByEmail_WhenExist() {
        Data dataTest = new Data("nameTest", "email@test.com", "userNameTest", "passwordTest");
        DataManagerTester.setData(dataTest);
        List<Data> result = DataManagerTester.getAllDataByEmail("email@test.com");
        Assertions.assertFalse(result.isEmpty());
    }
    
    @Test
    public void testGetAllData_ByEmail_WhenDoNotExist() {
        List<Data> result = DataManagerTester.getAllDataByEmail("email@test.comNotExist");
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testGetAllData_ByUserName_WhenDoNotExist() {
        List<Data> result = DataManagerTester.getAllDataByUserName("UserNameNotExist");
        Assertions.assertTrue(result.isEmpty());
    }
    
    @Test
    public void testGetAllData_ByUserName_WhenExist() {
        Data dataTest = new Data("nameTest", "email@test.com", "userNameTest", "passwordTest");
        DataManagerTester.setData(dataTest);
        List<Data> result = DataManagerTester.getAllDataByUserName("userNameTest");
        Assertions.assertFalse(result.isEmpty());
    }
    /**
     * Test of findData method, of class DataManager.
     */
    @Test
    public void testFindDataByIdWhenRecordExists() {
        Data dataTest = new Data("nameTest", "email@test.com", "userNameTest", "passwordTest");
        DataManagerTester.setData(dataTest);
        boolean check = DataManagerTester.findDataById(dataTest.getId());
        Assertions.assertTrue(check);
    }
    
    @Test
    public void testFindDataByIdWhenRecordDoesNotExists(){
    boolean check = DataManagerTester.findDataById(10000);
    Assertions.assertFalse(check);
    }

    /**
     * Test of close method, of class DataManager.
     */
    
}
