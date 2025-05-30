package com.ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {
    private static final String FILE_NAME = "receipt.csv";

    public static void writeReceipt(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME,true))) {
            String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyHHdd HH:mm:ss"));
            writer.write("---New Order (" + timeStamp + ")---\n");
            for (Product item : order.getItems()) {
                writer.write(item.getDetails().replace("\n", " | ") + "," + String.format("$%.2f", item.calPrice()) + "\n");
            }
            writer.write("TOTAL," + String.format("$%.2f", order.getTotal()) + "\n\n");
            System.out.println("Order saved!");
        } catch (IOException e) {
            System.out.println("ERROR, try again." + e.getMessage());
        }
    }
}
