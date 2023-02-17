package b00394105_comp09044_cw2;

// Menu Prototype (Pre-User Interface)

import java.util.InputMismatchException;
import java.util.Scanner;


public class PlaylistUsage {
    public static void main(String[] args){
        String username, password;
        Integer userID, listID;
        Boolean admin;
        
        String title, artist, genre;
        Integer releaseYear, songID;
        
        // Create Admin
        String adminUsername = "Admin";
        String adminPassword = "password123";
        Integer adminID = 1;
        Integer adminList = 1;
        Boolean adminStatus = true;
        User user = new User(adminUsername, adminPassword, adminID, adminList, adminStatus);
        System.out.println("Admin created successfully...");
        System.out.println("-----------------------------");
        
        
        Integer option;
        do {
            System.out.println("0: Quit Program");
            System.out.println("1: Create Account");
            System.out.println("2: Delete Account");
            System.out.println("3: Display Accounts");
            System.out.println("4: Sign In");
            System.out.println("--------------------");
            
            option = Input.getInteger("Menu Choice: ");
            
            switch(option){
                case 0 -> System.out.println("Quitting Program...");
                
                case 1 -> {
                    username = Input.getString("Create username: ");
                    password = Input.getString("Create password: ");
                    boolean b = false;
                        do{
                            try{
                                System.out.println("Is this user an admin? (true or false): ");
                                Scanner n = new Scanner(System.in);
                                boolean bn = n.nextBoolean();
                                if(bn == true){
                                    admin = true;
                                    // send to User class
                                    // break
                                } else if (bn == false) {
                                    admin = false;
                                    // send to User class
                                    // break
                                }
                            }catch(InputMismatchException e){
                                System.out.println("Invalid input");
                            }
                        }while(!b);
                }
                
                case 3 -> {
                    System.out.println("---------------");
                    user.displayUsers();
                    System.out.println("---------------");
                    break;
                }
            }
        }while(option!=0);
    }
}
