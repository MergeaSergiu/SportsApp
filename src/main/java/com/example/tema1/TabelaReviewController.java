package com.example.tema1;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import jdk.nashorn.internal.runtime.RewriteException;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TabelaReviewController<index> implements Initializable {

    ObservableList<Review> dataList;

    @FXML
    private TableColumn<Review, String> col_review;

    @FXML
    private TableColumn<Review, String> col_username;

    @FXML
    private Button add_button;

    @FXML
    private TextField filterField;

    @FXML
    private TableView<Review> table_users;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_username;

    @FXML
    private Button tenis_button;

    @FXML
    private Button football_acoperit_button;

    @FXML
    private Button football_afara_button;

    @FXML
    private Button handbal_button;

    @FXML
    private Button backetball_button;

    @FXML
    private Button button_menu;

    @FXML
    private ImageView menu_image;

    @FXML
    private ImageView minge_basket;

    @FXML
    private ImageView minge_fotbal_acoperit;

    @FXML
    private ImageView minge_fotbal_afara;

    @FXML
    private ImageView minge_handbal;

    @FXML
    private ImageView minge_tenis;

    int index = -1;


    @FXML
    void getSelected(MouseEvent event) {
        index = table_users.getSelectionModel().getSelectedIndex();
        if (index <= -1) {

            return;
        }
        txt_id.setText(col_review.getCellData(index).toString());
        txt_username.setText(col_username.getCellData(index).toString());
    }



    @FXML
    private void search_user() {
        col_username.setCellValueFactory(new PropertyValueFactory<Review,String>("username"));
        col_review.setCellValueFactory(new PropertyValueFactory<Review,String>("Review"));

        dataList = DatabaseConnection.getDatausers0();
        table_users.setItems(dataList);
        FilteredList<Review> filteredData = new FilteredList<>(dataList, b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches username
                } else if (person.getReview().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches password
                }
                else
                    return false; // Does not match..
            });
        });
        SortedList<Review> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table_users.comparatorProperty());
        table_users.setItems(sortedData);
    }



    @FXML
    void tenis_button_action(ActionEvent event) throws IOException {
        Main tenis_button_action = new Main();
        tenis_button_action.changeScene("TerenTenis.fxml");
    }

    @FXML
    void handbal_button_action(ActionEvent event) throws IOException {
        Main handbal_button_action = new Main();
        handbal_button_action.changeScene("TerenHandbal.fxml");

    }

    @FXML
    void fotball_afara_button_action(ActionEvent event) throws IOException {
            Main fotbal_afara_button_action = new Main();
            fotbal_afara_button_action.changeScene("TerenFotbalAfara.fxml");
    }

    @FXML
    void football_acoperit_action(ActionEvent event) throws IOException {
            Main footbal_acoperit_button_action = new Main();
            footbal_acoperit_button_action.changeScene("TerenFotbalAcoperit.fxml");
    }

    @FXML
    void basketball_menu_action(ActionEvent event) throws IOException {
            Main basketball_menu_action = new Main();
            basketball_menu_action.changeScene("TerenBaschet.fxml");
    }

    @FXML
    void button_menu_action(ActionEvent event) throws IOException {

            Main button_menu_action = new Main();
            button_menu_action.changeScene("CustomerView.fxml");
    }
    ResultSet rs = null;
    PreparedStatement pst = null;
    @FXML
    void add_Review_action(ActionEvent event) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();


        String sql = "insert into sportapp.review2 (username,Review)values(?,?)";
        try{
            pst = connectDB.prepareStatement(sql);
            pst.setString(1, txt_username.getText());
            pst.setString(2, txt_id.getText());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Review Add succes");
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void Edit (){
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String value1 = txt_username.getText();
            String value2 = txt_id.getText();
            /*??????*/String sql = "UPDATE sportapp.review2 set username= '"+value1+"' , Review ='"+value2+ "' where username='"+value1+"' , Review = '"+value2+"' ";
            pst= connectDB.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update");
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        search_user();

    }






}
