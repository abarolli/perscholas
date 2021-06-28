package com.example;

public class AppSystem extends TheSystem {
    public AppSystem() {
    }

    @Override
    public void display() {
        // Your code here
        System.out.println("AppSystem Inventory:");
        final String tableFormat = "%-20s %-20s %-10s %-10s";
        final String columns = String.format(tableFormat, "Name", "Description", "Price", "Available Quantity");

        System.out.println(columns);

        for (Item item : getItemCollection().values()) {
            System.out.println(String.format(tableFormat, 
                                             item.getItemName(), 
                                             item.getItemDesc(), 
                                             String.format("%.2f", item.getItemPrice()), 
                                             item.getAvailableQuantity()));
        }
    }

    @Override      // this overwrites the parents class add method 
    public Boolean add(Item item) {
        // Your code here
        if (item == null) return false;


        if (getItemCollection().containsKey(item.getItemName())) {
            System.out.println(item.getItemName() + " is already in the App System");
            return false;
        }

        getItemCollection().put(item.getItemName(), item);
        return true;
    }

    public Item reduceAvailableQuantity(String item_name) {
        // Your code here
        Item item = getItemCollection().get(item_name);
        if (item != null) {
            item.setAvailableQuantity(item.getAvailableQuantity() - 1);
            if (item.getAvailableQuantity() <= 0) 
                getItemCollection().remove(item_name);
                
            return item;
        }

        return null;
    }
}
