package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        ProductManagement productManagement = new ProductManagement();
        productManagement.products = readFile("product.txt");
        do{
            menu();
            System.out.println("Enter your choice");
            choice = input.nextInt();
            switch (choice){
                case 1:{
                    System.out.println("Product list as below:");
                    if(productManagement.size() == 0) {
                        System.out.println("No product to show");
                    } else {
                        productManagement.display();
                    }
                    break;
                }
                case 2: {
                    System.out.println("You want to add a new product? Input information below:");
                    input.nextLine();
                    Product product = getProduct(input);
                    productManagement.add(product);
                    writeToFile("product.txt",productManagement.products);
                    break;
                }
                case 3: {
                    System.out.println("Input the code you want to find:");
                    String code = input.nextLine();
                    int index = productManagement.indexFindByCode("code");
                    if(index == -1){
                        System.out.println("Code not valid");
                    } else {
                        System.out.println("The product info is " + productManagement.products.get(index));
                    }
                    break;
                }
            }
        } while (choice != -1);
    }

    private static Product getProduct(Scanner input) {
        System.out.println("Input code");
        String code = input.nextLine();
        System.out.println("Input name");
        String name = input.nextLine();
        System.out.println("Input manufacturer");
        String manufacturer = input.nextLine();
        System.out.println("Input the price");
        double price = input.nextDouble();
        Product product = new Product(code, name, manufacturer, price);
        return product;
    }

    private static void menu() {
        System.out.println("---Menu---");
        System.out.println("1. Display all products");
        System.out.println("2. Add a new products to the list");
        System.out.println("3. Find a product by code");
    }

    public static void writeToFile(String path, List<Product> products) {
        try {
            OutputStream os = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Product> readFile(String path) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            InputStream is = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(is);
            products = (ArrayList<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }
}
