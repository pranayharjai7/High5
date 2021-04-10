/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author maria
 */
public class SportsTemplate1Controller {

        @FXML
    private Button submitButton;

    @FXML
    void submitButtonClicked(ActionEvent event) throws IOException {
        App.setRoot("SurveyTemplates");
    }
    
}
