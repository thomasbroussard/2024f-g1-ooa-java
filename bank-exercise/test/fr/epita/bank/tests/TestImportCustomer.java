package fr.epita.bank.tests;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.service.ApplicationActivitiesService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class TestImportCustomer {

    public static void main(String[] args) throws IOException {
        //TODO create the export.csv file before so that this test is isolated and repeatable

        String sampleCSV = "name,address\n" +
                "abc,def";
        Files.writeString(Path.of("export.csv"), sampleCSV);

        ApplicationActivitiesService activitiesService = new ApplicationActivitiesService(new Scanner(System.in));
        List<Customer> customers = activitiesService.importCustomerList();
        System.out.println(customers);
        if (customers.get(0).getName().equals("abc")){
            System.out.println("success");
        }else{
            throw new IllegalStateException("values were not matching");
        }
    }
}
