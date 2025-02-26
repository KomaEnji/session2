module com.example.session2fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.compiler;
    requires org.postgresql.jdbc;


    opens com.example.session2fx to javafx.fxml;
    exports com.example.session2fx;
    exports com.example.session2fx.model;
    opens com.example.session2fx.model to javafx.fxml;
}