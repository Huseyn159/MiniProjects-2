package FraudDetection;

import java.util.Scanner;

public class FraudMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FraudDetector fd = new FraudDetector();
      ;
        while (true) {
            System.out.println("Please enter userID (or 'exit' to stop): ");
            String uid = sc.nextLine();
            if (uid.equalsIgnoreCase("exit")) break;
            System.out.println("Enter amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();
            System.out.println("Enter location: ");
            String location = sc.nextLine();


            Transaction t = new Transaction(uid, amount, location);

            fd.addTransaction(t);

        }
        fd.checkForFraud();
    }
}
