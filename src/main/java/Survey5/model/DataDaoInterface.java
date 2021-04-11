package Survey5.model;

import java.util.List;

public interface DataDaoInterface extends AutoCloseable{
    public void setData(Data data);
    public void deleteData(Data data);
    public void updateData(Data data);
    public List<Data> getAllDataByEmail(String email);
    public List<Data> getAllDataByUserName(String userName);
}
