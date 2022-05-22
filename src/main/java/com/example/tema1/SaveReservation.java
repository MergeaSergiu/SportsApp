package com.example.tema1;



import javafx.scene.chart.PieChart;

import java.sql.*;
import java.time.LocalDate;
import java.util.Date;

public class SaveReservation {

    PreparedStatement statement;
    private DatabaseConnection connectNow ;
    private Connection connection ;

    public static void addReservation(String username, Date Date, String Time_Schedule, String Heat, String Court) throws SQLException{

        PreparedStatement statement;
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connection = connectNow.getConnection();
    try {
        statement = connection.prepareStatement("INSERT INTO sportapp.reservation2 (username,data,interval_orar,caldura,Court) VALUES (?,?,?,?,?)");

        statement.setString(1, username);
        statement.setDate(2, (java.sql.Date) Date);
        statement.setString(3, Time_Schedule);
        statement.setString(4, Heat);
        statement.setString(5, Court);
        statement.executeUpdate();
    }catch (Exception e){
        System.out.println("Nu se adauga datele in tabela");
    }

    }

    public static boolean validateUser(String username) throws SQLException{
        PreparedStatement statement;
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connection = connectNow.getConnection();
        statement= connection.prepareStatement("SELECT * from sign_up_table where username =?");
        statement.setString(1,username);
        ResultSet user = statement.executeQuery();
        return user.next();
    }

    public static boolean validateData(Date data) throws  SQLException{
        PreparedStatement statement;
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connection = connectNow.getConnection();
        statement = connection.prepareStatement("SELECT * from reservation2 where data =?");
        statement.setDate(2, (java.sql.Date) data);
        ResultSet user = statement.executeQuery();
        return user.next();

    }

    public  static boolean validateOra(String interval_orar) throws SQLException{
        PreparedStatement statement;
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connection = connectNow.getConnection();
        statement =connection.prepareStatement("SELECT * from reservation2 where interval_orar =?");
        statement.setString(3,interval_orar);
        ResultSet user = statement.executeQuery();
        return user.next();
    }

    public static boolean validateCourt(String Court) throws SQLException{
        PreparedStatement statement;
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connection = connectNow.getConnection();
        statement = connection.prepareStatement("SELECT * from reservation2 where Court=?");
        statement.setString(5,Court);
        ResultSet user = statement.executeQuery();
        return user.next();
    }


/*
    public static boolean validateData(Date Date) throws SQLException{
        PreparedStatement statement;
        statement = DatabaseConnection.databaseLink.prepareStatement("SELECT * from sportapp.reservations where Date =?");
        statement.setDate(2, (java.sql.Date) Date);
        ResultSet user = statement.executeQuery();
        return user.next();
    }

    public static boolean validateOra(String Time_Schedule) throws SQLException{
        PreparedStatement statement;
        statement = DatabaseConnection.databaseLink.prepareStatement("SELECT * from sportapp.reservations where Time_Schedule =?");
        statement.setString(3,Time_Schedule);
        ResultSet user = statement.executeQuery();
        return user.next();
    }

    public static boolean validateCourt(String Court) throws SQLException{
        PreparedStatement statement;
        statement = DatabaseConnection.databaseLink.prepareStatement("SELECT * from sportapp.reservation where Court=?");
        statement.setString(4,Court);
        ResultSet user = statement.executeQuery();
        return user.next();
    }
*/
}



