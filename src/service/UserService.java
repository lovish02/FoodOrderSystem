package service;

import dao.ItemDao;
import dao.OrderDao;
import dao.UserDao;
import models.Item;
import models.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    UserDao userDaoInstance;
    ItemDao itemDaoInstance;
    OrderDao orderDaoInstance;
    public UserService(){
        userDaoInstance = UserDao.getInstance();
        itemDaoInstance = ItemDao.getInstance();
        orderDaoInstance = OrderDao.getInstance();
    }

    public void addUser(String userName, String phoneNo){
        userDaoInstance.createUser(userName, phoneNo);
    }

    public String placeOrder(String userName, Map<String, Integer> orderItems){
        User currentUser = userDaoInstance.getUser(userName);
        HashMap<Item, Integer> currentOrder = new HashMap<>();
        for(Map.Entry<String, Integer> entry: orderItems.entrySet()){
            Item currentItem = itemDaoInstance.getItem(entry.getKey());
            Integer quantity = entry.getValue();
            currentOrder.put(currentItem, quantity);
        }
        return orderDaoInstance.createOrder(currentUser, currentOrder);
    }



}
