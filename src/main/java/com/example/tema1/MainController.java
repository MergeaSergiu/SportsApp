package com.example.tema1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainController {

    @FXML
    private Button button_about_us;

    @FXML
    private Button button_home;

    @FXML
    private Button button_login;


    @FXML
    void action_button_about_us(ActionEvent event) throws IOException {
        Main about_us = new Main();
        about_us.changeScene("About_us.fxml");
    }

    @FXML
    void action_button_home(ActionEvent event) {

    }

    @FXML
    void action_button_login(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Login.fxml");
    }

}