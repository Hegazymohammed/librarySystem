package mangement;

import entities.User;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserManager {

    private List<User> users=new ArrayList<>();
    private HashMap<String,User>namesToUser=new HashMap<>();
    public boolean addNewUser(String name){
        if(!namesToUser.containsKey(name))
                return false;
        //add new user
        User user=new User(name);
        users.add(user);
        namesToUser.put(name,user);
        return true;
    }

    public List<String>whoBorrowedBookByName(int id){

        List<String>names=users.stream().filter(user->user.borrowBook(id)).map(user->user.getName()).toList();
        return names;
    }

    public boolean userBorrowBook(String name,int bookId){
            User user=namesToUser.get(name);
            if(user==null)
                    return false;
            user.borrowBook(bookId);
            return true;
    }


    public boolean userReturnBook(String name,int bookId){
        User user=namesToUser.get(name);
        if(user==null)
                return false;
        user.returnBook(bookId);
        return true;
    }

    public List<User> getUsers() {

        return users;
    }
}
