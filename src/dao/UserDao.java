package dao;

import models.Restaurant;
import models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDao {
    private static UserDao userDaoInstance;
    HashMap<String, User> userMap;
    private UserDao(){
        userMap = new HashMap<>();
    }

    public static UserDao getInstance(){
        if(userDaoInstance == null){
            userDaoInstance = new UserDao();
        }
        return userDaoInstance;
    }

    public void createUser(String userName, String phoneNo){
        User newUser = new User(userName, phoneNo);
        userMap.put(userName, newUser);
    }

    public List<User> getAllUsers(){
        List<User> allUsers = new ArrayList<>();
        for(Map.Entry<String, User>entry: userMap.entrySet()){
            allUsers.add(entry.getValue());
        }
        return allUsers;
    }

    public User getUser(String userName){
        return userMap.get(userName);
    }
}
