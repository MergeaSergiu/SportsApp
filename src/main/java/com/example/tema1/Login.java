package com.example.tema1;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Login{

    private AnchorPane loginPane;
    private Scene loginScene;
    private Stage loginStage;

    private static final int LOGIN_WIDTH = 1200;
    private static final int LOGIN_HEIGHT =600;

    private Stage stg;


    private Stage menuStage;

    public Login() throws IOException {
        stg=loginStage;
        initializeStage();
        createKeyListeners();
    }

    private void initializeStage() throws IOException {
        loginPane = new AnchorPane();
        loginPane= FXMLLoader.load(getClass().getResource("login.fxml"));
        loginScene = new Scene(loginPane,LOGIN_WIDTH,LOGIN_HEIGHT);
        loginStage = new Stage();
        loginStage.setScene(loginScene);
        //createButtons();
        //setButton_sing_up("sign_up.fxml");
    }

    private void createKeyListeners(){
        loginScene.setOnKeyPressed((EventHandler<? super KeyEvent>) new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode()==KeyCode.LEFT) {

                }else if(event.getCode()==KeyCode.RIGHT) {

                }
            }
        });



        loginScene.setOnKeyReleased((EventHandler<? super KeyEvent>) new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode()==KeyCode.LEFT) {

                }else if(event.getCode()==KeyCode.RIGHT) {

                }
            }
        });
    }




	/*private void createButtons() {
	/*	Button button = new Button();
		mainPane.getChildren().add(button); //il adaugam la lsita de copii
		button.setOnMouseEntered(new EventHandler<Event>() {// De fiecare data cand mouse ul este peste buton metoda hendle
			@Override											   // va fi apelata.
			public void handle(Event event) {
					System.out.println("mouse is entered");					//
			}                                                      //
	});

		button button1 =new button("HOME");
		loginPane.getChildren().add(button1);
		button button2 =new button("ABOUT US");
		loginPane.getChildren().add(button2);
		button1.setLayoutX(500);
		button1.setLayoutY(100);
		button2.setLayoutX(500);
		button2.setLayoutY(200);
  }*/




   /* private Button createButtonSing_up() throws IOException {
        button loginButton = new button("CONNECTION");
        loginPane.getChildren().add(loginButton);
        loginButton.setLayoutX(500);
        loginButton.setLayoutY(300);
        LoginController frame = new LoginController();
        frame.setButton_sing_up();
        Button button_sign_up = frame.getButton();
       // loginPane.getChildren().add(button_sign_up);
        button_sign_up.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Sign_up button_sign_up;
                try {
                    button_sign_up = new Sign_up();
                    button_sign_up.createNewWindow(loginStage);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        return button_sign_up;
    }*/



    public void createNewWindow(Stage menuStage) throws IOException {
        this.menuStage = menuStage;
        this.menuStage.hide();
        loginStage.show();
    }


    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }


}
