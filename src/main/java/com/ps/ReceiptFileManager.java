package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {
    private static final  String FILE_PATH = "receipt.csv";

    public static void saveOrderToFile(Order order) throws IOException {

        FileWriter writer = new FileWriter(FILE_PATH, true); // true = append mode
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        double total = order.getTotal();

        for (Product product : order.getItems()) {
            bufferedWriter.write(String.format("%s,%s,$%.2f,$%.2f%n",
                    timestamp,
                    product.getName(),
                    product.getPrice(),
                    total));
        }

        bufferedWriter.close();
    }
}
