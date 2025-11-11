package ShoppingCart;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> cart = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        double max = 0;
        String expPr = null;
        double total = 0;

        while (true) {
            System.out.print("Enter product name (or 'done' to close cart): ");
            String pn = sc.nextLine();

            if (pn.equalsIgnoreCase("done")) {
                System.out.println("\n🛒 Shopping finished.\n");
                break;
            }

            System.out.print("Enter product price: ");
            double pp = sc.nextDouble();
            sc.nextLine();

            if (pp < 0) {
                System.out.println("⚠️ Price cannot be negative! Try again.");
                continue;
            }

            cart.put(pn, pp);
        }

        System.out.println("📦 Your cart items:");
        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            System.out.println("→ " + entry.getKey() + " | " + entry.getValue() + " AZN");
            total += entry.getValue();

            if (entry.getValue() > max) {
                max = entry.getValue();
                expPr = entry.getKey();
            }
        }

        System.out.println("\n💰 Total amount: " + total + " AZN");
        System.out.println("🏆 Most expensive product: " + expPr + " (" + max + " AZN)");
    }
}
