package com.ps;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);

    public void run() {
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

    private void handleNewOrder() {
        Order order = new Order();
        System.out.println("---Order Menu---\n");
        int orderMenuSelect;

        do {

        } while ();
    }

}
