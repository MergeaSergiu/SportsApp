package com.example.tema1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Connection;

public class SaveReservation {


    private static Object DBConnection;

    public static void addReservation(String username, Date data, String interval_orar, boolean caldura,String Court) throws SQLException{
        PreparedStatement statement;
        statement = DBConnection.connection.prepareStatement("INSERT INTO sportapp.reservations2( username, data,interval_orar,caldura,Court) VALUES(?,?,?,?,?");

        statement.setString(1,username);
        statement.setDate(2, (java.sql.Date) data);
        statement.setString(3,interval_orar);
        statement.setString(4,String.valueOf(caldura));
        statement.setString(5,Court);
        statement.executeUpdate();
    }

    public static boolean validateUser(String username) throws SQLException{
        PreparedStatement statement;
        statement=DBConnection.connection.prepareStatement("SELECT * from sportapp.sign_up_table where username =?");
        statement.setString(1,username);
        ResultSet user = statement.executeQuery();
        return user.next();
    }


    public static void setDBConnection(Object DBConnection) {
        SaveReservation.DBConnection = DBConnection;
    }
}



