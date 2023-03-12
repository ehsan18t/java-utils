module java.utils {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    opens dev.pages.ehsan.utils to javafx.fxml;
    exports dev.pages.ehsan.utils;

    opens example to javafx.fxml;
    exports example;
}