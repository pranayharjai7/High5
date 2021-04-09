package mohdkhedr.db_survey5;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.h2.tools.Server;

public class Application {

    public static void main(String[] args) throws Exception {
        startDatabase();

        /*Customer customer = new Customer();
        customer.setFirstName("Dennys");
        customer.setLastName("Fredericci");*/
        
        Data d = new Data();
        d.setEmail("mohdkhedr123@gmail.com");
        d.setName("Mohamed");
        d.setUsername("momothebeast");
        d.setPassword("123456");
        
        Survey s = new Survey();
        s.setDataOwner(d);
        s.setTitle("the survey of life");
        s.setTypeOfTemplate("my own");
        
        QnASurvey qq = new QnASurvey();
        qq.setAnswers("abc");
        qq.setQuestions("what is my name?");
        qq.setSurveyTemplate(s);
        
        try(DataDAO dDAO = new JpaDataDAO();){
            dDAO.saveData(d);
            System.out.println("Please press a key to change your name too pranay");
            (new Scanner(System.in)).nextLine();
            d.setName("pranay");
            dDAO.saveData(d);
           List<Data> dList = dDAO.getData();
            for (Data data : dList) {
                data.setUsername("mo");
               dDAO.saveData(d);
            }
              System.out.println(dList);
        }
        
        try(SurveyDAO sDAO = new JpaSurveyDAO();){
            sDAO.saveSurvey(s);
        }
        
       try(QnASurveyDAO qqDAO = new JpaQnASurveyDAO();){
           qqDAO.saveQnASurvey(qq);
       }
        
        /*System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:mem:my_database");
        System.out.println("User Name: sa");
        System.out.println("Password: ");*/

    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
