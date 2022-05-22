module com.example.tema1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires fontawesomefx;
    requires jfoenix;
    requires nashorn.jdk8u265.b01.x3;
    requires java.desktop;


    opens com.example.tema1 to javafx.fxml;
    exports com.example.tema1;
}