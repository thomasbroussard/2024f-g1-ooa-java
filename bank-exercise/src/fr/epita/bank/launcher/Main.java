package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;

public class Main {

    public static void main(String[] args) {
        // 1.create a customer named quentin
        // 2. assign to this customer a savings account initialized with 500€
        // 3. calculate the yearly gain linked to the interest rate
        // 4. add the gain to the savings balance
        // 5. the customer wants to withdraw 300€ then 500€, if the balance is
        // insufficient, then it should print a warning

        Customer quentin = new Customer("quentin", "paris");
        SavingsAccount savingsAccount = new SavingsAccount(500.0, quentin);
        Double gain = savingsAccount.balance * savingsAccount.interestRate;




    }
}
