package org.example;

import org.example.models.entities.Account;
import org.example.models.exception.DomainException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            sc.next();
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            double initialBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account ac = new Account(number, holder, initialBalance, withdrawLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            double amount = sc.nextDouble();
            ac.withdraw(amount);
            System.out.println("New balance: " + String.format("%.2f", ac.getBalance()));
        }
        catch (DomainException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }
        sc.close();
    }
}