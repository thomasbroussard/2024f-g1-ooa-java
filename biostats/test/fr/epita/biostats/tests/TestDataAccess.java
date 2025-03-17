package fr.epita.biostats.tests;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDataAccess {


    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:testInstance", "test", "test");

        //should be "PUBLIC"
        String schema = connection.getSchema();

        System.out.println("schema: " + schema);

        connection.close();
    }
}
