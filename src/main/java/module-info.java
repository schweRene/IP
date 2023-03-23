module com.example.ip {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.ip to javafx.fxml;
    exports com.example.ip;
}