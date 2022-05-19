package com.example.tema1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    private ChoiceBox<String> choice_box_ora;
    private String[] ore = {"ora5_6","ora6_7","ora7_8","ora8_9"};
    public void initialize(){
        choice_box_ora.getItems().addAll(ore);
    }

    @FXML
    private Label error_message;

    @FXML
    private Label error_review;

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

    public static void AlertBox(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mesaj pentru Review");
        //alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText(s);
        alert.showAndWait();
    }

    @FXML
    void afiseaza_review(ActionEvent event) throws SQLException {

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

