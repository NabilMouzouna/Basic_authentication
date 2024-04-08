package jfx.scenes.login;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import jfx.DB.DatabaseManagement;
import jfx.DB.User;
import jfx.scenes.SceneHandler;
import jfx.scenes.StageManager;
public class Controller{

    @FXML
    private TextField emailField;

    @FXML
    private Text insaLogo;

    @FXML
    private Hyperlink signupLink;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signupButton;

    @FXML
    private Text signupTitle;

    @FXML
    private Text slugan;

    @FXML
    private Label stateMessageLabel;


    @FXML
    void navigateToSignUp(ActionEvent event) throws IOException{
        StageManager instance = StageManager.getInstance();
        instance.renderStage("login", "signup");
    }

    @FXML
    void handleLogin(ActionEvent event) throws SQLException, IOException {

        User user = DatabaseManagement.findUser(emailField.getText());
        if(user == null) {
            stateMessageLabel.setText("this email is not available, sign up");
            return;
        }

        if(!user.getPassword().equals(passwordField.getText())) {
            stateMessageLabel.setText("password is incorrect");
            return;
        }
        stateMessageLabel.setText("logged in successfully");
        signupButton.setDisable(true);
        // set the user information to use it throughout the application
        User.userInitializer(user);

        // Navigate to Home Window
        StageManager instance = StageManager.getInstance();
        SceneHandler homeScene = new SceneHandler("/jfx/scenes/home/Home.fxml","INSA Home");
        instance.addStage("home",homeScene.getStage());
        instance.renderStage("login", "home");
        resetForm();
    }
    public void resetForm(){
        this.emailField.setText("");
        this.passwordField.setText("");
        this.stateMessageLabel.setText("");
        this.signupButton.setDisable(false);
    }
}
