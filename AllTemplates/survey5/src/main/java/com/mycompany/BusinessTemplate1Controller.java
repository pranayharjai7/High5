/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.controlsfx.control.Rating;


/**
 * FXML Controller class
 *
 * @author maria
 */
public class BusinessTemplate1Controller
{
    
    @FXML
    private AnchorPane FeedbackSurveyCanvas;
 
    @FXML
    private Label PhoneLabel;

    @FXML
    private Label EmailLabel;

    @FXML
    private Label NameLabel;

    @FXML
    private TextField NameTextFeild;

    @FXML
    private TextField PhoneTextFeild;

    @FXML
    private TextField EmailTextFeild;

    @FXML
    private Text ProductQuality;

    @FXML
    private Text DeliverySpeed;

    @FXML
    private Text CustomerService;

    @FXML
    private Text Communication;

    @FXML
    private Rating ProductRating;

    @FXML
    private Rating DeliveryRating;

    @FXML
    private Rating CommunicationRating;

    @FXML
    private Rating CustomerServiceRating;

    @FXML
    private Text Review;

    @FXML
    private TextArea ReviewBox;

    @FXML
    private Button SubmitButton;
    
    
    @FXML
    void CommunicationRatingClicked(MouseEvent event) {

    }

    @FXML
    void CustomerServiceRatingClicked(MouseEvent event) {

    }

    @FXML
    void DeliveryRatingClicked(MouseEvent event) {

    }

    @FXML
    void EmailTextFeildClicked(ActionEvent event) {

    }

    @FXML
    void NameTextFeildClicked(ActionEvent event) {

    }

    @FXML
    void PhoneTextFeildClicked(ActionEvent event) {

    }

    @FXML
    void ProductRatingClicked(MouseEvent event) {

    }

    @FXML
    void SubmitButtonClicked(ActionEvent event) throws IOException {
        App.setRoot("SurveyTemplates");
    }     
    
}
