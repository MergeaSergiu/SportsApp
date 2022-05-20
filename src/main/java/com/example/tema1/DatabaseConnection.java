package com.example.tema1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseConnection {

    public static Connection databaseLink;
    //public static Object getConnection;

    public static Connection getConnection(){
        String databaseName = "test";
        String databaseUser="root";
        String databasePassword = "1234";
        //String url = "jdbc:mysql://localhost:3306/" + databaseName;
        String url ="jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("E ok");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
            //databaseLink = DriverManager.getConnection(url,"root","2001");
            System.out.println("E ok");
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }

/*
    public static ObservableList<Reservations> getDatausers(){
        Connection conn = getConnection();
        ObservableList<Reservations> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from reservation2");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Reservations(rs.getString("username"), rs.getDate("data"), rs.getString("interval_orar"), rs.getString("caldura"), rs.getString("Court")));
            }
        } catch (Exception e) {
        }
        return list;
    }
*/

        public static ObservableList<Reservations> getDatausers(){
            Connection conn = getConnection();
            ObservableList<Reservations> list = FXCollections.observableArrayList();
            try {
                PreparedStatement ps = conn.prepareStatement("select * from reservation2");
                ResultSet rs = ps.executeQuery();

                while (rs.next()){
                    list.add(new Reservations(rs.getString("username"), rs.getDate("data"), rs.getString("interval_orar"), rs.getString("caldura"), rs.getString("Court")));
                    System.out.println("E bine 1");
                }
            } catch (Exception e) {
            }
            return list;
        }


}
