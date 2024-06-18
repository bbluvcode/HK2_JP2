module com.mycompany.qlsanbong {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.qlsanbong to javafx.fxml;
    exports com.mycompany.qlsanbong;
}
