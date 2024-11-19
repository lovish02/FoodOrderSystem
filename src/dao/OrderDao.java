package dao;

import models.Item;
import models.Order;
import models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderDao {
    private static OrderDao orderDaoInstance;
    HashMap<User, List<Order>> orderMap;
    private OrderDao(){
        orderMap = new HashMap<>();
    }

    public static OrderDao getInstance(){
        if(orderDaoInstance == null){
            orderDaoInstance = new OrderDao();
        }
        return orderDaoInstance;
    }
    public List<Order> getAllUserOrders(User user){
        return orderMap.getOrDefault(user, new ArrayList<>());
    }


    public String createOrder(User user, HashMap<Item, Integer> orderItems){
        Order order = new Order(user, orderItems);
        List<Order> allOrders = getAllUserOrders(user);
        allOrders.add(order);
        orderMap.put(user, allOrders);
        return order.getOrderId();
    }
}
