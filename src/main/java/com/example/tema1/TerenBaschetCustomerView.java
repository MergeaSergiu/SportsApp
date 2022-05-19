package com.example.tema1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.sql.SQLException;

public class TerenBaschetCustomerView {

    @FXML
    private Button afiseaza_review;

    @FXML
    private ImageView back_image;

    @FXML
    private Button button_home_page;

    @FXML
    private Button button_menu_page;

    @FXML
    private DatePicker calendar_data;

    @FXML
    private CheckBox check_caldura;

    @FXML
    private ChoiceBox<?> choice_box_ora;

    @FXML
    private Label error_message;

    @FXML
    private ImageView home_image;

    @FXML
    private Label label_interval_orar;

    @FXML
    private Label label_name;

    @FXML
    private Label label_numepagina;

    @FXML
    private Label label_selecteaza_data;

    @FXML
    private Button posteaza_review;

    @FXML
    private Button salveaza_rezervare;

    @FXML
    private TextField text_review;

    @FXML
    private TextField text_username;

    @FXML
    private TextField username_verify;

    @FXML
    private Label valid_message;

    @FXML
    void Save_Reservation_Baschet(ActionEvent event) {

        String nume_teren= "Teren_Baschet";
        try{
            if(text_username.getText().isEmpty() || calendar_data.getValue() == null || choice_box_ora.getValue() == null){
                error_message.setText("Please fill in all the fields");
                valid_message.setText("");
            }
            else if(SaveReservation.validateUser(text_username.getText()) == false){
                error_message.setText("Username does not exist!");
                valid_message.setText("");

            }else{
                String Caldura;
                if(check_caldura.isSelected()){
                    Caldura="TRUE";
                }
                else
                {
                    Caldura="FALSE";
                }

                java.sql.Date data = java.sql.Date.valueOf(calendar_data.getValue());
                // System.out.println(choice_box_ora.getValue().toString());
                SaveReservation.addReservation(text_username.getText(),data, choice_box_ora.getValue().toString(),Caldura,nume_teren);
                error_message.setText("");
                valid_message.setText("Rezervarea a fost salvata cu succes. NU UITA DE ACEASTA!!");
            }

        } catch (SQLException e) {

            error_message.setText("Something went wrong!");
        }


    }
    @FXML
    void home_page(ActionEvent event) throws  IOException {
        Main home_page = new Main();
        home_page.changeScene("FirstPage.fxml");
    }

    @FXML
    void menu_courts_page(ActionEvent event) throws IOException {
        Main menu_page = new Main();
        menu_page.changeScene("CustomerView.fxml");
    }

    @FXML
    void afiseaza_review(ActionEvent event) {
        if(username_verify.getText().isEmpty() ){
            error_message.setText("Introduceti un username!");
        }
        if else{

        }
    }

    @FXML
    void posteaza_review(ActionEvent event) {

    }

}

