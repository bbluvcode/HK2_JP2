/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.demojavafx2;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SecondaryController implements Initializable {

    @FXML
    private TextField tfUser;
    @FXML
    private PasswordField pfPass;
    @FXML
    private PasswordField tfConfirm;
    @FXML
    private ToggleGroup gender;
    @FXML
    private CheckBox ckHob1;
    @FXML
    private CheckBox ckHob2;
    @FXML
    private ComboBox<String> cbCity;
    @FXML
    private DatePicker birth;
    @FXML
    private TextArea tfNote;
    @FXML
    private RadioButton rdMale;
    @FXML
    private RadioButton rdFemale;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // khoi tao gia tri cho City
        ObservableList<String> listCity = FXCollections.observableArrayList("Sai Gon", "Ben Tre", "Hue", "Vung Tau");
        cbCity.setItems(listCity);
        cbCity.setPromptText("Select City");
    }

    @FXML
    private void onRegister(ActionEvent event) {
        String username = tfUser.getText();
        String pass = pfPass.getText();
        String passCon = tfConfirm.getText();
        //gender - radio
        RadioButton rdGender = (RadioButton) gender.getSelectedToggle();    //Cach 1   khong can dat ID    
        String genderValue = rdGender.getText();    
        
        //String gen = rdMale.isSelected() ? rdMale.getText() : rdFemale.getText();   //Cach 2 phai dat ID o 2 radio
        //hobby - checkbox
        ArrayList<String> hob = new ArrayList();
        if(ckHob1.isSelected()){
            hob.add(ckHob1.getText());
        }
        if(ckHob2.isSelected()){
            hob.add(ckHob2.getText());
        }
        //City
        String city = cbCity.getSelectionModel().getSelectedItem();
        
        //birthday - datePicker
        LocalDate birthDay = birth.getValue();
        
        String note = tfNote.getText();
        
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setContentText("UserName: "+username+"\nPassword: "+pass+"\nConfirmPass: "+passCon+
                "\nGender: " +genderValue+"\nHobby: "+hob+"\nCity: "+city+"\nBirthday: "+birthDay+"\nNote: "+note);
        alert.show();

    }

    @FXML
    private void onReset(ActionEvent event) throws IOException {
        App.setRoot("secondary");        
    }

}
