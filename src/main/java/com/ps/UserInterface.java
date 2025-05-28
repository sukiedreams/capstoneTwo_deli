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
                    cartCheckout(order);
                    break;
                default:
                    System.out.println("Invalid selection, please try again.");
            }
        } while (orderMenuSelect != 0);
    }

    private Sandwich buildSandwich() {
        System.out.println("---Make Your Sandwich---\n");

        System.out.println("Bread: White, Wheat, Rye, Wrap, Bagel, or Croissant.");
        String bread = scanner.nextLine();

        System.out.println("Size of Sandwich: 4, 8, 12.");
        int size = Integer.parseInt(scanner.nextLine());

        System.out.println("Would you like it Toasted? Yes/No: ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        while (true) {
            System.out.println("Add Toppings (type 'Done' when finished): ");
            System.out.println("Topping name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done"))
                break;
            System.out.println("Type (Regular/Premium): ");
            String type = scanner.nextLine();

            System.out.println("Extra? Yes/No: ");
            boolean isExtra = scanner.nextLine().equalsIgnoreCase("yes");

            Topping topping;
            if (type.equalsIgnoreCase("regular")) {
                topping = new RegularTop(name, isExtra);
            } else {
                topping = new PremiumTop(name, isExtra);
            }
            sandwich.addTopping(topping);
        }
        return sandwich;


    }

    private Drink buildDrink() {
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

    private void cartCheckout(Order order) {

        while (true) {
            System.out.println("--Your Cart--\n");
            List<Product> items = order.getItems();

            for (int i = 0; i < items.size(); i++) {
                Product product = items.get(i);
                System.out.printf("%d) %s - $%2f%n", i + 1, product.getName(), product.getPrice());
            }
            System.out.printf("Total: $%.2f%n", order.getTotal());

            System.out.println("1) Confirm Order");
            System.out.println("2) Remove Item");
            System.out.println("3) Cancel Order");
            System.out.println("0) Back to Order Menu\n");
            System.out.println("Select: ");
            String cartSelection = scanner.nextLine();

            switch (cartSelection) {
                case "1":
                    try {
                        ReceiptFileManager.saveOrderToFile(order);
                        System.out.println("Receipt saved!");
                    } catch (IOException e) {
                        System.out.println("Error saving receipt, please try again.");
                    }
                    return;

                case "2":
                    System.out.println("---What would like to remove?---\n");
                    System.out.println("Enter name of item to remove: ");
                    String nameToRemove = scanner.nextLine();
                    boolean found = false;

                    for (int i = 0; i < items.size(); i++) {
                        if (items.get(i).getName().equalsIgnoreCase(nameToRemove)) {
                            Product removed = items.remove(i);
                            System.out.println("Removed: " + removed.getName());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No matching items found, please try again.");
                    }
                    break;

                case "3":
                    System.out.println("Your order has been canceled.");
                    order.getItems().clear();
                    return;

                case "0":
                    System.out.println("Going back to the Order Menu...");
                    return;

                default:
                    System.out.println("Invalid, try again.");
            }

        }

    }
}
