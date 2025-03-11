package fr.epita.biostats.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SandboxTest {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Path.of("biostats/biostats.csv"));
        //for each line in lines we do the following
        String line = "\"Alex\",       \"M\",   41,       74,      170";
        String[] parts = line.split(",");
        String cleanName = parts[0].replace("\"", "").strip();
        String cleanGender = parts[1].replace("\"", "").strip();
        System.out.println(cleanName);
        Integer cleanAge = Integer.parseInt(parts[2].strip());
        Integer cleanHeight = Integer.parseInt(parts[3].strip());
        Integer cleanWeight = Integer.parseInt(parts[4].strip());
        System.out.println(cleanAge);

        //we assign all the variables to an instance of BiostatEntry
        //we add the biostat entry in the list
        //we want to write all the data into a new file
        //we iterate over the biostat entry list
        //for each element, we write the csv output corresponding to the entry

    }
}
