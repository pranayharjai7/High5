package Survey5;

import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.h2.tools.Server;

public class MainApp extends Application {

    private static Scene scene;
    private static Server s = new Server();

    public static void main(String[] args) throws SQLException {
        startDatabase();
        launch(args);
        stopDatabase();
    }

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("/fxml/primary.fxml"));
        stage.setTitle("Survey5");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void setRoot(String fxml) throws IOException{
        scene.setRoot(loadFXML(fxml));
    }
    
    private static Parent loadFXML(String fxml) throws IOException{
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource(fxml));
        return loader.load();
    }

    private static void startDatabase() throws SQLException {
        s.runTool("-tcp", "-web", "-ifNotExists");
    }

    private static void stopDatabase()  {
        s.shutdown();
    }
    
}
