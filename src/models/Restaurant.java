package models;

import java.util.*;

public class Restaurant {
    String restaurantId;
    String restaurantName;
    int processingCapacity;
    Menu menuCard;
    int capacityInUse;

    public Restaurant(String restaurantName, int processingCapacity, Menu menuCard){
        this.restaurantId = UUID.randomUUID().toString();
        this.restaurantName = restaurantName;
        this.processingCapacity = processingCapacity;
        this.capacityInUse = 0;
        this.menuCard = new Menu();
    }

    public String getRestaurantName(){
        return this.restaurantName;
    }


    public Menu getMenuCard() {
        return menuCard;
    }
}
