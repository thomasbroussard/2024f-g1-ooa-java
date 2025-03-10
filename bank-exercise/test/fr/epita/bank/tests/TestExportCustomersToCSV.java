package fr.epita.bank.tests;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.service.ApplicationActivitiesService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestExportCustomersToCSV {

    public static void main(String[] args) throws IOException {

        //as an output I should have a file with CSV format created and corresponding to the customers data
        List<Customer> customers = List.of(
                new Customer("a", "Paris"),
                new Customer("b", "Marseille"),
                new Customer("c", "Toulouse"),
                new Customer("d", "Bordeaux"),
                new Customer("e", "Lyon")
        );
        ApplicationActivitiesService activitiesService = new ApplicationActivitiesService(new Scanner(System.in));
        String csvContent = activitiesService.buildCustomersListCSV(customers);
        Files.writeString(Path.of("export.csv"), csvContent);


    }
}
