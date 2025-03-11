package fr.epita.bank.service;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplicationActivitiesService {


    private Scanner scanner;

    public ApplicationActivitiesService(Scanner scanner){
        this.scanner = scanner;
    }


    public Customer createCustomerActivity() {
        System.out.println("Account creation, enter the customer name");
        String name = scanner.nextLine();
        System.out.println("enter the customer address");
        String address = scanner.nextLine();
        Customer customer = new Customer(name, address);
        System.out.println("you have created this user: " + customer);
        return customer;
    }

    public String buildCustomersListCSV(List<Customer> customers){
        String result = "name,address" + System.lineSeparator();
        for (Customer customer : customers){
            result = result + customer.toString() + System.lineSeparator();
        }
        return result;
    }

    public void printCustomerList(List<Customer> customers){
        System.out.println(buildCustomersListCSV(customers));
    }
    public void exportCustomerListAsCSV(List<Customer> customers) throws IOException {
        Files.writeString(Path.of("export.csv"),buildCustomersListCSV(customers));
    }


    public void withdrawActivity(SavingsAccount savingsAccount) {
        System.out.println("enter the amount of money you want to withdraw");
        Integer withdrawAmount = Integer.parseInt(scanner.next());
        AccountService.withdrawFromAccount(savingsAccount, withdrawAmount);
    }

    public SavingsAccount createSavingsAccountActivity(Customer customer) {
        System.out.println("Savings account creation");
        System.out.println("What initial balance?");
        Double initialBalance = Double.parseDouble(scanner.nextLine());
        SavingsAccount savingsAccount = new SavingsAccount(initialBalance, customer);
        System.out.println("What interest rate?");
        Double interestRate = Double.parseDouble(scanner.nextLine());
        savingsAccount.setInterestRate(interestRate);
        return savingsAccount;
    }

    public List<Customer> importCustomerListActivity() throws IOException {
        System.out.println("from what file do you want to import?");
        String fileInput = scanner.nextLine();
        return importCustomerList(fileInput);
    }

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
