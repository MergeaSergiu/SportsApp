package com.example.tema1;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author amir
 */
public class FotballFieldOutsideController implements Initializable {


    @FXML
    private TableView<Hours> table_users;

    @FXML
    private TableColumn<Hours, String> col_hours;

    @FXML
    private TextField txt_hours;

    @FXML
    private TextField filterField;

    @FXML
    private Button home_button;

    ObservableList<Hours> listM;
    ObservableList<Hours> dataList;



    int index = -1;

    Connection connectDB =null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    public void Add_users (){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String sql = "insert into orar_terenafara (Orar)values(? )";
        try {
            pst = connectDB.prepareStatement(sql);
            pst.setString(1, txt_hours.getText());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Users Add succes");
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


    //////// methode select users ///////
    @FXML
    void getSelected (MouseEvent event){
        index = table_users.getSelectionModel().getSelectedIndex();
        if (index <= -1){

            return;
        }
        txt_hours.setText(col_hours.getCellData(index));
    }

    @FXML
    public void Edit (){
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String value1 = txt_hours.getText();
            /*??????*/String sql = "update orar_terenacoperit set Orar= '"+value1+"' where Orar='"+value1+"' ";
            pst= connectDB.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update");
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @FXML
    public void Delete(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String sql = "delete from orar_terenacoperit where Orar = ?";
        try {
            pst = connectDB.prepareStatement(sql);
            pst.setString(1, txt_hours.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }




    @FXML
    void search_user() {
        col_hours.setCellValueFactory(new PropertyValueFactory<Hours,String>("hours"));

        dataList = DatabaseConnection.getDatausers3();
        table_users.setItems(dataList);
        FilteredList<Hours> filteredData = new FilteredList<>(dataList, b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getHours().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches username
                }
                else
                    return false; // Does not match..
            });
        });
        SortedList<Hours> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table_users.comparatorProperty());
        table_users.setItems(sortedData);
    }

    @FXML
    private void home_button_action() throws IOException {
        Main m = new Main();
        m.changeScene("FieldsSelectionScheduleController.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        search_user();
        // Code Source in description
    }
}

