/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.qlsanbong;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class DetailcusController {

    @FXML
    private Label idLabel;

    @FXML
    private Label sdtLabel;

    @FXML
    private Label nameLable;

    @FXML
    private Label pointLable;

    public void setCus(Customer cus) {
        idLabel.setText(String.valueOf(cus.getId()));
        pointLable.setText(String.valueOf(cus.getPoint()));
        sdtLabel.setText(cus.getPhone());
        nameLable.setText(cus.getName());
    }

    public void goBack(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("customerlist.fxml"));
        Parent sampleParent = loader.load();
        Scene scene = new Scene(sampleParent);
        stage.setScene(scene);
    }
    
//==========chỉ kích hoạt được 1 lần, lần 2 bấm ko chạy
//    public void goBack() throws IOException{
//        App.setRoot("customerlist");
//    }

}
