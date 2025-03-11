package fr.epita.biostats.tests;

import fr.epita.biostats.datamodel.BiostatEntry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SandboxTest {

    public static void main(String[] args) throws IOException {

        List<BiostatEntry> entries = importBiostatEntriesFromCSV();


        //we want to write all the data into a new file
        //we iterate over the biostat entry list
        exportBiostatEntries(entries);


    }

    private static void exportBiostatEntries(List<BiostatEntry> entries) throws IOException {
        String csvOutput = "";
        for (BiostatEntry currentEntry : entries){
            //TODO format the entry to CSV
            csvOutput = csvOutput +
                    currentEntry.getName() +"," +
                    currentEntry.getGender() +"," +
                    currentEntry.getAge() +"," +
                    currentEntry.getHeight() +"," +
                    currentEntry.getWeight()
                    + System.lineSeparator();

        }
        Files.writeString(Path.of("biostats/output.csv"), csvOutput);
    }

    private static List<BiostatEntry> importBiostatEntriesFromCSV() throws IOException {
        List<BiostatEntry> entries = new ArrayList<>();
        List<String> lines = Files.readAllLines(Path.of("biostats/biostats.csv"));
        //for each line in lines we do the following
        for (String line : lines) {

            String[] parts = line.split(",");
            String cleanName = parts[0].replace("\"", "").strip();
            String cleanGender = parts[1].replace("\"", "").strip();
            System.out.println(cleanName);
            Integer cleanAge = Integer.parseInt(parts[2].strip());
            Integer cleanHeight = Integer.parseInt(parts[3].strip());
            Integer cleanWeight = Integer.parseInt(parts[4].strip());
            //we assign all the variables to an instance of BiostatEntry
            BiostatEntry entry = new BiostatEntry(cleanName, cleanGender, cleanAge,cleanHeight, cleanWeight);//TODO assign with the variables
            //we add the biostat entry in the list
            entries.add(entry);
        }
        return entries;
    }
}
