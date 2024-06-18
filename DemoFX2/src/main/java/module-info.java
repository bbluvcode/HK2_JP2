module com.mycompany.demofx2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.demofx2 to javafx.fxml;
    exports com.mycompany.demofx2;
}
