package UserVault.service;

import UserVault.data.DataStore;
import UserVault.entities.Profile;
import UserVault.entities.User;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class AuthService {

public void login(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter username: ");
    String uName = sc.nextLine();
    System.out.print("Enter password: ");
    String password = sc.nextLine();
    User user = DataStore.users.get(uName);
    if (user == null ){
        System.out.println("User not found!");
        return;
    }
     if(user.getPassword().equals(password)){
         DataStore.currentUser = user;
         System.out.println("Welcome, " + user.getUsername());
     }else {
         System.out.println("Wrong password!");
     }

}

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String uName = sc.nextLine();

        if (DataStore.users.containsKey(uName)) {
            System.out.println("Username already taken!");
            return;
        }

        System.out.print("Enter password: ");
        String psw = sc.nextLine();
        Profile emptyProfile = new Profile(null, null, 0.0, new ArrayList<>());
        User user = new User(uName, psw,emptyProfile);
        DataStore.users.put(uName, user);

        System.out.println("✅ Account created successfully!");
        DataStore.saveData();
    }

    public void logout(){
    DataStore.currentUser=null;
        System.out.println("Logged Out!");

    }
}
