module com.mycompany.demojavafx2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.demojavafx2 to javafx.fxml;
    exports com.mycompany.demojavafx2;
}
