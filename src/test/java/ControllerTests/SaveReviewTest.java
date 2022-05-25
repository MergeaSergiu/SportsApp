/*package ControllerTests;

import com.example.tema1.DatabaseConnection;
import com.example.tema1.SaveReservation;
import com.example.tema1.SaveReview;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class SaveReviewTest {

    @BeforeAll
    static void beforeALL() {
        DatabaseConnection.getConnection();
    }

    @Test
    void addReview() throws SQLException {
        String username = "mergeamihai@yahoo.com";
        String Review = "Nu mi-a placut";
        SaveReview.addReview(username,Review);
        PreparedStatement statement;
        statement =DatabaseConnection.getConnection().prepareStatement("SELECT * from review2 where username = 'mergeamihai@yahoo.com'");
        ResultSet resultSet = statement.executeQuery();
        Assertions.assertNotNull(resultSet.next());
    }

    @Test
    void validateUser() throws SQLException {

        SaveReview.validateUser("mergeamihai@yahoo.com");
        Assertions.assertTrue(SaveReview.validateUser("mergeamihai@yahoo.com"));

    }
}


 */


