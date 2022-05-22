package com.example.tema1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class TerenBaschetCustomerView implements Initializable {

    @FXML
    private ComboBox<String> Orar;

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

    private PreparedStatement pst;
    private Connection connection;

    private DatabaseConnection dbConnection;

    private void insertTime_Schedule(){
        Orar.getItems().removeAll(Orar.getItems());
        String query = "SELECT DISTINCT  Orar FROM  orar_terenbasketball";
        try{
            PreparedStatement statement;
            statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                String Time_Schedule = rs.getString("Orar");
               Orar.getItems().add(Time_Schedule);

            }
            
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void Save_Reservation_Baschet(ActionEvent event) {

        String nume_teren= "Teren_Baschet";
        //String room_type= roomType.getSelectionModel().getSelectedItem();
        try{
            if(text_username.getText().isEmpty() || calendar_data.getValue() == null || Orar.getSelectionModel().getSelectedItem() == null){
                error_message.setText("Please fill in all the fields");
                valid_message.setText("");
            }
            else if(!SaveReservation.validateUser(text_username.getText())){
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
                if(SaveReservation.validateReservation(data,Orar.getSelectionModel().getSelectedItem().toString(),nume_teren)){
                    error_message.setText("Rezervarea exista deja in baza de date");
                    valid_message.setText("");
                }else {
                    SaveReservation.addReservation(text_username.getText(), data, Orar.getSelectionModel().getSelectedItem().toString(), Caldura, nume_teren);
                    error_message.setText("");
                    valid_message.setText("Rezervarea a fost adaugata in baza de date");
                }
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
    void afiseaza_review(ActionEvent event) throws IOException {
        Main afiseaza_review = new Main();
        afiseaza_review.changeScene("TabelaReview.fxml");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         dbConnection = new DatabaseConnection();
            connection = dbConnection.getConnection();
        insertTime_Schedule();
    }
}

