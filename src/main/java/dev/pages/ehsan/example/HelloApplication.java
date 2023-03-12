package dev.pages.ehsan.example;

import dev.pages.ehsan.utils.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    public static SceneManager sm;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
//        Original Codes to Open a FXML File
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();

        // Scene Manager Codes for the same task
        sm = new SceneManager(stage);

        // Add The Scene
        sm.add("home", "/dev/pages/ehsan/example/hello-view.fxml");

        // Direct Open the Scene (DO NOT CONFIGURE PAGE AFTER OPEN)
//        sm.open("home", "/dev/pages/ehsan/example/hello-view.fxml");

        // Configure
        // Change Window Title
        sm.setTitle("Test Application");

        // Change App Icon
        sm.setIcon("/img/icon.png");

        // Hide Title
        sm.hideTitleBar();

        // Activate the scene (MUST ACTIVATE IF ONLY ADDED)
        sm.activate("home");
    }
}