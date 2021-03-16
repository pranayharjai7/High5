package Survey5;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;



public class PrimaryController {
    
    @FXML
    public void mousehovered(MouseEvent mouseEvent) throws IOException {
        App.setRoot("LoginScene");
    }
}
