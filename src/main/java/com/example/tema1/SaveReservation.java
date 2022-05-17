package com.example.tema1;



import java.sql.*;
import java.util.Date;

public class SaveReservation {


    public static void addReservation(String Name, Date Date, String Time_Schedule, boolean Heat, String Court) throws SQLException{
        PreparedStatement statement;
        statement = DatabaseConnection.databaseLink.prepareStatement("INSERT INTO sportapp.reservations( Name,Date,Time_Schedule, Heat,Court) VALUES(?,?,?,?,?");

        statement.setString(1,Name);
        statement.setDate(2, (java.sql.Date) Date);
        statement.setString(3,Time_Schedule);
        statement.setString(4,String.valueOf(Heat));
        statement.setString(5,Court);
        statement.executeUpdate();
    }

    public static boolean validateUser(String username) throws SQLException{
        PreparedStatement statement;
        statement= DatabaseConnection.databaseLink.prepareStatement("SELECT * from sportapp.sign_up_table where username =?");
        statement.setString(1,username);
        ResultSet user = statement.executeQuery();
        return user.next();
    }

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

}



