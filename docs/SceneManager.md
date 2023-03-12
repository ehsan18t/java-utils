# Constructors

- `SceneManager(Stage stage)`
  - Creates a new SceneManager object with the given stage.
- `SceneManager(Stage stage, String CSS_Path)`
  - Creates a new SceneManager with the given stage and CSS file.
- `SceneManager(Stage stage, double height, double width)`
  - Creates a new SceneManager with the given stage, width and height.
- `SceneManager(Stage stage, Size size)`
  - Creates a new SceneManager with the given stage and size.
- `SceneManager(Stage stage, String CSS_Path, double height, double width)`
  - Creates a new SceneManager with the given stage, CSS file, width and height.
- `SceneManager(Stage stage, String CSS_Path, Size size)`
  - Creates a new SceneManager with the given stage, CSS file and size.

# Methods

## Add

- `void add(String name, String fxmlPath)`
  - Adds a scene to the SceneManager with the given name and fxml path. We can switch to the scene with the name later.
  - Added scene needs to be activated with `activate()` method to view it.
- `void add(String name, String fxmlPath, double width, double height)`
  - overloaded method of `add()` with the width and height of the scene.
- `void add(String name, String fxmlPath, Size size)`
  - overloaded method of `add()` with the `Size` object.

## Open

- `void open(String name, String fxmlPath)`
  - Adds and activates the scene with the given name and fxml file.
- `void open(String name, String fxmlPath, double width, double height)`
  - overloaded method of `open()` with the width and height of the scene.
- `void open(String name, String fxmlPath, Size size)`
  - overloaded method of `open()` with the `Size` object.

## Activate/Reload/Remove

- `void activate(String name)`
  - Activates the scene with the given name.
  - Can be changed to a scene with name if exists.
- `void reload(String name)`
  - Reloads/Refreshes the scene with the given name.
- `remove(String name)`
  - Removes the scene with the given name.

## CSS

- `void addDefaultCSS(String CSS_Path)`
  - Adds a CSS file to the all scene.
- `void addCSS(String name, String CSS_Path)`
  - Adds a CSS file to the scene with the given name.
- `void removeCSS(String name)`
  - Removes the CSS file from the scene with the given name.

## Other

- `void enDraggable(String name)`
  - Enables the dragging of the scene with the given name.
- `void dsDraggable(String name)`
  - Disables the dragging of the scene with the given name.
- `void hideTitleBar(String name)`
  - Hides the title bar of the scene with the given name.
- `void showTitleBar(String name)`
  - Shows the title bar of the scene with the given name.
- `void setIcon(String name, String iconPath)`
  - Sets the icon of the scene with the given name.
- `void minimize()`
  - Minimizes the current window.

## Getters

- `Stage getPrimaryStage()`
  - Returns the stage of the SceneManager.
- `Scene getScene(String name)`
  - Returns the scene with the given name.
- `String getCSS(String name)`
  - Returns the CSS file of the scene with the given name.
- `String getPrimaryCSS()`
  - Returns the default CSS file of the SceneManager.
- `String getFxml(String name)`
  - Returns the fxml path of the scene with the given name.
- `Size getSize(String name)`
  - Returns the size of the scene with the given name.
- `double getWidth(String name)`
  - Returns the width of the scene with the given name.
- `double getHeight(String name)`
  - Returns the height of the scene with the given name.
- `boolean isDefaultSceneDraggable()`
  - Returns true if the dragging scene is enabled.
- `boolean isResizable(boolean resizable)`
  - Returns true if the window/app is resizable.
- `static Stage getStage(Scene scene)`
  - Returns the stage of the given scene.
- `static Stage getStage(ActionEvent event)`
  - Returns the stage of the given event.

## Setters

- `void setTitle(String title)`
  - Sets the title of the window/app.
- `void setIcon(String iconPath)`
  - Sets the icon of the window/app.
- `void setCSS(String name, String CSS_Path)`
  - Sets the CSS file to the scene with the given name.
- `void setSize(String name, double width, double height)`
  - Sets the size of the scene with the given name.
- `void setSize(String name, Size size)`
  - Sets the size of the scene with the given name.
- `void setHeight(String name, double height)`
  - Sets the height of the scene with the given name.
- `void setWidth(String name, double width)`
  - Sets the width of the scene with the given name.
- `void setResizable(boolean resizable)`
  - Sets the window/app to resizable or not.
- `void setPrimaryStage(Stage stage)`
  - Sets the stage of the SceneManager.
- `void setPrimaryCSS(String CSS_Path)`
  - Sets the default CSS file of the SceneManager.
  <!-- - `void setFxml(String name, String fxmlPath)`
  - Sets the fxml path of the scene with the given name. -->
- `void setApplyDefaultCSS(boolean apply)`
  - Sets the default CSS file to apply to all scene or not.
- `void setDefaultSceneDraggable(boolean draggable)`
  - Sets the dragging of the scene to enabled or disabled.
- `void setDefaultSize(double width, double height)`
  - Sets the default size of the scene.
- `void setDefaultSize(Size size)`
  - Sets the default size of the scene.
