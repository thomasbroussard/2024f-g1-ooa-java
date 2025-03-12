package fr.epita.biostats.service;

import fr.epita.biostats.datamodel.BiostatEntry;

import java.time.Year;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BiostatDataService {


    public int averageAge(List<BiostatEntry> entries){
        return Double.valueOf(entries.stream()
                .mapToInt(BiostatEntry::getAge)
                .average()
                .getAsDouble())
                .intValue();
    }

    public List<BiostatEntry> filter(List<BiostatEntry> toBeFiltered, int threshold){
        return toBeFiltered.stream()
                .filter(e -> e.getAge() > threshold)
                .toList();
    }

    /**
     * this method calculates etc.
     * @param entry
     * @return
     */
    public int calculatYearOfBirth(BiostatEntry entry){
        return Year.now().getValue() - entry.getAge();
    }

    public Map<String, Long> computeDistributionOverGender(List<BiostatEntry> entries){
        if (entries == null){
            return new HashMap<>();
        }

        return entries
                .stream()
                .collect(Collectors.groupingBy(BiostatEntry::getGender, Collectors.counting()));

    }
}
