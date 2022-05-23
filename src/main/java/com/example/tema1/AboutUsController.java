package com.example.tema1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class AboutUsController {

    @FXML
    private Button home_page_button;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label_numele_noastre;

    @FXML
    private Button log_in_button;

    @FXML
    private Label login_label;

    @FXML
    private ImageView menu_image;

    @FXML
    private Label nume_centru;

    @FXML
    private Button sign_up_button;

    @FXML
    private Label sign_up_label;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView sing_up_image;

    @FXML
    private ImageView log_in_image;

    @FXML
    void home_page_action(ActionEvent event) throws IOException {
        Main home_page = new Main();
        home_page.changeScene("FirstPage.fxml");
    }

    @FXML
    void log_in_page(ActionEvent event) throws IOException {
        Main log_in_page = new Main();
        log_in_page.changeScene("Login.fxml");
    }

    @FXML
    void sign_up_page(ActionEvent event) throws IOException {
        Main sign_up_page = new Main();
        sign_up_page.changeScene("sign_up.fxml");
    }

}
