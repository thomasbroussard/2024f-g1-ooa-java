package fr.epita.biostats.service.db;

import fr.epita.biostats.datamodel.BiostatEntry;
import fr.epita.biostats.service.ConfigurationService;
import fr.epita.biostats.service.exceptions.CreationException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BiostatDAO {

    ConfigurationService conf;
    public BiostatDAO() throws SQLException, IOException {
        conf = new ConfigurationService();
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
         Connection connection = DriverManager.getConnection(
                conf.getProperty("db.url"),
                conf.getProperty("db.user"),
                conf.getProperty("db.pwd")
        );
        return connection;
    }

    public void create(BiostatEntry entry) throws CreationException {
        String sqlInsert = """
                INSERT INTO BIOSTATS (
                    NAME,   SEX,    AGE,    HEIGHT, WEIGHT                  
                ) VALUES (
                    ?,      ?,      ?,          ?,      ?    
                )
                """;
        try (Connection connection = getConnection()) {
            PreparedStatement insertStatement = connection.prepareStatement(sqlInsert);
            insertStatement.setString(1, entry.getName());
            insertStatement.setString(2, entry.getGender());
            insertStatement.setInt(3, entry.getAge());
            insertStatement.setInt(4, entry.getHeight());
            insertStatement.setInt(5, entry.getWeight());
            insertStatement.execute();
        } catch (Exception sqle){
            CreationException creationException = new CreationException();
            creationException.initCause(sqle);
            throw creationException;

        }


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

    public void delete(BiostatEntry entry) throws SQLException {
        String deleteSQL = """
                DELETE FROM BIOSTATS
                    WHERE NAME = ?      
                """;
        Connection connection = getConnection();
        PreparedStatement deleteStatement = connection.prepareStatement(deleteSQL);
        deleteStatement.setString(1,entry.getName());
        deleteStatement.execute();
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

    public List<BiostatEntry> search(BiostatEntry qube) throws SQLException {
        List<BiostatEntry> entries = new ArrayList<>();
        String sqlSelect = """
                SELECT * FROM BIOSTATS
                WHERE 
                    (? is null OR NAME LIKE ?)
                AND (? is null OR ? = SEX)
                AND (? is null OR AGE = ?)
                AND (? is null OR HEIGHT = ?)
                AND (? is null OR WEIGHT = ?)
            
                """;
        Connection connection = getConnection();
        PreparedStatement searchStatement = connection.prepareStatement(sqlSelect);
        searchStatement.setString(1, qube.getName());
        searchStatement.setString(2, String.valueOf(qube.getName()) +"%");
        searchStatement.setString(3, qube.getGender());
        searchStatement.setString(4, qube.getGender());
        searchStatement.setObject(5, qube.getAge(), JDBCType.INTEGER);
        searchStatement.setObject(6, qube.getAge(), JDBCType.INTEGER);
        searchStatement.setObject(7, qube.getHeight(), JDBCType.INTEGER);
        searchStatement.setObject(8, qube.getHeight(), JDBCType.INTEGER);
        searchStatement.setObject(9, qube.getWeight(), JDBCType.INTEGER);
        searchStatement.setObject(10, qube.getWeight(), JDBCType.INTEGER);
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
