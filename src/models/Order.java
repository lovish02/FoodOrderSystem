package models;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;


public class Order {
    String orderId;
    User user;
    HashMap<Item, Integer> orderList;

    public Order(User user, HashMap<Item, Integer> orderList) {
        this.orderId = UUID.randomUUID().toString();
        this.user = user;
        this.orderList = orderList;
    }

    public String getOrderId() {
        return orderId;
    }
}
