package fr.epita.bank.service;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;

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

    public void printCustomerList(List<Customer> customers){
        System.out.println("name,address");
        for (Customer customer : customers){
            System.out.println(customer);
        }
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

}
