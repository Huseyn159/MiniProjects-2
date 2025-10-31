package SmartInventoryApp;

import SmartInventoryApp.entities.Product;
import SmartInventoryApp.service.InventoryManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("=== SMART INVENTORY ===");
                System.out.println("1. Add product");
                System.out.println("2.Remove product");
                System.out.println("3.Update stock");
                System.out.println("4.Search Item");
                System.out.println("5.Show all");
                System.out.println("6.Exit");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter Product ID:");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Product name");
                        String name = sc.nextLine();
                        System.out.println("Enter price");
                        double price = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Enter stock");
                        int stock = sc.nextInt();

                        manager.addProduct(new Product(id, name, price, stock));
                    }
                    case 2 -> {
                        System.out.println("Enter product ID");
                        int id = sc.nextInt();
                        manager.removeProductById(id);

                    }
                    case 3 -> {
                        System.out.println("Enter product ID");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter new stock");
                        int nwStock = sc.nextInt();
                        manager.uptadeStock(id, nwStock);
                    }
                    case 4 -> {
                        System.out.println("Enter product name");
                        String name = sc.nextLine();
                        manager.findByName(name);
                    }
                    case 5 -> {
                        manager.showAllProducts();
                    }
                    case 6 -> {
                        System.out.println("Goodbye!");
                        System.exit(0);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Invalid input! Please enter valid type.");
                sc.nextLine();
            }
        }



//        manager.addProduct(new Product(1,"Bread",0.29,0));
//        manager.addProduct(new Product(1,"BetterBread",5.29,0));
//        manager.addProduct(new Product(3,"Caz",0.29,0));
//        manager.addProduct(new Product(9,"Qaz",0.39,0));
//
//        manager.showAllProducts();
//        manager.findByName("Bread");
//        manager.findByName("babao");
//        manager.uptadeStock(1,2);
//        manager.removeProductById(5);
//        manager.removeProductById(3);
//        manager.showAllProducts();


    }
}
