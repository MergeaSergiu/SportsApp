package com.example.tema1;

import javafx.event.ActionEvent;
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

    @FXML
    void action_button_basketball_court(ActionEvent event) throws IOException {
        Main basketball = new Main();
        basketball.changeScene("TerenBaschet.fxml");
    }

    @FXML
    void action_button_handbal_court(ActionEvent event) throws IOException {
        Main handbal = new Main();
        handbal.changeScene("TerenHandbal.fxml");
    }

    @FXML
    void action_button_home(ActionEvent event) throws IOException {
        Main l = new Main();
        l.changeScene("FirstPage.fxml");
    }

    @FXML
    void action_button_inside_footbal_court(ActionEvent event) throws IOException {
        Main insidefootball = new Main();
        insidefootball.changeScene("TerenFotbalAcoperit.fxml");
    }

    @FXML
    void action_button_outside_football_court(ActionEvent event) throws IOException {
        Main outsidefootball = new Main();
        outsidefootball.changeScene("TerenFotbalAfara.fxml");
    }

    @FXML
    void action_button_tenis_court(ActionEvent event) throws IOException {
        Main tenis = new Main();
        tenis.changeScene("TerenTenis.fxml");
    }

}







