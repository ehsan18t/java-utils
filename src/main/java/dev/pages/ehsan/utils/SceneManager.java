package dev.pages.ehsan.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Objects;

/**
 * This class is intended for controlling the scenes of JavaFX.
 * There are many features to control scenes like add/remove
 * CSS enable/disable draggable the window and many more. Feel
 * free to add more if you like. <br/>
 * <br/>
 * You will probably use <b>open()</b>, <b>activate()</b>,
 * <b>remove()</b>, <b>add()</b> these 4 methods the most.
 * So, make sure to read the documentation of these methods
 * to understand how they work. GOOD LUCK :)
 * <br/>
 * <br/>
 *
 * @Author: Ahsan Khan
 * @Version: v 1.1
 * @Github: <a href="https://github.com/Ahsan40">https://github.com/Ahsan40</a>
 * @Contact: <a href="mailto:help.ahsan@gmail.com">help.ahsan@gmail.com</a>
 */
public class SceneManager {
    private static double xOffset;
    private static double yOffset;
    private final HashMap<String, Size> sizeMap;
    private final HashMap<String, String> fxmlMap;
    private final HashMap<String, String> cssMap;
    private final HashMap<String, Scene> sceneMap;
    private Stage primaryStage;
    private String primaryCSS;
    private Size defaultSize;
    // setting var
    private boolean applyDefaultCSS;
    private boolean defaultSceneDraggable;
    private boolean resizable;


    /////////////////////
    //                 //
    //   Constructor   //
    //                 //
    /////////////////////
    public SceneManager(Stage stage) {
        this.fxmlMap = new HashMap<>();
        this.cssMap = new HashMap<>();
        this.sizeMap = new HashMap<>();
        this.sceneMap = new HashMap<>();
        this.primaryStage = stage;
        this.defaultSceneDraggable = true;
        this.applyDefaultCSS = false;
        this.resizable = false;
        this.defaultSize = new Size(400, 600);
    }

    public SceneManager(Stage stage, String css) {
        this(stage);
        this.applyDefaultCSS = true;
        this.primaryCSS = css;
    }


    //////////////////////////
    //                      //
    //   Public Functions   //
    //                      //
    //////////////////////////

    /**
     * This function adds scene to map. It doesn't open/show the page
     * immediately. To show the page we need to call activate() method.
     * Or, there are open() function will, which will add and active
     * the page at the same time;
     */
    public void add(String name, String fxml, Size size) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
            Scene scene = new Scene(root, size.getW(), size.getH());

            // Store Component
            sizeMap.put(name, size);
            fxmlMap.put(name, fxml);
            sceneMap.put(name, scene);

