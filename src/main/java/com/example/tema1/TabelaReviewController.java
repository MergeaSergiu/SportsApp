/*package com.example.tema1;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import jdk.nashorn.internal.runtime.RewriteException;

public class TabelaReviewController {

    ObservableList<Review> dataList;

    @FXML
    private TableColumn<Review, String> col_review;

    @FXML
    private TableColumn<Review, String> col_username;

    @FXML
    private TextField filterField;

    @FXML
    private TableView<?> table_users;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_username;

    @FXML
    void getSelected(MouseEvent event) {

    }

    @FXML
    void search_user(KeyEvent event) {
        col_username.setCellValueFactory(new PropertyValueFactory<Review,String>("username"));
        col_review.setCellValueFactory(new PropertyValueFactory<Review,String>("Review"));


        dataList = DatabaseConnection.getDatausers();
        table_users.setItems(dataList);
        FilteredList<users> filteredData = new FilteredList<>(dataList, b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches username
                } else if (person.getReview().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches password
                }

                else
                    return false; // Does not match.
            });
        });
        SortedList<Review> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table_users.comparatorProperty());
        table_users.setItems(sortedData);
    }

}
*/