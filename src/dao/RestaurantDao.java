package dao;

import models.Item;
import models.Menu;
import models.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantDao {
    private static RestaurantDao restaurantDaoInstance;
    HashMap<String, Restaurant> restaurantMap;

    private RestaurantDao(){
        this.restaurantMap = new HashMap<>();
    }
    public static RestaurantDao getInstance(){
        if(restaurantDaoInstance == null){
            restaurantDaoInstance = new RestaurantDao();
        }
        return restaurantDaoInstance;
    }

    public void addRestaurant(Restaurant restaurant){
        this.restaurantMap.put(restaurant.getRestaurantName(), restaurant);
    }

    public Restaurant getRestaurant(String restaurantName){
        return restaurantMap.get(restaurantName);
    }

    public List<Restaurant> getRestaurants(){
        List<Restaurant> allRest = new ArrayList<>();
        for(Map.Entry<String, Restaurant>entry: restaurantMap.entrySet()){
            allRest.add(entry.getValue());
        }
        return allRest;
    }


    public void updateMenuItem(Restaurant restaurant, Item item, Integer price){
        Menu menuCard = restaurant.getMenuCard();
        menuCard.addItem(item, price);
    }


}
