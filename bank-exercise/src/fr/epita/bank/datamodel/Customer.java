package fr.epita.bank.datamodel;

public class Customer {
    String name;
    String address;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Customer(String newName, String newAddress) {
        this.name = newName;
        this.address = newAddress;
    }


}
