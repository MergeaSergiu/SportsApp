package ControllerTests;

import com.example.tema1.LoginController;
import com.example.tema1.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(ApplicationExtension.class)
public class LoginControllerTest extends Application {

    public static final String username = "mergeamihai@yahoo.com";
    public static final String password = "1234";

    @Before
    public void setUpClass() throws Exception {
        ApplicationTest.launch(Main.class);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(LoginController.class.getResource("Login.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
        stage.toFront();
    }

    @Test
    public void loginTest(FxRobot fxRobot) {
        fxRobot.clickOn("#tf_username");
        fxRobot.write(username);
        fxRobot.clickOn("#tf_password");
        fxRobot.write(password);
        fxRobot.clickOn("#button_login");
    }

}


