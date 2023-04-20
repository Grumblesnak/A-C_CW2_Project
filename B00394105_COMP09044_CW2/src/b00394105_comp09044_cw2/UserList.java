package b00394105_comp09044_cw2;

import java.util.LinkedList;
import java.util.ListIterator;

public class UserList {
    LinkedList<User> users = new LinkedList<>();
    
//    static class Node{
//        int data;
//        Node next;
//    }
    
    public UserList(){
        
    }
    
    public void addUser(String username, String password, Integer userID, Integer listID, Boolean admin){
        User newUser = new User(username, password, userID, listID, admin);
        users.add(newUser);
    }
    
    public boolean checkUser(String username){
        boolean userExists = false;
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).username.equals(username)){
                userExists = true;
            }
        }
        return userExists;
    }
    
    public boolean checkPassword(String password){
        boolean passwordCorrect = false;
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).password.equals(password)){
                passwordCorrect = true;
            }
        }
        return passwordCorrect;
    }
    
    public void deleteUser(String username, String password){
        for(int i = 0; i< users.size(); i++){
            if(users.get(i).username.equals(username) && users.get(i).password.equals(password)){
                users.remove(i);
            }
        }
    }
    
    public Integer getListID(String username, String password){
        Integer retrievedListID = 0;
        for(int i = 0; i< users.size(); i++){
            if(users.get(i).username.equals(username) && users.get(i).password.equals(password)){
                retrievedListID = users.get(i).listID;
            }
        }
        return retrievedListID;
    }
    
    public void displayUsers(){
        if(users != null && users.size() > 0){
            for (int i = 0; i < users.size(); i++){
                System.out.println(users.get(i));
            }
        } else {
            System.out.println("No Users stored...");
        }
    }
}
