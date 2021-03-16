module Survey5 {
    requires javafx.controls;
    requires javafx.fxml;

    opens Survey5 to javafx.fxml;
    exports Survey5;
}