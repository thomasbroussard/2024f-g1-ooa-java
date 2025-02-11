package fr.epita.bank.launcher;

import java.util.Scanner;

public class CustomerManagementLauncher {

    public static void main(String[] args) {
        System.out.println("Welcome to this bank application");
        System.out.println("What would you like to do?");
        System.out.println("1. create customer");
        System.out.println("2. withdraw amount from an account");
        System.out.println("3. quit the program");
        System.out.println("type your option (1 or 2 or 3)");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        if ("1".equals(option)){

        } else if ("2".equals(option)) {

        } else if ("3".equals(option)) {

        }else {
            System.out.println("unrecognized option");
        }

    }
}
