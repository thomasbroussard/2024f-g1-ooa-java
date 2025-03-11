package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;
import fr.epita.bank.service.ApplicationActivitiesService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerManagementLauncher {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to this bank application");
        //from here
        String option = "";
        List<Customer> customerList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        ApplicationActivitiesService activitiesService = new ApplicationActivitiesService(scanner);
        List<SavingsAccount> savingsAccountList = new LinkedList<>();
        do {
            System.out.println("What would you like to do?");
            System.out.println("1. create customer");
            System.out.println("2. withdraw amount from an account");
            System.out.println("3. print the list of customers");
            System.out.println("4. export the list of customers to a CSV file");

            System.out.println("9. quit the program");
            System.out.println("type your option (1 or 2 or 9)");

            option = scanner.nextLine();
            if ("1".equals(option)) {
                Customer customer = activitiesService.createCustomerActivity();
                SavingsAccount savingsAccount = activitiesService.createSavingsAccountActivity(customer);
                customerList.add(customer);
                savingsAccountList.add(savingsAccount);
            } else if ("2".equals(option)) {

            } else if ("3".equals(option)) {

                System.out.println("Here is the list of customers");
                activitiesService.printCustomerList(customerList);
            } else if ("4".equals(option)) {

                System.out.println("About to export customers data");
                activitiesService.exportCustomerListAsCSV(customerList);
            } else if ("5".equals(option)) {
                System.out.println("About to import customers data");
                customerList = activitiesService.importCustomerListActivity();
            } else {
                System.out.println("unrecognized option");
            }
        }while (!"9".equals(option));


    }
}
