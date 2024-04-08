package jfx.scenes;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SceneHandler {
    /**
     * This class is responsible for creating the scene, rendering the scene.
     * @constructor two ways of using the constructor: if you have already the stage you can pass it to the constructor otherwise you can constructor without specifying the stage parameter and a new stage will be created automatically
     * @methods -getStage: returns the stage after appending the scene. -activateStage: renders the created stage instead of the current one.
     */
    
    private Stage stage;

    public SceneHandler(String fxml_path, String title) throws IOException{
        // creating new stage
        Parent root = FXMLLoader.load(getClass().getResource(fxml_path));
        Scene newScene = new Scene(root,720,400);
        stage = new Stage();
        stage.setScene(newScene);
        stage.setTitle(title);
    }
    public SceneHandler(Stage stage, String fxml_path, String title) throws IOException {
        this.stage = stage;
        stage.setTitle(title);
        Parent root = FXMLLoader.load(getClass().getResource(fxml_path));
        Scene newScene = new Scene(root,720,400);
        this.stage.setScene(newScene);
        this.stage.setTitle(title);
    }
    public Stage getStage() {
        return stage;
    }
}
