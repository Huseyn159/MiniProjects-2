package BankLedgerPro;

public class BankAccount {
    private String id;
    private String ownerName;
    private double balance;
    private final String currency;

    public BankAccount(String id, String ownerName, double balance, String currency) {
        this.id = id;
        this.ownerName = ownerName;
        this.balance = balance;
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return String.format(
                "🏦 Bank Account Info%n" +
                        "--------------------%n" +
                        "🆔 ID: %s%n" +
                        "👤 Owner: %s%n" +
                        "💰 Balance: %.2f %s%n",
                id, ownerName, balance, currency
        );
    }

    public void deposit(double amount) {

        balance += amount;
        System.out.println(amount + " " + currency + " added");
        System.out.println("Current balance: " + balance);
    }

    public void withdraw(double amount) {
        try {
            if (balance > amount) {

                balance -= amount;
                System.out.println("-" + amount + " " + " " + currency);
                System.out.println("Current balance: " + balance);
            } else {
                throw new InsufficientFundsException(" ");
            }
        } catch (InsufficientFundsException e) {
            System.out.println("Insufficient balance.Please Top up and try again");
        }
    }

    public void applyInterest(double rate){
        balance += balance * rate / 100;
        System.out.println("Current balance: " + balance);
    }

    public static void calculateInterest(){

    }
}
