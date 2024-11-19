import models.Restaurant;
import service.RestaurantService;
import service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RestaurantService restaurantService = new RestaurantService();
        UserService userService = new UserService();
        userService.addUser("Lovish", "9373996921");
        restaurantService.registerRestaurant("Abc", 60, null);
        restaurantService.registerRestaurant("PQR", 20, null);
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        restaurantService.addMenuItem("Abc", "panner", 100);
        restaurantService.fetchMenu("Abc");
        restaurantService.addMenuItem("PQR", "Soyabeen", 80);
        restaurantService.fetchMenu("PQR");
        Map<String, Integer> myOrder = new HashMap<>();
        myOrder.put("panner", 2);
        String orderId = userService.placeOrder("Lovish", myOrder);
        System.out.println(orderId);


    }
}