            // Setup (CSS and Draggable)
            addConfig(name, scene);
        } catch (IOException e) {
            System.out.println(" - EXCEPTION OCCURRED WHILE ADDING SCENE " + fxml + "!!!");
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }

    public void add(String name, String fxml, double h, double w) {
        add(name, fxml, new Size(h, w));
    }

    public void add(String name, String fxml) {
        add(name, fxml, this.defaultSize);
    }

    /**
     * Activate or show a particular page if exist (added before).
     */
    public void activate(String name) {
        Scene scene = sceneMap.get(name);
        if (scene != null) {
            primaryStage.setScene(scene);
            primaryStage.show();
        } else
            System.out.println(" - ERROR: SCENE DOESN'T EXIST WITH THE NAME " + name);
    }

    /**
     * Add and activate a scene at the same time with size object.
     * Scene gets replaced if already exist. Which means page will
     * get refreshed/reload if already exist.
     */
    public void open(String name, String fxml, Size size) {
        add(name, fxml, size);
        activate(name);
    }

    /**
     * Add and activate a scene at the same time with height and weight.
     * Scene gets replaced if already exist. Which means page will get
     * refreshed/reload if already exist.
     */
    public void open(String name, String fxml, double h, double w) {
        open(name, fxml, new Size(h, w));
    }

    /**
     * Add and activate a scene at the same time with <strong>default scene size (400hx600w)</strong>.
     * Scene gets replaced if already exist. Which means page will get
     * refreshed/reload if already exist.
     */
    public void open(String name, String fxml) {
        open(name, fxml, this.defaultSize);
    }

    /**
     * As the name suggest, it just refreshes/reloads the page.
     * If the data of an inactive page has been changed it won't
     * show the changed or new data by using activate() method.
     * Because that method just activate the existing scene, doesn't
     * refresh the content in it.
     */
    public void reload(String name) {
        String fxml = fxmlMap.get(name);
        Size size = sizeMap.get(name);

        remove(name);
        add(name, fxml, size);
    }

    /**
     * Removes any scene from db. (except the current page)
     */
    public void remove(String name) {
        if (primaryStage.getScene() != sceneMap.get(name)) {
            sceneMap.remove(name);
            fxmlMap.remove(name);
            sizeMap.remove(name);
            cssMap.remove(name);
        } else
            System.out.println(" - ERROR: PLEASE CHANGE THE PAGE BEFORE REMOVE!");
    }

    // CSS Functions

    /**
     * Adds CSS to a scene.
     */
    public void addCSS(String name, String css) {
        manageCSS(name, true, css);
    }

    /**
     * Adds default CSS to a scene. (if exist)
     */
    public void addDefaultCSS(String name) {
        if (primaryCSS.trim().isEmpty()) {
            System.out.println(" - ERROR: ADD DEFAULT CSS FIRST!!");
        } else
            manageCSS(name, true);
    }

    /**
     * Removes CSS from a scene.
     */
    public void removeCSS(String name) {
        manageCSS(name, false);
    }

    // Drag

    /**
     * Makes a scene draggable.
     */
    public void enDraggable(String name) {
        makeDraggable(sceneMap.get(name));
    }

    /**
     * Disables the draggable in scene.
     */
    public void dsDraggable(String name) {
        Scene s = sceneMap.get(name);
        s.setOnMouseDragged(null);
        s.setOnMousePressed(null);
    }

    /**
     * Hide the title bar from Stage.
     */
    public void hideTitleBar() {
        this.primaryStage.initStyle(StageStyle.TRANSPARENT);
    }

    /**
     * Unhide the title bar from Stage.
     */
    public void unHideTitleBar() {
        this.primaryStage.initStyle(StageStyle.DECORATED);
    }

    /**
     * Minimize the app/window
     */
    public void minimize() {
        this.primaryStage.setIconified(true);
    }


    //////////////////////////
    //                      //
    //  Private Functions   //
    //                      //
    //////////////////////////
    private void makeDraggable(Scene scene) {
        // Make Scene Draggable
        scene.setOnMousePressed(event -> {
            xOffset = primaryStage.getX() - event.getScreenX();
            yOffset = primaryStage.getY() - event.getScreenY();
        });
        scene.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() + xOffset);
            primaryStage.setY(event.getScreenY() + yOffset);
        });
    }

    private void manageCSS(String name, boolean applyCSS, String css) {
        Scene scene = sceneMap.get(name);
        if (applyCSS) {
            scene.getRoot().getStylesheets().add(Objects.requireNonNull(getClass().getResource(css)).toExternalForm());
            cssMap.put(name, css);
        } else {
            scene.getRoot().getStylesheets().clear();
            cssMap.remove(name);
        }
    }

    private void manageCSS(String name, boolean applyCSS) {
        manageCSS(name, applyCSS, this.primaryCSS);
    }

    private void addConfig(String name, Scene scene) {
        this.primaryStage.setResizable(this.resizable);
        manageCSS(name, this.applyDefaultCSS);
        if (this.defaultSceneDraggable)
            makeDraggable(scene);   // default is on
    }


    //////////////////////////
    //                      //
    //    Custom-Getter     //
    //                      //
    //////////////////////////
    public String getCss(String name) {
        return cssMap.get(name);
    }

    public Scene getScene(String name) {
        return sceneMap.get(name);
    }

    public String getFxml(String name) {
        return fxmlMap.get(name);
    }

    public Size getSize(String name) {
        return sizeMap.get(name);
    }

    public double getHeight(String name) {
        return sizeMap.get(name).getH();
    }

    public double getWeight(String name) {
        return sizeMap.get(name).getW();
    }

    public boolean isResizable() {
        return resizable;
    }

    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }

    //////////////////////////
    //                      //
    //    Custom-Setter     //
    //                      //
    //////////////////////////
    public void setTitle(String title) {
        this.primaryStage.setTitle(title);
    }

    public void setIcon(String location) {
        try {
            this.primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResource(location)).toURI().toString()));
        } catch (URISyntaxException e) {
            System.out.println(" - ERROR WHILE SETTING ICON!");
            e.printStackTrace();
        }
    }

    public void setCss(String name, String css) {
        cssMap.put(name, css);
        if (primaryStage.getScene() == sceneMap.get(name))
            reload(name);
    }

    public void setSize(String name, Size size) {
        sizeMap.put(name, size);
        if (primaryStage.getScene() == sceneMap.get(name))
            reload(name);
    }

    public void setSize(String name, double h, double w) {
        setSize(name, new Size(h, w));
    }

    public void setHeight(String name, double h) {
        sizeMap.get(name).setH(h);
    }

    public void setWeight(String name, double w) {
        sizeMap.get(name).setW(w);
    }


    ////////////////////////////
    //                        //
    //     Getter - Setter    //
    //                        //
    ////////////////////////////
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public String getPrimaryCSS() {
        return primaryCSS;
    }

    public void setPrimaryCSS(String primaryCSS) {
        this.primaryCSS = primaryCSS;
    }

    public boolean isApplyDefaultCSS() {
        return applyDefaultCSS;
    }

    public void setApplyDefaultCSS(boolean applyDefaultCSS) {
        if (primaryCSS.trim().isEmpty()) {
            System.out.println(" - ERROR: ADD DEFAULT CSS FIRST!!");
        } else
            this.applyDefaultCSS = applyDefaultCSS;
    }

    public boolean isDefaultSceneDraggable() {
        return defaultSceneDraggable;
    }

    public void setDefaultSceneDraggable(boolean defaultSceneDraggable) {
        this.defaultSceneDraggable = defaultSceneDraggable;
    }

    public Size getDefaultSize() {
        return defaultSize;
    }

    public void setDefaultSize(Size defaultSize) {
        this.defaultSize = defaultSize;
    }
}
