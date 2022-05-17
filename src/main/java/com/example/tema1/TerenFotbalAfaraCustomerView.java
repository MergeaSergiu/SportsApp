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
import java.net.URL;
import java.util.ResourceBundle;

public class TerenFotbalAfaraCustomerView {

    @FXML
    private ImageView back_image;

    @FXML
    private Button button_courts_page;

    @FXML
    private Button button_home_page;

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
    void Save_Reservation_Teren_Afara(ActionEvent event) {

    }

    @FXML
    void home_button(/*ActionEvent event*/) throws  IOException {
        Main home_button = new Main();
        home_button.changeScene("FirstPage.fxml");
    }

    @FXML
    void menu_courts_button(ActionEvent event) throws IOException {
        Main menu_page = new Main();
        menu_page.changeScene("CustomerView.fxml");
    }


}
