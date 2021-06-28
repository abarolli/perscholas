package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public abstract class TheSystem {
   
    private HashMap<String, Item> itemCollection;

    public TheSystem() {
        // Your code here
        itemCollection = new HashMap<String, Item>();
        if (getClass().getSimpleName().equals("AppSystem")) {

            File f = new File("resources\\sample.txt");
            try (
                Scanner myReader = new Scanner(f);
            ) {
                while (myReader.hasNextLine()) {
                    String[] itemProperties = myReader.nextLine().split("  ");
                    Item newItem = new Item(itemProperties[0],
                                            itemProperties[1], 
                                            Double.valueOf(itemProperties[2]), 
                                            Integer.valueOf(itemProperties[3]));
                    
                    itemCollection.put(newItem.getItemName(), newItem);
                }
            }
            catch (FileNotFoundException ex) {
                //
            }
        }
    }
    
    public HashMap<String, Item> getItemCollection(){
        // Your code here
        return itemCollection;
    }
    
    public Boolean checkAvailability(Item item) {
        // Your code here
        if (item == null) return false;

        if (item.getQuantity() >= item.getAvailableQuantity()) {
            System.out.println(
                String.format("System is unable to add %s to the cart. System only has %s %ss.", item.getItemName(), item.getAvailableQuantity(), item.getItemName())
            );

            return false;
        }
        
        return true;
    }
    
    public Boolean add(Item item) {
        // Your code here
        if (item == null) return false;

        if (itemCollection.containsKey(item.getItemName())) {
            item.setQuantity(item.getQuantity() + 1);
            return true;
        }

        if (!itemCollection.containsKey(item.getItemName())) {
            itemCollection.put(item.getItemName(), item);
            return true;
        }

        return false;
    }

    public Item remove(String itemName) {
        // Your code here
        if (itemCollection.containsKey(itemName))
            return itemCollection.remove(itemName);

        return null;
    }

    public abstract void display();
}
