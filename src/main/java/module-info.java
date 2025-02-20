module com.example.session2fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.session2fx to javafx.fxml;
    exports com.example.session2fx;
}