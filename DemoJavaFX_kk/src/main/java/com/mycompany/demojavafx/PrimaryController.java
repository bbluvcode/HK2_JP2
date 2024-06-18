package com.mycompany.demojavafx;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class PrimaryController {

    @FXML
    private Text txtDemo;
    @FXML
    private Button primaryButton;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void changeText(ActionEvent event) {
        txtDemo.setText("Demo Text");
        txtDemo.setFill(Color.ORANGE);
        
        
    }
}
