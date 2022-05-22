package com.example.tema1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class FieldsSelectionScheduleController {

    @FXML
    private Button basketball_court_button;

    @FXML
    private Button covered_football_field_button;

    @FXML
    private Button football_field_outside_button;

    @FXML
    private Button handball_field_button;

    @FXML
    private Button tennis_court_button;

    @FXML
    void basketball_court_action(ActionEvent event) {

    }

    @FXML
    void covered_football_field_action(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("FotballFieldCover.fxml");
    }

    @FXML
    void football_field_outside_action(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("FotballFieldOutside.fxml");
    }

    @FXML
    void handball_field_action(ActionEvent event) {

    }

    @FXML
    void tennis_court_action(ActionEvent event) {

    }

}
