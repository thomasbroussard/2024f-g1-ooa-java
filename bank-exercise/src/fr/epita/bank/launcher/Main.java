package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;
import fr.epita.bank.service.AccountService;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // 1.create a customer named customer
        // 2. assign to this customer a savings account initialized with 500€
        // 3. calculate the yearly gain linked to the interest rate
        // 4. add the gain to the savings balance
        // 5. the customer wants to withdraw 300€ then 500€, if the balance is
        // insufficient, then it should print a warning
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to this bank application");

        System.out.println("Account creation, enter the customer name");
        String name = scanner.nextLine();
        System.out.println(" enter the customer address");
        String address = scanner.nextLine();
        Customer customer = new Customer(name,address);
        System.out.println("you have created this user: " + customer);

        SavingsAccount savingsAccount = new SavingsAccount(500.0, customer);
        AccountService.creditInterest(savingsAccount);

        //5.

        // try to withdraw
        AccountService.withdrawFromAccount(savingsAccount, 300);
        AccountService.withdrawFromAccount(savingsAccount, 500);


        savingsAccount.setBalance(savingsAccount.getBalance() - 300);




    }

}
