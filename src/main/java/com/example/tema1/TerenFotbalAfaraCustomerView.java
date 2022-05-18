package com.example.tema1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class TerenFotbalAfaraCustomerView {

    @FXML
    private MenuItem Ora5_6;

    @FXML
    private MenuItem Ora6_7;

    @FXML
    private MenuItem Ora7_8;

    @FXML
    private MenuItem Ora8_9;

    @FXML
    private MenuItem Ora9_10;

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
    private MenuButton menu_button;

    @FXML
    private Button salveaza_rezervare;

    @FXML
    private TextField text_username;

    @FXML
    void Save_Reservation_Teren_Afara() {

    }

    @FXML
    void home_button() throws IOException {
        Main l = new Main();
        l.changeScene("FirstPage.fxml");
    }

    @FXML
    void menu_courts_button() throws IOException {
        Main p = new Main();
        p.changeScene("CustomerView.fxml");
    }

}
