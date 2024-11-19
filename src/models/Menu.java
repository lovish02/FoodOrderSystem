package models;

import java.util.HashMap;
import java.util.UUID;

public class Menu {
    String menuId;
    HashMap<Item, Integer> menuItems;

    public Menu(){
        this.menuId = UUID.randomUUID().toString();
        this.menuItems = new HashMap<>();
    }
    public Menu(HashMap<Item, Integer> itemPrice) {
        this.menuId = UUID.randomUUID().toString();
        this.menuItems = itemPrice;
    }

    public HashMap<Item, Integer> getMenuItems() {
        return menuItems;
    }

    public void addItem(Item item, Integer price){
        menuItems.put(item, price);
    }
}
