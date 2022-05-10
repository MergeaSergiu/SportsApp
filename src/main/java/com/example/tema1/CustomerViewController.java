package com.example.tema1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class CustomerViewController {

    @FXML
    private Button Teren_fotbal_acoperit;

    @FXML
    private Button home_button;

    @FXML
    private Label numecentru;

    @FXML
    private Button teren_baschet;

    @FXML
    private Button teren_fotbal_afara;

    @FXML
    private Button teren_handbal;

    @FXML
    private Button teren_tenis;

    public void action_button_home() throws IOException {
        Main l = new Main();
        l.changeScene("FirstPage.fxml");
    }

}


