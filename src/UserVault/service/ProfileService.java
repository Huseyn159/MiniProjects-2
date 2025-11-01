package UserVault.service;

import UserVault.data.DataStore;
import UserVault.entities.Profile;

import java.util.Scanner;

public class ProfileService {
    public void viewProfile(){
        Profile p = DataStore.currentUser.getProfile();
        try{
        System.out.println("=== PROFILE INFO ===");
        System.out.println("Email: " + (p.getEmail() == null ? "-" : p.getEmail()));
        System.out.println("City: " + (p.getCity() == null ? "-" : p.getCity()));
        System.out.println("Balance: $" + p.getBalance());}
        catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }

    public void updateProfile(){
        Scanner sc = new Scanner(System.in);
        Profile p = DataStore.currentUser.getProfile();

        System.out.print("Enter new email: ");
        p.setEmail(sc.nextLine());

        System.out.print("Enter new city: ");
        p.setCity(sc.nextLine());

        System.out.println("✅ Profile updated!");

    }

    public void addBalance(){
        Scanner sc = new Scanner(System.in);
        Profile p = DataStore.currentUser.getProfile();


        System.out.println("Enter amount to add:");
        double amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("❌ Invalid amount!");
            return;
        }
        System.out.println(amount + "$ added to your balance");
        p.setBalance(p.getBalance() + amount);
        System.out.println("💵 New balance: $" + p.getBalance());



    }


}
