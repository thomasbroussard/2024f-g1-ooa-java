package fr.epita.bank.datamodel;

public class SavingsAccount extends Account{
    Double interestRate;

    public SavingsAccount(Double balance, Customer customer) {
        super(balance, customer);
    }
}
