package com.example.tema1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.sql.SQLException;

public class TerenFotbalAcoperitCustomerView {

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
    void Save_Reservation_Teren_Acoperit(ActionEvent event) {

        String nume_teren= "Teren_Fotbal_Acoperit";
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

                SaveReservation.addReservation(text_username.getText(),data, choice_box_ora.getValue().toString(),Caldura,nume_teren);
                valid_message.setText("Rezervarea a fost salvata cu succes. NU UITA DE ACEASTA!!");
                error_message.setText("");
            }

        } catch (SQLException e) {

            error_message.setText("Something went wrong!");
        }

    }

    @FXML
    void home_page(ActionEvent event) throws IOException {
        Main home_page = new Main();
        home_page.changeScene("FirstPage.fxml");
    }

    public static void AlertBox(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message Here...");
        //alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText(s);
        alert.showAndWait();
    }

    @FXML
    void menu_page(/*ActionEvent event*/) throws IOException {
        Main menu_page = new Main();
        menu_page.changeScene("CustomerView.fxml");
    }

    @FXML
    void afiseaza_review(ActionEvent event) {

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
