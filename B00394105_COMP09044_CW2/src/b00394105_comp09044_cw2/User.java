package b00394105_comp09044_cw2;

import java.util.LinkedList;
import java.util.ListIterator;

public class User {
    LinkedList<LinkedList> users = new LinkedList<>();
    LinkedList userDetails = new LinkedList<>();
    private Integer userCount = 0;
    
    private String username, password;
    private Integer userID, listID;
    private Boolean admin;
    
    public User(String username, String password, Integer userID, Integer listID, Boolean admin){
        this.username = username;
        this.password = password;
        this.userID = userID;
        this.listID = listID;
        this.admin = admin;
        userCount++;
        userDetails.add(username);
        userDetails.add(password);
        userDetails.add(userID);
        userDetails.add(listID);
        userDetails.add(admin);
        users.add(userDetails);
    }
    
    //public void createUser(String username, String password, Boolean admin){
    //    userCount++;
    //    
    //}
    
    public void displayUsers(){
        while(users != null){
            System.out.println(users);
            break;
        }
    }
}
