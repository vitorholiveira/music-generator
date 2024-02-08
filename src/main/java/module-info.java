module com.example.projeto_tcp {
    requires javafx.controls;
    requires javafx.fxml;
    requires jfugue;
    requires java.desktop;


    opens com.example.projeto_tcp to javafx.fxml;
    exports com.example.projeto_tcp;
}