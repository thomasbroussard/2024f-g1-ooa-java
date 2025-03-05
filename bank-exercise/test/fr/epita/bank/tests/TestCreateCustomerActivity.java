package fr.epita.bank.tests;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.service.ApplicationActivitiesService;

import java.util.Scanner;

public class TestCreateCustomerActivity {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApplicationActivitiesService activities = new ApplicationActivitiesService(scanner);
        Customer customer = activities.createCustomerActivity();

    }


}
