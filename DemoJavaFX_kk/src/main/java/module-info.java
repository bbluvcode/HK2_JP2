module com.mycompany.demojavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.demojavafx to javafx.fxml;
    exports com.mycompany.demojavafx;
}
