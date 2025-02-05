package fr.epita.bank.datamodel;

public class Account {
    public double balance;
    Customer customer;

    public Account(Double balance, Customer customer) {
        this.balance = balance;
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0){
            // show warning
        } else {
            this.balance = balance;
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
