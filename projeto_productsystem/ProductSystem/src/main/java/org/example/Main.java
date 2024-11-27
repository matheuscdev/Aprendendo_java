package org.example;

import org.example.entities.ImportedProduct;
import org.example.entities.Product;
import org.example.entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i<=n; i++){

            System.out.println("Product #" + i + " data: ");
            System.out.print("Common, used, imported (c/u/i)? ");
            char typeOfProduct = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            if (typeOfProduct == 'i'){
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();

                Product product = new ImportedProduct(name, price, customsFee);
                list.add(product);
            }

            else if (typeOfProduct == 'u') {
                System.out.print("Manufacture date (DD/MM//YYYY): ");
                Date date = sdf.parse(sc.next());
                Product product = new UsedProduct(name, price, date);
                list.add(product);
            }

            else {
                Product product = new Product(name, price);
                list.add(product);
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS: ");

        for (Product x : list){
            System.out.println(x.priceTag());
        }

        sc.close();
    }
}