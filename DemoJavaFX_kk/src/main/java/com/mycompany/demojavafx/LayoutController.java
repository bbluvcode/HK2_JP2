/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.demojavafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LayoutController implements Initializable {

    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Button btnDemo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onChange(ActionEvent event) {
        if (lbl1.isVisible()) {
            lbl2.setVisible(true);
            lbl1.setVisible(false);
        }else{
            lbl2.setVisible(false);
            lbl1.setVisible(true);
        }
    }

    @FXML
    private void switchToPrimary(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

}
