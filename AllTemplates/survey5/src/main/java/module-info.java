module com.mycompany {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany to javafx.fxml;
    exports com.mycompany;
    requires org.controlsfx.controls;
}