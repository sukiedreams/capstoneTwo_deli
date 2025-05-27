package com.ps;

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
    private void handleNewOrder() {
        Order order = new Order();
        System.out.println("---Order Menu---\n");
        int orderMenuSelect;

        do {
            System.out.println("1. Add Sandwich");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chip");
            System.out.println("4. Remove an item");
            System.out.println("5. Checkout\n");
            System.out.println("Select");
            orderMenuSelect = scanner.nextInt();

            switch (orderMenuSelect) {
                case 1:
                    buildSandwich();
                    break;
                case 2:
                    buildDrink();
                    break;
                case 3:
                    chooseChip();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    cartCheckout();
                    break;
                default:
                    System.out.println("Invalid selection, please try again.");
            }
        } while (orderMenuSelect != 0);
    }

    private void buildSandwich() {
        System.out.println("---Make Your Sandwich---\n");

        System.out.println("Bread: White, Wheat, Rye, Wrap, Bagel, or Croissant.");
        String bread = scanner.nextLine();

        System.out.println("Size of Sandwich: 4, 8, 12.");
        int size = Integer.parseInt(scanner.nextLine());

        System.out.println("Would you like it Toasted? Yes/No: ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        while (true) {

        }
        sandwich.addTopping(topping);

    }

    private void buildDrink() {
        System.out.println("---Drinks---\n");

        System.out.println("Drink Flavor: ");
        String flavor = scanner.nextLine();

        System.out.println("Size: small, medium, large.");
        String size = scanner.nextLine();

        return new Drink(flavor, size);
    }

    private Chips chooseChip() {
        System.out.println("---Chips---\n");

        System.out.println("Chip type: ");
        String type = scanner.nextLine();

        return new Chips(type);
    }

    private void removeItem() {
        //TODO come back to this.
    }

    private void cartCheckout() {
        // okay here will be for, if/else, try/catch.
        // to cancel order.
        //TODO come back to this.
    }

}
