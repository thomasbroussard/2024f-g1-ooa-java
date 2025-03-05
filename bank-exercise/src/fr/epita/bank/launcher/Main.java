package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;
import fr.epita.bank.service.AccountService;
import fr.epita.bank.service.ApplicationActivitiesService;

import java.util.Scanner;

import static fr.epita.bank.service.ApplicationActivitiesService.*;


public class Main {

    public static void main(String[] args) {
        // 1.create a customer named customer
        // 2. assign to this customer a savings account initialized with 500€
        // 3. calculate the yearly gain linked to the interest rate
        // 4. add the gain to the savings balance
        // 5. the customer wants to withdraw 300€ then 500€, if the balance is
        // insufficient, then it should print a warning
        ApplicationActivitiesService activitiesService = new ApplicationActivitiesService(new Scanner(System.in));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to this bank application");
        Customer customer = activitiesService.createCustomerActivity();
        double interestRate = 0.025;
        double initialBalance = 500.0;
        SavingsAccount savingsAccount = activitiesService.createSavingsAccountActivity(customer);
        AccountService.creditInterest(savingsAccount);

        //5.

        // trigger withdraw activity
        activitiesService.withdrawActivity(savingsAccount);


    }



}
