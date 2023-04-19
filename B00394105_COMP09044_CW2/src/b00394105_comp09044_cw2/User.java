package b00394105_comp09044_cw2;

import java.util.LinkedList;
import java.util.ListIterator;

public class User {
    public String username, password;
    public Integer userID, listID;
    public Boolean admin;
    
    public User(String username, String password, Integer userID, Integer listID, Boolean admin){
        this.username = username;
        this.password = password;
        this.userID = userID;
        this.listID = listID;
        this.admin = admin;
    }
    
    @Override
    public String toString(){
        return "Username: " + username + ", ID: " + userID + ", Admin?: " + admin;
    }
}
