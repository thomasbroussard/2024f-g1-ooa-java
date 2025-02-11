package fr.epita.bank.datamodel;

public class Account {
    double balance;
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
            //
        } else {
            if (this.balance - balance < 0){
                System.out.println("the balance is insufficient");
            }else {
                this.balance = balance;
            }
        }

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
