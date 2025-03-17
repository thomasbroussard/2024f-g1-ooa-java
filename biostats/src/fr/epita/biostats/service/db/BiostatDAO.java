package fr.epita.biostats.service.db;

import fr.epita.biostats.datamodel.BiostatEntry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BiostatDAO {

    public BiostatDAO() throws SQLException {
        String createTable = """
                CREATE TABLE IF NOT EXISTS BIOSTATS (
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
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:testInstance;DB_CLOSE_DELAY=-1", "test", "test");
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
    public void update(BiostatEntry entry) throws SQLException {
        String sqlUpdate = """
                UPDATE BIOSTATS SET
                    SEX = ?,
                    AGE = ?,
                    HEIGHT=?,
                    WEIGHT=?
                    WHERE NAME = ?      
                """;
        Connection connection = getConnection();
        PreparedStatement updateStatement = connection.prepareStatement(sqlUpdate);
        updateStatement.setString(5,entry.getName());
        updateStatement.setString(1, entry.getGender());
        updateStatement.setInt(2, entry.getAge());
        updateStatement.setInt(3, entry.getHeight());
        updateStatement.setInt(4, entry.getWeight());
        updateStatement.execute();

        connection.close();
    }

    public List<BiostatEntry> readAll() throws SQLException {
        List<BiostatEntry> entries = new ArrayList<>();
        String sqlSelect = """
                SELECT * FROM BIOSTATS
                """;
        Connection connection = getConnection();
        PreparedStatement searchStatement = connection.prepareStatement(sqlSelect);
        ResultSet resultSet = searchStatement.executeQuery();
        while (resultSet.next()){
            String name = resultSet.getString("NAME");
            String sex = resultSet.getString("SEX");
            Integer age = resultSet.getInt("AGE");
            Integer height = resultSet.getInt("HEIGHT");
            Integer weight = resultSet.getInt("WEIGHT");

            BiostatEntry entry = new BiostatEntry(name, sex, age ,height, weight);
            entries.add(entry);
        }
        return entries;
    }





}
