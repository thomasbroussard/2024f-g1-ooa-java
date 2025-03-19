package fr.epita.biostats.tests;

import fr.epita.biostats.datamodel.BiostatEntry;
import fr.epita.biostats.service.db.BiostatDAO;
import fr.epita.biostats.service.exceptions.CreationException;

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
        try {
            dao.create(new BiostatEntry("testM", "M", 23, 170, 75));
            dao.create(new BiostatEntry("testW", "F", 25, 180, 70));
            dao.create(new BiostatEntry("testError","M", null, 10, 10 ));
        }catch (CreationException e){
            e.printStackTrace();
        }
        List<BiostatEntry> entries = dao.readAll();
        System.out.println(entries);
        List<BiostatEntry> women = dao.search(new BiostatEntry(null, "F", null, null, null));
        System.out.println(women);

    }
}
