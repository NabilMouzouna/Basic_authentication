package jfx;


import javafx.application.Application;
import javafx.stage.Stage;
import jfx.scenes.SceneHandler;
import jfx.scenes.StageManager;

public class Main extends Application {
    @Override
    public void start(Stage primStage) throws Exception{
        try {
            // Creating Scenes
            SceneHandler loginScene = new SceneHandler(primStage, "login/Login.fxml","Login");
            SceneHandler signupScene = new SceneHandler("signup/Signup.fxml", "Signup");
                       
            StageManager instance = StageManager.getInstance();
            
            // Adding all Stages to StageManager
            instance.addStage("signup", signupScene.getStage());
            instance.addStage("login", loginScene.getStage());

            loginScene.getStage().show();
            

        } catch (Exception e) {
           e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}