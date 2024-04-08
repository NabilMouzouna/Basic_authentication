package jfx.scenes.signup;

import jfx.DB.DatabaseManagement;
import jfx.DB.User;
import jfx.scenes.SceneHandler;
import jfx.scenes.StageManager;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller{
    @FXML
    private TextField emailField;

    @FXML
    private Hyperlink loginLink;

    @FXML
    private TextField nameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signupButton;

    @FXML
    private Label stateMessageLabel;

    @FXML
    void navigateToLogin(ActionEvent event) throws IOException{
        StageManager instance = StageManager.getInstance();
        instance.getStage("login").show();
        instance.getStage("signup").close();
    }
    
    @FXML
    public void handleSignup(ActionEvent event) throws IOException {
        
        User user = DatabaseManagement.findUser(emailField.getText());
        
        if(user == null) {
            signupButton.setDisable(true);
            User newUser = new User(0, nameField.getText(), emailField.getText(), passwordField.getText());
            boolean result = DatabaseManagement.saveToDB(newUser);
            User.userInitializer(newUser);
            // set the user information to use it throughout the application
            if(result) {
                stateMessageLabel.setText("signup successfully");
                SceneHandler homeScene = new SceneHandler("/jfx//scenes/home/Home.fxml","INSA Home");
                StageManager instance = StageManager.getInstance();
                instance.addStage("home",homeScene.getStage());
                instance.renderStage("signup", "home");
            }
            else stateMessageLabel.setText("faild to signup, try again");
        }else{
            stateMessageLabel.setText("this email is already exist, login");
        }
        resetForm();

    }
    
    public void resetForm(){
        this.emailField.setText("");
        this.passwordField.setText("");
        this.nameField.setText("");
        this.stateMessageLabel.setText("");
        this.signupButton.setDisable(false);
    }
   
}

