package jfx.scenes.home;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import jfx.DB.User;
import jfx.scenes.StageManager;

public class Controller implements Initializable{
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Load user data as soon as the home screen loads
        loadUserData();
    }
    
    @FXML
    private Text fullnameProfile;

    @FXML
    private Button logoutBtn;

    @FXML
    void handleLogout(ActionEvent event) {
        StageManager instance = StageManager.getInstance();
        instance.renderStage("home", "login");
    }
    private void loadUserData() {
        // Assuming you have a method to retrieve user data
        User user = User.userInitializer();
        user.showUserInfo();
        if (user.getFullname() != null) {
            // Update UI with user data
            fullnameProfile.setText(user.getFullname());
        }
    }
}
