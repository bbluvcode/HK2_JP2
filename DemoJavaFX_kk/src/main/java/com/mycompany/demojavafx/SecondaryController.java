package com.mycompany.demojavafx;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SecondaryController {

    @FXML
    private Button secondaryButton;

//    private void switchToPrimary() throws IOException {
//        App.setRoot("primary");
//    }

    @FXML
    private void switchToLayout(ActionEvent event) throws IOException {
        App.setRoot("layout");
    }
}