package com.ps;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {

    public static void saveOrderToFile(Order order) throws IOException {
        String fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
        FileWriter writer = new FileWriter("receipts/" + fileName);
        for (Product p : order.getItems()) {
            writer.write(p.getName() + " - $" + p.getPrice() + "\n");
        }
        writer.write("Total: $" + order.getTotal());
        writer.close();
    }
}
