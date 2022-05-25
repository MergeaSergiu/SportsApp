package com.example.tema1;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Statement;

public class Sign_upController{
    @FXML
    private Button button_login;

    @FXML
    private Button button_sing_up;

    @FXML
    private Label confirmPasswordField;

    @FXML
    private Label registrationMessageLabel;

    @FXML
    private PasswordField tf_confirm_password;

    @FXML
    private PasswordField tf_password;

    @FXML
    private TextField tf_username;

    @FXML
    private void action_button_login() throws IOException {
        Main m = new Main();
        m.changeScene("Login.fxml");
    }
    @FXML
    public void action_tf_username(ActionEvent actionEvent) {
    }
    @FXML
    public void action_tf_password(ActionEvent actionEvent) {
    }
    @FXML
    public void action_button_sing_up() {
       //sign_up_MessageLabel.setText("User has been registered successfully!");
        if(tf_password.getText().equals(tf_confirm_password.getText())){
            sing_up_User();
            confirmPasswordField.setText("");
        }else{
            confirmPasswordField.setText("Password does not match");
        }
    }

    public void sing_up_User(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String username = tf_username.getText();
        String password = tf_password.getText();

        String insertFields="INSERT INTO sportapp.sign_up_table VALUES('";
        String insertValues= username +"','" +encodePassword(username,password)+"')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDB.createStatement();
            System.out.println("Merge bine 1");
            System.out.println(insertToRegister.length());
            statement.executeUpdate(insertToRegister);
            System.out.println("Merge bine 2");
            registrationMessageLabel.setText("User has been registered successfully!");
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
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