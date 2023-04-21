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
        // musicListID is differentiated from listID due to it's usage possibly messing up orders if someone signs in then a new user is made
        String title, artist, genre;
        Integer releaseYear, songID, musicListID;
        
        // confirmationUser is used for deleting user accounts
        // confirmationSong is used for deleting songs in a users playlist
        String confirmationUser;
        String confirmationSong;
        
        // userList is established as the connector to the UserList class and its functions
        // musicList is established as the connector to the MusicList class and its functions
        UserList userList = new UserList();
        MusicList musicList = new MusicList();
        
        // Integer option is used for the prototype menu
        // userOption is for the secondary menu within the current menu, used for user playlists/songs
        Integer option;
        Integer userOption;
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
                    // If a username already exists then a message is displayed and the user is sent back to the menu
                    // A boolean is then set up for a Do While loop when setting an accounts admin status
                    username = Input.getString("Create username: ");
                    userList.checkUser(username);
                    if(userList.checkUser(username) == true){
                        System.out.println("Username is already taken...");
                        System.out.println("---------------");
                        break;
                    }
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
                
                case 2 -> {
                    // Case 2 will delete the designated user after verification
                    // User will be requested to enter both the username and password of the account for deletion
                    username = Input.getString("Enter username: ");
                    // userList.checkUser(username);
                    if(userList.checkUser(username) == true){
                        // checkUser from adding a user is once again used to confirm a user exists
                        // If the returned value is false then a message will be displayed and break back to menu
                        password = Input.getString("Enter password: ");
                        // userList.checkPassword(password);
                        if(userList.checkPassword(password) == true){
                            // New checkPassword functions identically to checkUser but for passwords
                            // If the returned value is false then will also display a message and break
                            // If true then a confirmation will be displayed
                            confirmationUser = Input.getString("Are you sure you wish to delete this account? (Y or N): ");
                            if(confirmationUser.equals("Y") || confirmationUser.equals("y")){
                                // Inputing Y or y will call deleteUser and delete the account in UserList then return to the menu
                                userList.deleteUser(username, password);
                                System.out.println("Account Deleted...");
                                System.out.println("---------------");
                                break;
                            } else if(confirmationUser.equals("N") || confirmationUser.equals("n")){
                                // Inputing N or n will break back to menu after a message, not deleting the user
                                System.out.println("Deletion Cancelled...");
                                System.out.println("---------------");
                                break;
                            } else {
                                // anything else will be identical to N or n but with a different message, should be changed in later versions
                                System.out.println("Invalid input...");
                                System.out.println("---------------");
                                break;
                            }
                        } else {
                            System.out.println("Incorrect Password...");
                            System.out.println("---------------");
                            break;
                        }
                    } else {
                        System.out.println("No User with that Name...");
                        System.out.println("---------------");
                        break;
                    }
                }
                
                case 3 -> {
                    System.out.println("---------------");
                    userList.displayUsers();
                    System.out.println("---------------");
                    break;
                }
                
                case 4 -> {
                    // Case 4 is to sign into and access a users playlist/music
                    // Case 4 starts similarly to Case 2 by verifying the username and password with the same else outcomes
                    username = Input.getString("Enter username: ");
                    userList.checkUser(username);
                    if(userList.checkUser(username) == true){
                        password = Input.getString("Enter password: ");
                        userList.checkPassword(password);
                        if(userList.checkPassword(password) == true){
                            // the musicListID of the user will be retrieved to help differentiate the currently signed in user
                            musicListID = userList.getListID(username, password);
                            do{
                                // Menu layout is similar to original but will call functions for songs and relating to the current user
                                System.out.println("0: Sign Out");
                                System.out.println("1: Add Song");
                                System.out.println("2: Remove Song");
                                System.out.println("3: Update Song");
                                System.out.println("4: Display All Songs");
                                System.out.println("5: Display Songs by...");
                                System.out.println("6: Display Songs Ordered by...");
                                System.out.println("--------------------");
                                
                               userOption = Input.getInteger("Enter Menu Choice: ");
                               
                               switch(userOption){
                                   case 0 -> {
                                       // Case 0 will take the user back to the previous menu
                                       // Will display a message beforehand
                                       System.out.println("Signing Out...");
                                       System.out.println("---------------");
                                   }
                                   
                                   case 1 -> {
                                       // Case 1 will add a new song to the users playlist
                                       title = Input.getString("Enter Title: ");
                                       artist = Input.getString("Enter Artist/Band: ");
                                       genre = Input.getString("Enter Genre: ");
                                       releaseYear = Input.getInteger("Enter Release Year: ");
                                       songID = musicList.getCount();
                                       musicList.addSong(title, artist, genre, releaseYear, songID, musicListID);
                                       System.out.println("---------------");
                                       System.out.println("Song Added");
                                       System.out.println("---------------");
                                       break;
                                   }
                                   
                                   case 2 -> {
                                       // Case 2 will delete the selected song from the user playlist
                                       // title and artist are used since there could be songs with the same name but not the same artist
                                       title = Input.getString("Enter the songs title: ");
                                       musicList.checkSongTitle(title, musicListID);
                                       if(musicList.checkSongTitle(title, musicListID) == true){
                                           artist = Input.getString("Enter the songs artist: ");
                                           musicList.checkArtist(artist, musicListID);
                                           if(musicList.checkArtist(artist, musicListID) == true){
                                               confirmationSong = Input.getString("Are you sure you wish to delete this song? (Y or N): ");
                                               if(confirmationSong.equals("Y") || confirmationSong.equals("y")){
                                                   musicList.deleteSong(title, artist, musicListID);
                                                   System.out.println("Song Deleted...");
                                                   System.out.println("---------------");
                                               } else if (confirmationSong.equals("N") || confirmationSong.equals("n")){
                                                   System.out.println("Deletion Cancelled...");
                                                   System.out.println("---------------");
                                                   break;
                                               } else {
                                                   System.out.println("Invalid Input...");
                                                   System.out.println("---------------");
                                                   break;
                                               }
                                           } else {
                                               System.out.println("No matching artist...");
                                               System.out.println("---------------");
                                               break;
                                           }
                                       } else {
                                           System.out.println("No Song with that title...");
                                           System.out.println("---------------");
                                           break;
                                       }
                                   }
                                   
                                   case 3 -> {
                                       title = Input.getString("Enter the songs title: ");
                                       musicList.checkSongTitle(title, musicListID);
                                       if(musicList.checkSongTitle(title, musicListID) == true){
                                           artist = Input.getString("Enter the songs artist: ");
                                           musicList.checkArtist(artist, musicListID);
                                           if(musicList.checkArtist(artist, musicListID) == true){
                                               System.out.println("---------------");
                                               title = Input.getString("Enter new title for song: ");
                                               artist = Input.getString("Enter new artist for song: ");
                                               genre = Input.getString("Enter new genre for song: ");
                                               releaseYear = Input.getInteger("Enter new release year for song: ");
                                               musicList.updateSong(title, artist, genre, releaseYear, musicListID);
                                               System.out.println("Song updated...");
                                               System.out.println("---------------");
                                               break;
                                           } else {
                                               System.out.println("No matching artist...");
                                               System.out.println("---------------");
                                               break;
                                           }
                                       } else {
                                           System.out.println("No Song with that title...");
                                           System.out.println("---------------");
                                           break;
                                       }
                                   }
                                   
                                   case 4 -> {
                                       // Case 4 will display all songs in the users playlist
                                       // musicListID will ensure only that users songs are displayed
                                       System.out.println("---------------");
                                       musicList.displaySongs(musicListID);
                                       System.out.println("---------------");
                                   }
                               }
                            }while(userOption != 0);
                            break;
                        } else {
                            System.out.println("Incorrect Password...");
                            System.out.println("---------------");
                            break;
                        }
                    } else {
                        System.out.println("No User with that Name...");
                        System.out.println("---------------");
                        break;
                    }
                }
            }
        }while(option!=0);
    }
}
