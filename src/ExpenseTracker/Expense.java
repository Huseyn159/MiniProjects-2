package ExpenseTracker;

import java.time.LocalDate;

public class Expense {

    private static int counter = 1;
    private int id;
    private String category;
    private double amount;
    private String note;
    private LocalDate date;

    public Expense( String category, double amount, String note, LocalDate date) {
        this.id = counter++;
        this.category = category;
        this.amount = amount;
        this.note = note;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", note='" + note + '\'' +
                ", date=" + date +
                '}';
    }
}
