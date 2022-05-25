package ControllerTests;

import com.example.tema1.DatabaseConnection;
import com.example.tema1.SaveReservation;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class SaveReservationTest {


    @BeforeAll
    static void beforeAll(){
        DatabaseConnection.getConnection();
    }



    @Test
    public void addReservationTest() throws SQLException{

        java.sql.Date d1 = new java.sql.Date(2022,10,10);
        SaveReservation.addReservation("mergeamihai@yahoo.com",d1,"10-11","TRUE","Teren_Fotbal_Afara");
        PreparedStatement statement;
        statement = DatabaseConnection.getConnection().prepareStatement("SELECT * from reservation2 WHERE username = 'mergeamihai@yahoo.com' ");
        ResultSet resultSet = statement.executeQuery();
        Assertions.assertNotNull(resultSet.next());

    }

    @Test
    public void ValidateUserTest() throws SQLException{

        SaveReservation.validateUser("mergeamihai@yahoo.com");
        Assertions.assertTrue(SaveReservation.validateUser("mergeamihai@yahoo.com"));

    }

    @Test
    public void ValidateReservationTest() throws SQLException{

        java.sql.Date d1 = new java.sql.Date(2024,03,11);
        SaveReservation.validateReservation(d1,"8-9","Teren_Baschet");
        Assertions.assertFalse(SaveReservation.validateReservation(d1,"8-9","Teren_Baschet"));

    }


}