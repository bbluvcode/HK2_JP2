/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.demojavafx2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class PrimaryController implements Initializable {

    @FXML
    private TextField tfUser;
    @FXML
    private PasswordField pfPass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onLogin(ActionEvent event) {
        //get value of UserName
        String username = tfUser.getText();

        //get value of Pass
        String pass = pfPass.getText();
        //thong bao ra man hinh
        Alert alert = new Alert(AlertType.NONE);
        if (username.isEmpty()) {
            alert.setAlertType(AlertType.ERROR);
            alert.setContentText("UserName cannot is empty !");
            alert.show();
            tfUser.requestFocus();
        } else {
            if (pass.isEmpty()) {
                alert.setAlertType(AlertType.ERROR);
                alert.setContentText("Password cannot is empty !");
                alert.show();
            }else{
                alert.setAlertType(AlertType.INFORMATION);
                alert.setContentText("UserName: " +username+"\nPassword: " +pass);
                alert.show();
            }
        }

    }

}
