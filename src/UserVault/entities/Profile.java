package UserVault.entities;

import java.io.Serializable;
import java.util.List;

public class Profile implements Serializable {
    private String email;
    private String city;
    private double balance;
    private List<String> transactions;

    public Profile(String email, String city, double balance, List<String> transactions) {
        this.email = email;
        this.city = city;
        this.balance = balance;
        this.transactions = transactions;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }


    @Override
    public String toString() {
        return "Profile{" +
                "email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }
}
