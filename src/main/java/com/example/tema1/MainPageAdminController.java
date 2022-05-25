package com.example.tema1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class MainPageAdminController {
    @FXML
    private Button reservations_button;

    @FXML
    private Button users_button;

    @FXML
    private Button field_programs;

    @FXML
    private Button log_in_button;

    @FXML
    private ImageView log_in_image;

    @FXML
    void reservation_actions() throws IOException {
        Main m = new Main();
        m.changeScene("AdminReservationsView.fxml");
    }

    @FXML
    void users_actions() throws IOException {
        Main l = new Main();
        l.changeScene("AdminUsersView.fxml");
    }
    @FXML
    void field_programs_actions() throws IOException {
        Main l = new Main();
        l.changeScene("FieldsSelectionSchedule.fxml");
    }

    @FXML
    void log_in_button(ActionEvent event) throws IOException {
        Main log_in_button = new Main();
        log_in_button.changeScene("Login.fxml");
    }


}