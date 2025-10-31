package SmartInventoryApp.service;

import SmartInventoryApp.entities.Product;
import SmartInventoryApp.util.TransactionLogger;

import java.util.HashSet;
import java.util.Set;

public class InventoryManager {

    Set<Product> inventory = new HashSet<>();

    public void addProduct(Product a){
    if (inventory.add(a)){
        System.out.println("✅ Product added: " + a);
        TransactionLogger.log("Added product: " + a.getName());
        }
    else {
        System.out.println("⚠️ Product already exists: " + a.getName());
        TransactionLogger.log("Duplicate product: " + a.getName());
    }
    }
    public void removeProductById (int id){
        Product remove = null;

        for (Product a : inventory){
            if (a.getId() == id){
                remove = a;
                break;
            }
        }
            if (remove != null){
                inventory.remove(remove);
                System.out.println("✅ Removed: " + remove);
                TransactionLogger.log("Removed product: " + remove.getName());

            }
            else {
                System.out.println("⚠️ Product with id " + id + " not found");
            }



    }
    public void uptadeStock(int id,int newStock){
     for (Product a : inventory){
         if (a.getId() == id){
             System.out.println("Stock replaced for " + a.getName() + " " + a.getId());
             TransactionLogger.log("Updated stock for " + a.getName() + " (ID: " + id + ") to " + newStock);
             a.setStock(newStock);
             break;
         }
         else System.out.println("Item with this ID not found");
     }
    }
    public void showAllProducts(){
        System.out.println("Products: ");
        for (Product a : inventory){
            System.out.println("- " + a);

        }

    }
    public void findByName(String name){
        boolean founded = false;
      for (Product a : inventory){
          if (a.getName().equalsIgnoreCase(name)){
              founded = true;
              System.out.println("Founded Product: \n" + name + "\nPrice: " + a.getPrice());
               break;
          }

      }
      if (!founded) System.out.println("Item Not Found!");


    }
}
