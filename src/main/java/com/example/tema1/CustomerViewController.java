package com.example.tema1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerViewController {

    @FXML
    private Button Teren_fotbal_acoperit;

    @FXML
    private Button afiseaza_review;

    @FXML
    private Button posteaza_review;


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
    private TextField text_review;

    @FXML
    private TextField username_verify;

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
    void action_button_inside_footbal_court(/*ActionEvent event*/) throws IOException {
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

    @FXML
    void afiseaza_review(ActionEvent event) throws IOException {
        Main afiseaza_review = new Main();
        afiseaza_review.changeScene("TabelaReview.fxml");
    }

    public static void AlertBox(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mesaj pentru Review");
        //alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText(s);
        alert.showAndWait();
    }

    @FXML
    void posteaza_review(ActionEvent event) throws SQLException {
        if(username_verify.getText().isEmpty() ){
            AlertBox("Introduceti un username!");
        }
        else if(text_review.getText().isEmpty())
        {
            AlertBox("Nu lasa sectiunea necompletata");
        } else if (SaveReview.validateUser(username_verify.getText()) == false) {
            AlertBox("Username-ul nu exista!");
        }
        else{
            SaveReview.addReview(username_verify.getText(),text_review.getText());
            //error_message.setText("Review-ul a fost adaugat");
            AlertBox("Review-ul a fost adugat cu succes");
        }
    }

}







