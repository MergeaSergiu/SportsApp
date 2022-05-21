package com.example.tema1;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author amir
 */
public class AdminViewController implements Initializable {


    @FXML
    private TableView<Reservations> table_users;

    @FXML
    private TableColumn<Reservations, String> col_username;

    @FXML
    private TableColumn<Reservations, Date> col_data;

    @FXML
    private TableColumn<Reservations, String> col_timeschedule;

    @FXML
    private TableColumn<Reservations, String> col_heat;

    @FXML
    private TableColumn<Reservations, String> col_court;

    @FXML
    private TextField txt_username;

    @FXML
    private DatePicker txt_data;
    @FXML
    private TextField txt_timeschedule;

    @FXML
    private TextField txt_heat;

    @FXML
    private TextField txt_court;

    @FXML
    private TextField filterField;


    ObservableList<Reservations> listM;
    ObservableList<Reservations> dataList;



    int index = -1;

    Connection connectDB =null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    public void Add_users (){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String sql = "insert into reservation2 (username,data,interval_orar,caldura,Court)values(?,?,?,?,? )";
        try {
            pst = connectDB.prepareStatement(sql);
            pst.setString(1, txt_username.getText());
            pst.setDate(2, java.sql.Date.valueOf(txt_data.getValue()));
            pst.setString(3, txt_timeschedule.getText());
            pst.setString(4, txt_heat.getText());
            pst.setString(5, txt_court.getText());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Users Add succes");
            UpdateTable();
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
        txt_username.setText(col_username.getCellData(index));
        //(Date)txt_data.setData(col_data.getCellData(index));
        //java.sql.Date txt_data = java.sql.Date.valueOf(String.valueOf(col_data.getCellData(index)));
        //txt_data.DatePicker(col_data.getCellData(index));
        txt_data.setUserData(col_data.getCellData(index));
        txt_timeschedule.setText(col_timeschedule.getCellData(index));
        txt_heat.setText(col_heat.getCellData(index));
        txt_court.setText(col_court.getCellData(index));

    }

    @FXML
    public void Edit (){
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String value1 = txt_username.getText();
            //(java.sql.Date) value2 = Date.valueOf(String.valueOf(col_data.getValue().getColumns()));
            //Date value2 = Date.getValue(col_data.);
            java.sql.Date value2 = java.sql.Date.valueOf(txt_data.getValue());
            String value3 = txt_timeschedule.getText();
            String value4 = txt_heat.getText();
            String value5 = txt_court.getText();
            /*??????*/String sql = "update reservation2 set username= '"+value1+"',data= '"+value2+"',interval_orar= '"+value3+"',caldura= '"+value4+"',Court= '"+value5+"' where username='"+value1+"' ";
            pst= connectDB.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update");
            UpdateTable();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @FXML
    public void Delete(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String sql = "delete from reservation2 where username = ?";
        try {
            pst = connectDB.prepareStatement(sql);
            pst.setString(1, txt_username.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
            UpdateTable();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @FXML
    public void UpdateTable(){
        col_username.setCellValueFactory(new PropertyValueFactory<Reservations,String>("username"));
        System.out.println("E ok2");
        col_data.setCellValueFactory(new PropertyValueFactory<Reservations,Date>("data"));
        System.out.println("E ok3");
        col_timeschedule.setCellValueFactory(new PropertyValueFactory<Reservations,String>("interval_orar"));
        System.out.println("E ok4");
        col_heat.setCellValueFactory(new PropertyValueFactory<Reservations,String>("caldura"));
        System.out.println("E ok5");
        col_court.setCellValueFactory(new PropertyValueFactory<Reservations,String>("Court"));
        System.out.println("E ok6");

        listM = DatabaseConnection.getDatausers();
        System.out.println("E ok7");
        table_users.setItems(listM);
        System.out.println("E ok8");
    }




    @FXML
    void search_user() {
        col_username.setCellValueFactory(new PropertyValueFactory<Reservations,String>("Name"));
        col_data.setCellValueFactory(new PropertyValueFactory<Reservations,Date>("date"));
        col_timeschedule.setCellValueFactory(new PropertyValueFactory<Reservations,String>("Time_Schedule"));
        col_heat.setCellValueFactory(new PropertyValueFactory<Reservations,String>("heat"));
        col_court.setCellValueFactory(new PropertyValueFactory<Reservations,String>("Court"));

        dataList = DatabaseConnection.getDatausers();
        table_users.setItems(dataList);
        FilteredList<Reservations> filteredData = new FilteredList<>(dataList, b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getName().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches username
                } else if (person.getDate()== null) {
                    return true; // Filter matches password
                }else if (person.getTime_Schedule().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches password
                }else if (person.getHeat().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;// Filter matches email
                }else if (person.getCourt().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;// Filter matches email
                else
                    return false; // Does not match..
            });
        });
        SortedList<Reservations> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table_users.comparatorProperty());
        table_users.setItems(sortedData);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UpdateTable();
        search_user();
        // Code Source in description
    }
}
