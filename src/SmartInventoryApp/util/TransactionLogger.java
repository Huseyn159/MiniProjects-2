package SmartInventoryApp.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionLogger {
    private static final String FILE_NAME ="transactions.txt";
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static  void  log(String message){
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String logEntry = String.format("[%s] %s", timestamp, message);
        System.out.println(logEntry);


        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME,true))){
            writer.write(logEntry + "\n");
        }catch (IOException e){
            System.out.println("[ERROR] Could not write log:" + e.getMessage());
        }
    }
}
