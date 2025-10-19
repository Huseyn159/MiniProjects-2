package Notepad_Pro;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IO_operations {
    public static void main(String[] args) {
        File file = new File("notes.txt");
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        if(!file.exists()){
            try {
                file.createNewFile();
                System.out.println("File cannot found.Recreated...");
                System.out.println("==============================");
            } catch (IOException e) {
                System.out.println("Error -> " + e.getMessage());
            }

        }
        String filePath = file.getPath();
        System.out.println("Welcome to  NotepadPro");
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        while(true) {
            try {
                System.out.println("1.Add new note");
                System.out.println("2.Read all notes");
                System.out.println("3.Clear all notes");
                System.out.println("4.Exit");
                choice = sc.nextInt();
                if (choice >0 && choice <=4){
                   switch (choice){
                       case 1 ->{

                           try(FileWriter fw = new FileWriter(filePath,true);
                               BufferedWriter bw = new BufferedWriter(fw)) {
                               System.out.println("Enter your note: ");
                               sc.nextLine();
                               String input = sc.nextLine();
                               bw.write("[" + date + "] " + input);
                               bw.newLine();
                               System.out.println("===========");
                               System.out.println("Note Added!");
                               System.out.println("===========");



                           }catch (IOException e){
                               System.out.println("Error -> " + e.getMessage());
                           }

                       }
                       case 2 ->{

                           try(FileReader fr = new FileReader(filePath);
                                BufferedReader br = new BufferedReader(fr)) {
                               if (file.length() == 0){
                                   System.out.println("Notes are empty!");

                               }
                               String line;
                               while ((line = br.readLine())!=null){
                                   System.out.println(line);
                               }



                           }catch (IOException e){
                               System.out.println("Error -> " + e.getMessage());
                           }

                       }
                       case 3 -> {
                           if(file.length()>0){
                           System.out.println("All notes will be deleted.Are you sure?");
                           System.out.println("y/n");
                           sc.nextLine();



                           try {
                           char yn = Character.toLowerCase(sc.nextLine().charAt(0));
                               if (yn != 'y' && yn != 'n') {
                                   throw new InputMismatchException("Please enter 'y' or 'n'");
                               }

                           switch (yn){
                               case 'y' ->{
                                   try (FileWriter fw = new FileWriter(file, false)) {
                                       System.out.println("====================");
                                       System.out.println("All notes cleared!");
                                       System.out.println("====================");
                                   } catch (IOException e) {
                                       System.out.println("Error -> " + e.getMessage());
                                   }
                               }
                               case 'n' -> {
                                   System.out.println("====================");
                                   System.out.println("Operation cancelled.");
                                   System.out.println("====================");

                               }
                            }
                           }catch (InputMismatchException e){
                               System.out.println("=======================");
                               System.out.println("Please enter 'y' or 'n'");
                               System.out.println("=======================");
                           }
                           }
                           else {
                               System.out.println("===============");
                               System.out.println("File is empty..");
                               System.out.println("===============");
                           }


                       }
                       case 4 -> {
                           System.out.println("GoodBye!");
                           System.exit(0);
                       }
                   }
                }else {
                    System.out.println("==========================");
                    System.out.println("Choose number between 1-3");
                    System.out.println("==========================");
                }

            } catch (InputMismatchException e) {
                System.out.println("===================");
                System.out.println("Enter valid number");
                System.out.println("===================");
                sc.nextLine();

            }
        }





    }
}
