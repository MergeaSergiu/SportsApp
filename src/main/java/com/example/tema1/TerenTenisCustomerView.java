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

public class TerenTenisCustomerView {

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
    private ChoiceBox<String> choice_box_ora;
    private String[] ore = {"ora5_6","ora6_7","ora7_8","ora8_9"};

    public void initialize(){
        choice_box_ora.getItems().addAll(ore);
    }

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
    private Button salveaza_rezervare;

    @FXML
    private TextField text_username;

    @FXML
    void Save_Reservation_Tenis(ActionEvent event) {
        String nume_teren= "Teren_Tenis";
        try{
            if(text_username.getText().isEmpty() || calendar_data.getValue() == null || choice_box_ora.getValue() == null){
                error_message.setText("Please fill in all the fields");
            }
            else if(SaveReservation.validateUser(text_username.getText()) == false){
                error_message.setText("Username does not exist!");
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
                error_message.setText("Rezervarea a fost adaugata cu succes");
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
    void menu_page(ActionEvent event) throws IOException {
        Main menu_page = new Main();
        menu_page.changeScene("CustomerView.fxml");
    }

}

