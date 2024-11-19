package service;

import dao.ItemDao;
import dao.RestaurantDao;
import models.Item;
import models.Menu;
import models.Restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantService {
    RestaurantDao restaurantDaoInstance;
    ItemDao itemDaoInstance;
    public RestaurantService(){
        restaurantDaoInstance = RestaurantDao.getInstance();
        itemDaoInstance = ItemDao.getInstance();
    }

    public void registerRestaurant(String restaurantName, int processingCapacity, Menu menuCard){
        Restaurant restaurant = new Restaurant(restaurantName, processingCapacity, menuCard);
        restaurantDaoInstance.addRestaurant(restaurant);
    }

    public List<Restaurant> getAllRestaurants(){
        return restaurantDaoInstance.getRestaurants();
    }

    public void addMenuItem(String restaurantName, String itemName, Integer price){
        Restaurant restaurant = restaurantDaoInstance.getRestaurant(restaurantName);
        Item item = null;
        if(itemDaoInstance.checkIfItemExists(itemName)){
            item = itemDaoInstance.getItem(itemName);
        }
        else{
            item = itemDaoInstance.addItem(itemName);
        }

        restaurantDaoInstance.updateMenuItem(restaurant, item, price);
    }

    public void fetchMenu(String restaurantName){
        Restaurant restaurant = restaurantDaoInstance.getRestaurant(restaurantName);
        Menu menuCard = restaurant.getMenuCard();
        HashMap<Item, Integer> menumap = menuCard.getMenuItems();
        for(Map.Entry<Item, Integer> entry: menumap.entrySet()){
            Item item = entry.getKey();
            System.out.println(item.getItemName() + ": " + entry.getValue());
        }
    }

}
