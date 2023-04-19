package b00394105_comp09044_cw2;

// Menu Prototype (Pre-User Interface)

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;


public class PlaylistUsage {
    public static void main(String[] args){
        // The variables of a user's identity below, username and password are strings to allow a wider range of input possibilities
        // userID and listID are set to 0 automatically for first input
        // admin Boolean is set during the creation of a new account and dso is left blank by default alongside username and password
        String username, password;
        Integer userID = 0;
        Integer listID = 0;
        Boolean admin;
        
        // The variables of a song's identity below
        // title and artist are strings due to songs, especially nowadays, possibly containing a range of either letters, numbers, or symbols
        // genre is at the users discretion, but will be changed in version 2 to be limited to actual genres
        // release year is also at the users input
        String title, artist, genre;
        Integer releaseYear, songID;
        
        // userList is established as the connector to the UserList class and its functions
         UserList userList = new UserList();
        
        Integer option;
        do {
            // Basic menu for version 1 contains 5 options initially, but when logged in shall display several more options for user use
            // Do While loop ensures the menu remains up until '0' is entered as an option to quit
            System.out.println("0: Quit Program");
            System.out.println("1: Create Account");
            System.out.println("2: Delete Account");
            System.out.println("3: Display Accounts");
            System.out.println("4: Sign In");
            System.out.println("--------------------");
            
            // Reads in the users menu choice (integer input)
            // [Check to ensure only a valid input is entered]
            option = Input.getInteger("Menu Choice: ");
            
            switch(option){
                // Input 0 quits the program
                case 0 -> System.out.println("Quitting Program...");
                
                case 1 -> {
                    // Input 1 will display options for the user to create a new user
                    // username and password are called to recieve inputs from the user
                    // A check is made for already existing usernames, but not passwords (security risk)
                    // [input check for already existing username]
                    // A boolean is then set up for a Do While loop when setting an accounts admin status
                    username = Input.getString("Create username: ");
                    password = Input.getString("Create password: ");
                    boolean b = false;
                        do{
                            try{
                                // Scanner n is used to read in the next input as a boolean
                                System.out.println("Is this user an admin? (true or false): ");
                                Scanner n = new Scanner(System.in);
                                boolean bn = n.nextBoolean();
                                if(bn == true){
                                    // If the input is true then the created user is set to an admin
                                    // The userID and listID are allocated then moved onto the UserList class
                                    admin = true;
                                    userList.addUser(username, password, userID, listID, admin);
                                    userID++;
                                    listID++;
                                    System.out.println("---------------");
                                    System.out.println("Admin added...");
                                    System.out.println("---------------");
                                    break;
                                } else if (bn == false) {
                                    // If the input is false then the created user is not set as an admin
                                    // The userID and listID are allocated then moved onto the UserList class
                                    admin = false;
                                    userList.addUser(username, password, userID, listID, admin);
                                    userID++;
                                    listID++;
                                    System.out.println("---------------");
                                    System.out.println("User added...");
                                    System.out.println("---------------");
                                    break;
                                }
                            }catch(InputMismatchException e){
                                // If an input is not either true or false then a the user will be prompted again after a message is displayed
                                System.out.println("Invalid input");
                            }
                        }while(!b);
                }
                
                case 3 -> {
                    System.out.println("---------------");
                    userList.displayUsers();
                    System.out.println("---------------");
                    break;
                }
            }
        }while(option!=0);
    }
}
