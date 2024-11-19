package dao;

import models.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemDao {
    private static ItemDao itemDaoInstance;
    HashMap<String, Item> itemMap;

    private ItemDao(){
        this.itemMap = new HashMap<>();
    }

    public static ItemDao getInstance(){
        if(itemDaoInstance == null){
            itemDaoInstance = new ItemDao();
        }
        return itemDaoInstance;
    }

    public Item addItem(String itemName){
        Item item = new Item(itemName);
        itemMap.put(itemName, item);
        return item;
    }

    public List<Item> getAllItems(){
        List<Item> itemList = new ArrayList<>();
        for(Map.Entry<String, Item> ele: itemMap.entrySet()){
            itemList.add(ele.getValue());
        }
        return itemList;
    }

    public Item getItem(String itemName){
        return itemMap.get(itemName);
    }

    public boolean checkIfItemExists(String item){
        return itemMap.containsKey(item);
    }
//    public bool checkIfItemExists(String Item)

}
