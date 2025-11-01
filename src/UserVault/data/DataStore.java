package UserVault.data;

import UserVault.entities.User;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DataStore {
    public static Map<String, User> users = new HashMap<>();
    public static User currentUser = null;
    private static final String FILE_NAME = "users.dat";


    public static void saveData(){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
            out.writeObject(users);
        }catch (IOException e){
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static void loadData(){
        File file = new File(FILE_NAME);
        if (!file.exists())return;

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))){
            users = (Map<String, User>) in.readObject();
        }catch (IOException  | ClassNotFoundException e){
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
