package fr.epita.bank.tests;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.service.ApplicationActivitiesService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestPrintCustomerList {

    public static void main(String[] args) {

        ApplicationActivitiesService activities = new ApplicationActivitiesService(new Scanner(System.in));

        List<Customer> customers = List.of(
                new Customer("a", "Paris"),
                new Customer("b", "Marseille"),
                new Customer("c", "Toulouse"),
                new Customer("d", "Bordeaux"),
                new Customer("e", "Lyon")
        );
        activities.printCustomerList(customers);

    }
}
