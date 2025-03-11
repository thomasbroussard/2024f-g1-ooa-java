package fr.epita.bank.datamodel;

public class Customer {
    String name;
    String address;

    @Override
    public String toString() {
        return name + "," + address;
    }

    public Customer(String newName, String newAddress) {
        this.name = newName;
        this.address = newAddress;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
