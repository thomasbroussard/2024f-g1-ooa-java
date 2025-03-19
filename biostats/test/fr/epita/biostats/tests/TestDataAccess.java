package fr.epita.biostats.tests;

import fr.epita.biostats.datamodel.BiostatEntry;
import fr.epita.biostats.service.db.BiostatDAO;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class TestDataAccess {


    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:testInstance", "test", "test");

        //should be "PUBLIC"
        String schema = connection.getSchema();
        System.out.println("schema: " + schema);
        connection.close();

        BiostatDAO dao = new BiostatDAO();
        dao.create(new BiostatEntry("testM", "M", 23, 170, 75));
        dao.create(new BiostatEntry("testW", "F", 25, 180, 70));
        List<BiostatEntry> entries = dao.readAll();
        System.out.println(entries);
        List<BiostatEntry> women = dao.search(new BiostatEntry(null, "F", null, null, null));
        System.out.println(women);

    }
}
