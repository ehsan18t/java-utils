package dev.pages.ehsan.example;

import dev.pages.ehsan.utils.SceneManager;
import dev.pages.ehsan.utils.Size;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        ////////////////////////////////////////
        // Original Codes to Open a FXML File //
        ////////////////////////////////////////

//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();

        ///////////////////////////////////////////
        // Scene Manager Codes for the same task //
        ///////////////////////////////////////////

        // Creating Scene Manager Objects
        SceneManager sm = new SceneManager(stage);
//        sm.open("home", "/dev/pages/ehsan/example/hello-view.fxml");
        // Path must be "Path From Source Root"

        // DO NOT CONFIGURE PAGE AFTER OPEN
        // FOLLOW THE BELOW EXAMPLES IF YOU WANT TO CONFIGURE


        ////////////////////////////////
        // Add Custom Configurations //
        ///////////////////////////////
        // Add Default size for all pages
        sm.setDefaultSize (new Size(400, 600));
        // OR
        sm.setDefaultSize (400, 600);

        // Add The Scene
        sm.add("home", "/dev/pages/ehsan/example/hello-view.fxml");

        // Add/Open Scene with Custom Size
//        sm.add("home", "/dev/pages/ehsan/example/hello-view.fxml", 400, 600);
        // OR
//        sm.add("home", "/dev/pages/ehsan/example/hello-view.fxml", new Size(400, 600));

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