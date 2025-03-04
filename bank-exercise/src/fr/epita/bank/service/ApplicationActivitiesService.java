package fr.epita.bank.service;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;

import java.util.Scanner;

public class ApplicationActivitiesService {

    public static Customer createCustomerActivity(Scanner scanner) {
        System.out.println("Account creation, enter the customer name");
        String name = scanner.nextLine();
        System.out.println("enter the customer address");
        String address = scanner.nextLine();
        Customer customer = new Customer(name, address);
        System.out.println("you have created this user: " + customer);
        return customer;
    }

    public static void withdrawActivity(Scanner scanner, SavingsAccount savingsAccount) {
        System.out.println("enter the amount of money you want to withdraw");
        Integer withdrawAmount = Integer.parseInt(scanner.next());
        AccountService.withdrawFromAccount(savingsAccount, withdrawAmount);
    }

    public static SavingsAccount createSavingsAccountActivity(double initialBalance, Customer customer, double interestRate) {
        SavingsAccount savingsAccount = new SavingsAccount(initialBalance, customer);
        savingsAccount.setInterestRate(interestRate);
        return savingsAccount;
    }

}
