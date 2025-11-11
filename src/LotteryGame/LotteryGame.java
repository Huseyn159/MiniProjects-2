package LotteryGame;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LotteryGame {
    public static void main(String[] args) {
        Set<Integer> userNumbers = new HashSet<>();
        Set<Integer> winningNumbers = new HashSet<>();
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        while(true) {
            while (winningNumbers.size() < 6) {
                winningNumbers.add(rnd.nextInt(49) + 1);
            }
            while (userNumbers.size() < 6) {
                int count = 1;
                System.out.println("Enter numbers between 1-49: ");
                int num = sc.nextInt();
                sc.nextLine();
                if (num < 1 || num > 49) {
                    System.out.println("Invalid number! Must be between 1–49.");
                } else if (userNumbers.contains(num)) {
                    System.out.println("Duplicate number! Try again.");
                } else {
                    userNumbers.add(num);
                }
            }

            Set<Integer> matched = new HashSet<>(userNumbers);
            matched.retainAll(winningNumbers);






            System.out.println("🎟️ Your numbers: " + userNumbers);
            System.out.println("\uD83C\uDFB0 Winning numbers: " + winningNumbers);
            System.out.println("✅ Matched: " + matched);

            if (matched.size() < 2) {
                System.out.println("No luck this time 😢");
            } else if (matched.size() <= 4) {
                System.out.println("Partial win! 😊");
            } else if (matched.size() > 4 && matched.size() <= 6) {
                System.out.println("\uD83C\uDF89 JACKPOT!!! \uD83C\uDFC6");
            }

            System.out.print("Play again? (yes/no): ");
            String answer = sc.next().toLowerCase();
            sc.nextLine();
            if (answer.equals("no") || answer.equals("exit")) {
                break;
            }else {
                userNumbers.clear();
                winningNumbers.clear();
                matched.clear();
            }


        }


    }
}
