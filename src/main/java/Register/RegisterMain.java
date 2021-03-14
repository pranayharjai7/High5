package Register;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterMain extends Application {
    public static void main(String[] args){
        launch(args);
    }

    private Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new FXMLLoader().load(getClass().getResource("/fxml/RegisterScene.fxml"));
        scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Register");
        stage.show();
    }
}
