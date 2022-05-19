package com.example.tema1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class SaveReview {

    PreparedStatement statement;
    private DatabaseConnection connectNow ;
    private Connection connection ;

    public static void addReview(String username,String Review) throws SQLException {

        PreparedStatement statement;
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connection = connectNow.getConnection();
        try {
            statement = connection.prepareStatement("INSERT INTO sportapp.review2 (username,Review) VALUES (?,?)");

            statement.setString(1, username);
            statement.setString(2, Review);
            statement.executeUpdate();
        } catch (Exception e) {
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
}

