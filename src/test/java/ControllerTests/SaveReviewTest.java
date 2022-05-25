/*package ControllerTests;

import com.example.tema1.DatabaseConnection;

import com.example.tema1.SaveReview;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class SaveReviewTest {

    @BeforeAll
    static void beforeAll(){
        DatabaseConnection.getConnection();
    }


    @Test
    void addReviewTest() throws SQLException {
        String username = "mergeamihai@yahoo.com";
        String Review = "Nu mi-a placut";
        SaveReview.addReview(username,Review);
        PreparedStatement statement;
        statement =DatabaseConnection.getConnection().prepareStatement("SELECT * from review2 where username = username, Review = Review");
        ResultSet resultSet = statement.executeQuery();
        Assertions.assertNotNull(resultSet.next());

    }

    @Test
    void validateUserTest() throws SQLException {


            SaveReview.validateUser("mergeamihai@yahoo.com");
            Assertions.assertTrue(SaveReview.validateUser("mergeamihai@yahoo.com"));


    }
}
*/
