package Survey5;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;



public class PrimaryController {

    @FXML
    private void startButtonClicked(ActionEvent actionEvent) throws IOException{
        App.setRoot("LoginScene");
    }
}
