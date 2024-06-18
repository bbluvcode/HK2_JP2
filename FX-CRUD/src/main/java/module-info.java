module t12308a0.fx.crud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens t12308a0.fx.crud to javafx.fxml;
    exports t12308a0.fx.crud;
}
