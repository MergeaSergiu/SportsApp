package com.example.tema1;



import java.sql.*;
import java.util.Date;

public class SaveReservation {


    public static void addReservation(String Name, Date Date, String Time_Schedule, boolean Heat, String Court) throws SQLException{
        PreparedStatement statement;
        statement = DatabaseConnection.databaseLink.prepareStatement("INSERT INTO sportapp.reservations( username,data,interval_orar,caldura,Court) VALUES(?,?,?,?,?");

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


}



