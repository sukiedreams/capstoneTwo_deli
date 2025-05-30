package com.ps;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Order order;

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("Welcome to DELI-cious!\n");
            System.out.println("1. New Order");
            System.out.println("0. Exit\n");
            System.out.println("Select: ");
          String mainMenuSelect = scanner.nextLine();

          switch (mainMenuSelect) {
              case "1" -> startNewOrder();
              case "0" -> {
                  System.out.println("Exiting...");
                  running = false;
              }
              default -> System.out.println("Invalid, try again.");
          }
        }
    }

    private void startNewOrder() {
        order = new Order();
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
                    if (order.isEmpty()) {
                        System.out.println("Order is empty. Add items before checkout.");
                        break;
                    }
                    order.printOrder();
                    System.out.println("1: Confirm Order");
                    System.out.println("0: Cancel Order");
                    String confirm = scanner.nextLine();
                    if (confirm.equals("1")) {
                        ReceiptFileManager.writeReceipt(order);
                        ordering = false;
                    } else {
                        System.out.println("Order canceled.");
                        ordering = false;
                    }
                }
                default -> System.out.println("Invalid, Try again");
            }
            }
    }

    private Sandwich buildSandwich() {
        System.out.println("1: Confirm Order");

        String size = choose("Choose size (4/8/12): ", new String[]{"4", "8", "12"});
        String bread = choose("Choose the type of bread (white/wheat/rye/wrap/bagel/croissant): ", new String[]{"white", "wheat", "rye", "wrap", "bagel", "croissant"});
        Sandwich sandwich = new Sandwich(size, bread);

        System.out.println("Add Meats (type 'done' to finish)");
        System.out.println("Meats (Steak/Ham/Salami/Roast beef/Chicken/Turkey/Bacon):");
        while (true) {
            System.out.print("> ");
            String select = scanner.nextLine().trim().toLowerCase();
            if (select.equals("done")) break;
            sandwich.addMeat(new PremiumTop(select, getMeatPrice(size)));
            System.out.print("Extra " + select + "? (yes/no): ");
            if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
                sandwich.addExtraMeat(new PremiumTop(select, getExtraMeatPrice(size)));
            }
        }

        System.out.println("Add Cheese (type 'done' to finish):");
        System.out.println("Cheese (American/Provolone/Cheddar/Swiss): ");
        while (true) {
            System.out.print("> ");
            String select = scanner.nextLine().trim().toLowerCase();
            if (select.equals("done")) break;
            sandwich.addCheese(new PremiumTop(select, getCheesePrice(size)));
            System.out.print("Extra " + select + "? (yes/no)");
            if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
                sandwich.addExtraCheese(new PremiumTop(select, getExtraCheesePrice(size)));
            }
        }

        System.out.println("Add regular toppings (type 'done' to finish)");
        System.out.println("Toppings (Lettuce/Peppers/Onions/Tomatoes/Jalapenos/Cucumbers/Pickles/Guacamole/Mushrooms): ");
        while (true) {
            System.out.print("> ");
            String select = scanner.nextLine().trim();
            if (select.equalsIgnoreCase("done")) break;
            sandwich.addRegularTopping(new RegularTop(select));
        }

        System.out.println("Add sauces (type 'done' to finish)");
        System.out.println("Sauce (Mayo/Mustard/Ketchup/BBQ/Honey/Ranch/Thousand Island/Vinaigrette): ");
        while (true) {
            System.out.print("> ");
            String select = scanner.nextLine().trim();
            if (select.equalsIgnoreCase("done")) break;
            sandwich.addSauce(select);
        }

        System.out.println("Toasted? (yes/no): ");
        sandwich.setToasted(scanner.nextLine().trim().equalsIgnoreCase("yes"));
        return sandwich;
    }

    private Drink buildDrink() {
        System.out.println("---Make Drink---\n");
        String size = choose("choose size (small/medium/large): ", new String[]{"small", "medium", "large"});
        return new Drink(size);
    }

    private Chips chooseChip() {
        System.out.println("---Add Chips---\n");
        System.out.print("Enter chip flavor: ");
        String flavor = scanner.nextLine().trim();
        return new Chips(flavor);
    }

    private String choose(String prompt, String[] validOptions) {
        while (true) {
            System.out.print(prompt);
            String select = scanner.nextLine().trim().toLowerCase();
            for (String option : validOptions) {
                if (select.equals(option))
                    return select;
            }
            System.out.println("Invalid, Try again.");
        }
    }

    private double getMeatPrice(String size) {
        return switch (size) {
            case "4" -> 1.00;
            case "8" -> 2.00;
            case "12" -> 3.00;
            default -> 0.0;
        };
    }

    private double getExtraMeatPrice(String size) {
        return switch (size) {
            case "4" -> 0.50;
            case "8" -> 1.00;
            case "12" -> 1.50;
            default -> 0.0;
        };
    }

    private double getCheesePrice(String size) {
        return switch (size) {
            case "4" -> 0.75;
            case "8" -> 1.50;
            case "12" -> 2.25;
            default -> 0.0;
        };
    }

    private double getExtraCheesePrice(String size) {
        return switch (size) {
            case "4" -> 0.30;
            case "8" -> 0.60;
            case "12" -> 0.90;
            default -> 0.0;
        };
    }
}
