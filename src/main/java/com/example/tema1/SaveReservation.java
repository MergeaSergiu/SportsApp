package com.example.tema1;



import java.sql.*;
import java.util.Date;

public class SaveReservation {

    PreparedStatement statement;
    private DatabaseConnection connectNow ;
    private Connection connection ;

    public static void addReservation(String username, Date data, String interval_orar, String caldura, String Court) throws SQLException{

        PreparedStatement statement;
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connection = connectNow.getConnection();
    try {
        statement = connection.prepareStatement("INSERT INTO sportapp.reservation2 (username,data,interval_orar,caldura,Court) VALUES (?,?,?,?,?)");

        statement.setString(1, username);
        statement.setDate(2, (java.sql.Date) data);
        statement.setString(3, interval_orar);
        statement.setString(4, caldura);
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
        statement= connection.prepareStatement("SELECT * from sportapp.sign_up_table where username =?");
        statement.setString(1,username);
        ResultSet user = statement.executeQuery();
        return user.next();
    }
    public static boolean validateReservation(Date data,String interval_orar,String Court) throws SQLException {
        PreparedStatement statement;
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connection = connectNow.getConnection();
        statement = connection.prepareStatement("SELECT * from sportapp.reservation2 where (data,interval_orar,Court) = (?,?,?)");
        statement.setDate(1, (java.sql.Date) data);
        statement.setString(2,interval_orar);
        statement.setString(3,Court);
        ResultSet user = statement.executeQuery();
        return  user.next();
    }



}



