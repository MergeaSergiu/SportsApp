package com.example.tema1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.base.WindowMatchers;

@ExtendWith(ApplicationExtension.class)
class LoginControllerTest extends ApplicationTest {


    public static final String username = "asdf";
    public static final String password = "1234";
/*
    @Before
    public void setUpClass() throws Exception {
        ApplicationTest.launch(Main.class);
    }
*/
    @Start
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