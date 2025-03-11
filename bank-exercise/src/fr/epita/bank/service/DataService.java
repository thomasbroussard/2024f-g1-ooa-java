package fr.epita.bank.service;

import fr.epita.bank.datamodel.Customer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DataService {

    public List<Customer> importCustomerList(String fileInput) throws IOException {

        List<String> lines = Files.readAllLines(Path.of(fileInput));

        List<Customer> customers = new ArrayList<>();
        lines.remove(0);//headers
        for (String line : lines){
            String[] parts = line.split(",");
            Customer customer = new Customer(parts[0], parts[1]);
            customers.add(customer);
        }
        return customers;
    }
}
