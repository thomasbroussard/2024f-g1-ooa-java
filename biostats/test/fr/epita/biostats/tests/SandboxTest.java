package fr.epita.biostats.tests;

import fr.epita.biostats.datamodel.BiostatEntry;
import fr.epita.biostats.service.BiostatCSVService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Year;
import java.time.temporal.TemporalField;
import java.util.*;
import java.util.stream.Collectors;

public class SandboxTest {

    public static void main(String[] args) throws IOException {

        List<BiostatEntry> entries = importBiostatEntriesFromCSV();

        BiostatCSVService csvService = new BiostatCSVService();
        csvService.exportBiostatEntries(entries);

        //we want to write all the data into a new file
        //we iterate over the biostat entry list
        csvService.exportBiostatEntries(entries);

        Double average = 0.0;
        for (BiostatEntry entry: entries){
            average += entry.getAge();
        }
        average = average / entries.size();
        System.out.println(average);

        average =  entries.stream()
                .mapToInt(BiostatEntry::getAge)
                .average()
                .getAsDouble();

        List<BiostatEntry> filteredList = new ArrayList<>();
        Integer threshold = 20;
        for (BiostatEntry entry : entries){
            if (entry.getAge() > threshold){
                filteredList.add(entry);
            }
        }
        //return filteredList
        //stream version of the same
        filteredList = entries.stream()
                .filter(e -> e.getAge() > threshold)
                .toList();

        BiostatEntry entry = entries.get(0);
        Integer entryBirthYear =
                Calendar.getInstance().get(Calendar.YEAR) - entry.getAge();

        entryBirthYear = Year.now().getValue() - entry.getAge();
        //return entryBirthYear

        Integer fCounter = 0;
        Integer mCounter = 0;
        for (BiostatEntry biostatEntry : entries){
            String gender = biostatEntry.getGender();
            if ("M".equals(gender)){
                mCounter ++;
            } else if ("F".equals(gender)){
                fCounter ++;
            } else {
                System.out.println("unknown value : "  + gender );
            }
        }

        Map<String, Integer> genderDistribution = new HashMap<>();
        for (BiostatEntry biostatEntry : entries){
            Integer currentCount = genderDistribution
                    .getOrDefault(biostatEntry.getGender(), 0);
            genderDistribution.put(biostatEntry.getGender(),currentCount + 1);
        }
        System.out.println(genderDistribution);

        Map<String, Long> distributionOverGender = entries
                .stream()
                .collect(Collectors.groupingBy(BiostatEntry::getGender, Collectors.counting()));



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
