/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mohdkhedr.db_survey5;

import java.util.List;

/**
 *
 * @author mohdk
 */
public interface DataDAO extends AutoCloseable{
    public void saveData(Data d);
    public void deleteData(Data d);
    public void updateData(Data d);
    public List<Data> getData();
}
