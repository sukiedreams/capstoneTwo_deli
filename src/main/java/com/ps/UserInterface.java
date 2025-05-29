package com.ps;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);

    public void homeScreen() {
        System.out.println("Welcome to DELI-cious!\n");

        int mainMenuSelect;

        do {

            System.out.println("1. New Order");
            System.out.println("0. Exit\n");
            System.out.println("Select: ");
            mainMenuSelect = scanner.nextInt();

            switch (mainMenuSelect) {
                case 1:
                    handleNewOrder();
                    break;
                case 0:
                    System.out.println("Thank you for using DELI-cious! Goodbye...");
                    break;
                default:
                    System.out.println("Invalid selection, please try again.");
            }

        } while (mainMenuSelect != 0);
    }

    //Order menu
    private void handleNewOrder() throws IOException {
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("---Order Menu---\n");
            System.out.println("1: Add Sandwich");
            System.out.println("2: Add Drink");
            System.out.println("3: Add Chip");
            System.out.println("4: Checkout");
            System.out.println("0: Exit\n");
            System.out.println("Select: ");
            String select = scanner.nextLine();

            switch (select) {
                case "1" -> order.addItems(buildSandwich());
                case "2" -> order.addItems(buildDrink());
                case "3" -> order.addItems(chooseChip());
                case "4" -> {
                    order.printReceipt();
                    System.out.println("1: Confirm Order");
                    System.out.println("0: Cancel Order");
                    String confirm = scanner.nextLine();

                    if (confirm.equals("1")) {
                        ReceiptFileManager.saveOrderToFile(order);
                        ordering = false;
                    } else {
                        System.out.println("Order cancelled...");
                        ordering = false;
                    }
                }
                default -> System.out.println("Invalid, please try again...");
            }
        }
    }

    private Product buildSandwich() {
        System.out.println("---Make your Sandwich---\n");

        String size = chooseOption(scanner, "Choose size (4 / 8 / 12):", new String[]{"4", "8", "12"});
        String  bread = chooseOption(scanner, "Choose bread (white / wheat / rye / wrap / bagel / croissant", new String[]{"white", "wheat", "rye", "wrap", "bagel", "croissant"});
        Sandwich sandwich = new Sandwich(size, bread);

        System.out.println("Add Meats (type 'done' when finished):");
        while (true) {
            System.out.println("> ");
            String meat = scanner.nextLine().trim().toLowerCase();
            if (meat.equals("done")) break;
            sandwich.addmeat(new PremiumTop(meat));

            System.out.println("Would you like extra " + meat + "? (yes/no): ");
            if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
                sandwich.addExtraMeat(new PremiumTop(meat));
            }
        }

        System.out.println("Add Cheese (type 'done' when finished):");



    }

    private Product buildDrink() {
    }

    private Product chooseChip() {
    }


}
