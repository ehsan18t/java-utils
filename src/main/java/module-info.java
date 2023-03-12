module java.utils {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    opens dev.pages.ehsan.utils to javafx.fxml;
    exports dev.pages.ehsan.utils;

    opens dev.pages.ehsan.example to javafx.fxml;
    exports dev.pages.ehsan.example;
}