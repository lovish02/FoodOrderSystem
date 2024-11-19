package models;

import java.util.UUID;

public class Item {
    String itemId;
    String itemName;

    public Item(String itemName){
        this.itemId = UUID.randomUUID().toString();
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
