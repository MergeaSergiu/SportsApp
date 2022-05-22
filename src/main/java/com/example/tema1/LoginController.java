package com.example.tema1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    @FXML
    private Button button_login;

    @FXML
    private Button button_sign_up;

    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_username;

    @FXML
    private Button button_home;

    @FXML
    private Label loginMessageLabel;

    @FXML
    public void action_button_login() {
       if((tf_username.getText().isBlank()==false)&&(tf_password.getText().isBlank()==false)){
           validateLogin();
       }else{
           loginMessageLabel.setText("Please enter username and password");
       }
    }

    @FXML
    public void setButton_sing_up() throws IOException {
        Main m = new Main();
        m.changeScene("sign_up.fxml");
    }
    @FXML
    public void action_button_home() throws IOException {
        Main l = new Main();
        l.changeScene("FirstPage.fxml");
    }

    public void action_tf_username(ActionEvent actionEvent) {
    }

    public void action_tf_password(ActionEvent actionEvent) {
    }

    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM sportapp.sign_up_table WHERE username= '"+tf_username.getText()+"' AND password = '"+ encodePassword(tf_username.getText(),tf_password.getText()) +"'";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if(queryResult.getInt(1)==1){
                    //loginMessageLabel.setText("Congratulations!");
                    createAccountStage();
                    if((tf_username.getText().equals("dani.neagoe@yahoo.com")==true)&&(tf_password.getText().equals("3456")==true)){
                        Main l = new Main();
                        l.changeScene("MainPageAdmin.fxml");
                    }else {
                        Main l = new Main();
                        l.changeScene("CustomerView.fxml");
                    }
                }else{
                    loginMessageLabel.setText("Invalid login. Try again");
                }
            }

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

    public void createAccountStage() throws IOException {
        Main l = new Main();
         l.changeScene("sign_up.fxml");
    }



    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", "*"); //to be able to save in JSON format
    }


    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }


}
