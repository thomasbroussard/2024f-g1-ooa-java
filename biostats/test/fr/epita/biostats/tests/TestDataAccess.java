package fr.epita.biostats.tests;

import java.sql.*;

public class TestDataAccess {


    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:testInstance", "test", "test");

        //should be "PUBLIC"
        String schema = connection.getSchema();

        System.out.println("schema: " + schema);

        String createTable = """
                CREATE TABLE BIOSTATS (
                    NAME VARCHAR(255),
                    SEX CHAR,
                    AGE INT,
                    HEIGHT INT,
                    WEIGHT INT 
                ) 
                """;

        PreparedStatement preparedStatement = connection.prepareStatement(createTable);
        preparedStatement.execute();

        String sqlInsert = """
                INSERT INTO BIOSTATS (
                    NAME, SEX, AGE, HEIGHT, WEIGHT                  
                ) VALUES (
                   'test', 'M', 23, 170, 73       
                )
                """;
        PreparedStatement insertStatement = connection.prepareStatement(sqlInsert);
        insertStatement.execute();

        String sqlSelect = """
                SELECT * FROM BIOSTATS
                """;

        PreparedStatement searchStatement = connection.prepareStatement(sqlSelect);
        ResultSet resultSet = searchStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("NAME"));
        }

        connection.close();
    }
}
