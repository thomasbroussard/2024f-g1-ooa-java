package fr.epita.biostats.service.db;

import fr.epita.biostats.datamodel.BiostatEntry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BiostatDAO {

    public BiostatDAO() throws SQLException {
        String createTable = """
                CREATE IF NOT EXISTS TABLE BIOSTATS (
                    NAME VARCHAR(255),
                    SEX CHAR,
                    AGE INT,
                    HEIGHT INT,
                    WEIGHT INT 
                ) 
                """;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(createTable);
        preparedStatement.execute();
        connection.close();
    }

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:testInstance", "test", "test");
        return connection;
    }

    public void create(BiostatEntry entry) throws SQLException {
        String sqlInsert = """
                INSERT INTO BIOSTATS (
                    NAME,   SEX,    AGE,    HEIGHT, WEIGHT                  
                ) VALUES (
                    ?,      ?,      ?,          ?,      ?    
                )
                """;
        Connection connection = getConnection();
        PreparedStatement insertStatement = connection.prepareStatement(sqlInsert);
        insertStatement.setString(1,entry.getName());
        insertStatement.setString(2, entry.getGender());
        insertStatement.setInt(3, entry.getAge());
        insertStatement.setInt(4, entry.getHeight());
        insertStatement.setInt(5, entry.getWeight());
        insertStatement.execute();

        connection.close();
    }




}
