package com.example.tema1;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;

public class AdminViewController {

    @FXML
    private TableView<Reservation> TableView;

    @FXML
    private TableColumn<Reservation, String> court;

    @FXML
    private TableColumn<Reservation, Date> date;

    @FXML
    private TableColumn<Reservation, Boolean> heat;

    @FXML
    private TableColumn<Reservation, Integer> id_reservation;

    @FXML
    private TableColumn<Reservation, String> name;

    @FXML
    private TableColumn<Reservation, String> time_schedule;


    public void initialize(){
    name.setCellValueFactory(new PropertyValueFactory<Reservation,String>("Name"));
    court.setCellValueFactory(new PropertyValueFactory<Reservation,String>("Court"));
    time_schedule.setCellValueFactory(new PropertyValueFactory<Reservation,String>("TimeSchedule"));
    date.setCellValueFactory(new PropertyValueFactory<Reservation, Date>("Date"));
    heat.setCellValueFactory(new PropertyValueFactory<Reservation,Boolean>("Heat"));
    id_reservation.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("IdReservation"));
    }

}
