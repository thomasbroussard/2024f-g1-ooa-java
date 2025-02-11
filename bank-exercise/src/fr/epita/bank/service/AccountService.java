package fr.epita.bank.service;

import fr.epita.bank.datamodel.SavingsAccount;

public class AccountService {
  public   static void creditInterest(SavingsAccount savingsAccount) {
        Double gain = savingsAccount.getBalance() * savingsAccount.getInterestRate();
        savingsAccount.setBalance(savingsAccount.getBalance() + gain);
    }

   public static void withdrawFromAccount(SavingsAccount savingsAccount, Integer val) {
        if (savingsAccount.getBalance() - val < 0) {
            System.out.println("the balance is insufficient : actual balance = " + savingsAccount.getBalance() + " requested : " + val  );
        } else {
            savingsAccount.setBalance(savingsAccount.getBalance() - val);
        }
    }
}