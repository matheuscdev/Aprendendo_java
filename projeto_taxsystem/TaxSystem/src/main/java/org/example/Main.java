package org.example;

import org.example.entities.Company;
import org.example.entities.Individual;
import org.example.entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 1; i<=n; i++){

            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char type = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double income = sc.nextDouble();

            if (type == 'i'){
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();

                list.add(new Individual(name, income, healthExpenditures));
            }

            else if (type == 'c') {

                System.out.print("Number of employees: ");
                int employees = sc.nextInt();

                list.add(new Company(name, income, employees));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID");

        double sum = 0.0;
        for (TaxPayer x : list){
            System.out.println(x.getName()+ ": R$ " + String.format("%.2f", x.tax()));
            sum += x.tax();
        }

        System.out.println();
        System.out.println("TOTAL TAXES: R$" + String.format("%.2f",sum));

        sc.close();
    }
}