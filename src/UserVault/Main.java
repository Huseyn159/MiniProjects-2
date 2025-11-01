package UserVault;

import UserVault.data.DataStore;
import UserVault.service.AuthService;
import UserVault.service.ProfileService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataStore.loadData();

        ProfileService prf = new ProfileService();
        AuthService auth = new AuthService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> auth.register();
                case 2 -> {
                    auth.login();

                    if (DataStore.currentUser != null) { // login uğurlu olubsa
                        while (true) {
                            System.out.println("=== PROFILE MENU ===");
                            System.out.println("1. View Profile");
                            System.out.println("2. Update Profile");
                            System.out.println("3. Add Balance");
                            System.out.println("4. Logout");
                            System.out.print("Choose: ");

                            int choice2 = sc.nextInt();
                            sc.nextLine();

                            switch (choice2) {
                                case 1 -> prf.viewProfile();
                                case 2 -> prf.updateProfile();
                                case 3 -> prf.addBalance();
                                case 4 -> {
                                    auth.logout();
                                    DataStore.saveData();
                                    break; // daxili loopdan çıx
                                }
                                default -> System.out.println("Invalid choice!");
                            }

                            if (DataStore.currentUser == null) break; // logout olunduqdan sonra çıx
                        }
                    }
                }
                case 3 -> {
                    DataStore.saveData(); // çıxarkən fayla yaz
                    System.out.println("Goodbye!");
                    return;
                }
            }
        }





    }
}
