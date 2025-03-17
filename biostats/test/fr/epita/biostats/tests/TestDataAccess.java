package fr.epita.biostats.tests;

import fr.epita.biostats.datamodel.BiostatEntry;
import fr.epita.biostats.service.db.BiostatDAO;

import java.sql.*;
import java.util.List;

public class TestDataAccess {


    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:testInstance", "test", "test");

        //should be "PUBLIC"
        String schema = connection.getSchema();
        System.out.println("schema: " + schema);
        connection.close();

        BiostatDAO dao = new BiostatDAO();
        dao.create(new BiostatEntry("test", "M", 23, 170, 75));
        List<BiostatEntry> entries = dao.readAll();

    }
}
