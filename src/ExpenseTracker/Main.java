package ExpenseTracker;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        manager.loadFromFile("expenses.txt");

        while (true) {
            System.out.println("\n==== Smart Expense Tracker ====");
            System.out.println("1. Add new expense");
            System.out.println("2. Show total expenses");
            System.out.println("3. Show expenses by category");
            System.out.println("4. Show biggest expense");
            System.out.println("5. Save to file");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear input buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter note: ");
                    String note = scanner.nextLine();

                    LocalDate date = LocalDate.now(); // today’s date

                    Expense expense = new Expense(category, amount, note, date);
                    manager.addExpense(expense);
                    System.out.println("✅ Expense added successfully!");
                }

                case 2 -> {
                    double total = manager.totalSpent();
                    System.out.println("💰 Total expenses: " + total + " AZN");
                }

                case 3 -> {
                    System.out.print("Enter category name: ");
                    String category = scanner.nextLine();
                    manager.showByCategory(category);
                }

                case 4 -> manager.findBiggestExpense();

                case 5 -> {
                    manager.saveToFIle("expenses.txt");
                    System.out.println("💾 Data saved to file!");
                }

                case 0 -> {
                    manager.saveToFIle("expenses.txt");
                    System.out.println("👋 Exiting... Goodbye!");
                    return;
                }

                default -> System.out.println("❌ Invalid choice! Please try again.");
            }
        }
    }
}

