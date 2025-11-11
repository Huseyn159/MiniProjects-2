package FraudDetection;

public class Transaction {
    private static int counter = 1;
    private int id;
    private String userId;
    private double amount;
    private String location;

    public Transaction( String userId, double amount, String location) {
        this.id = counter++;
        this.userId = userId;
        this.amount = amount;
        this.location = location;
    }

    public int getId() { return id; }
    public String getUserId() { return userId; }
    public double getAmount() { return amount; }
    public String getLocation() { return location; }


    @Override
    public String toString() {
        return "Txn{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", amount=" + amount +
                ", location='" + location + '\'' +
                '}';
    }

}
