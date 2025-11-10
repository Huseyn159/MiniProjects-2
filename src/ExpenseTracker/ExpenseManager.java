package ExpenseTracker;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ExpenseManager {
Scanner sc = new Scanner(System.in);
    private Map<String, List<Expense>> expenseMap = new HashMap<>();
    private final List<Expense> newExpenses = new ArrayList<>();

    public void addExpense(Expense expense) {
        try {
            if (expense.getAmount() <= 0)
                throw new InvalidAmountException("Amount must be greater than zero!");

            expenseMap.computeIfAbsent(expense.getCategory(), k -> new ArrayList<>()).add(expense);


            newExpenses.add(expense);

        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }
    }
    public double  totalSpent(){
        double totalAmount = 0;
        for (Map.Entry<String,List<Expense>> entry : expenseMap.entrySet()){
          List<Expense> list = entry.getValue();
          for (Expense e : list){
              totalAmount+= e.getAmount();
          }

        }
     return totalAmount;
    }

    public void showByCategory(String category) {
        if (!expenseMap.containsKey(category)) {
            System.out.println("Category not found!");

        } else {

            List<Expense> list = expenseMap.get(category);
            if (list.isEmpty()) {
                System.out.println("No expenses in this category yet!");
            } else {
                for (Expense e : list) {
                    System.out.println(e);
                }


            }


        }
    }

    public void findBiggestExpense(){
        Expense biggest = null;
        double max = 0;
          for (List<Expense> list : expenseMap.values()){
              for (Expense e : list) {
                 if (e.getAmount() > max){
                     max = e.getAmount();
                     biggest = e;
                 }
              }
          }
          if (biggest == null){
              System.out.println("No expenses found!");
          }
          else System.out.println(biggest);

    }

    public void saveToFIle(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) { // append = true

            for (Expense e : newExpenses) {
                String line = e.getCategory() + "|" + e.getAmount() + "|" + e.getNote() + "|" + e.getDate();
                writer.println(line);
            }

            newExpenses.clear();
            System.out.println("💾 Only new expenses were added to file!");

        } catch (IOException e) {
            System.out.println("Error! " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        File file = new File(filename);


        if (!file.exists()) {
            System.out.println("No saved data found!");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;


            while ((line = reader.readLine()) != null) {


                if (line.trim().isEmpty()) continue;


                String[] parts = line.split("\\|");


                if (parts.length < 4) {
                    System.out.println("Invalid data format: " + line);
                    continue;
                }


                String category = parts[0];
                double amount = Double.parseDouble(parts[1]);
                String note = parts[2];
                LocalDate date = LocalDate.parse(parts[3]);


                Expense expense = new Expense(category, amount, note, date);

                addExpense(expense);
            }

            System.out.println("✅ Data loaded successfully from " + filename);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error converting amount: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
