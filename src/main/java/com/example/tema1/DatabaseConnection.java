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


    public static ObservableList<Users> getDatausers2(){
        Connection conn = getConnection();
        ObservableList<Users> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from sign_up_table");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Users(rs.getString("username"), rs.getString("password")));
                System.out.println("E bine 1");
            }
        } catch (Exception e) {
        }
        return list;
    }


    public static ObservableList<Hours> getDatausers3(){
        Connection conn = getConnection();
        ObservableList<Hours> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from orar_terenafara");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Hours(rs.getString("Orar")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static ObservableList<Hours> getDatausers4(){
        Connection conn = getConnection();
        ObservableList<Hours> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from orar_terenacoperit");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Hours(rs.getString("Orar")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static ObservableList<Hours> getDatausers5(){
        Connection conn = getConnection();
        ObservableList<Hours> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from orar_terentenis");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Hours(rs.getString("Orar")));
            }
        } catch (Exception e) {
        }
        return list;
    }


    public static ObservableList<Hours> getDatausers6(){
        Connection conn = getConnection();
        ObservableList<Hours> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from orar_terenbasketball");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Hours(rs.getString("Orar")));
            }
        } catch (Exception e) {
        }
        return list;
    }


    public static ObservableList<Hours> getDatausers7(){
        Connection conn = getConnection();
        ObservableList<Hours> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from orar_terenhandball1");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Hours(rs.getString("Orar")));
            }
        } catch (Exception e) {
        }
        return list;
    }

}
