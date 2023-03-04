package com.pankz;

import java.util.*;

public class ShoppingCart {

    private final Inventory inventory;
    private Map<String,LineItem> itemsInCart = new LinkedHashMap();

    public ShoppingCart(Inventory inventory) {
        this.inventory = inventory;
    }


    public void addItem(LineItem lineItem) {
        if (itemsInCart.containsKey(lineItem.getItemId())) {
            LineItem lineItemInCart = itemsInCart.get(lineItem.getItemId());
            lineItemInCart.increaseQuantityBy(lineItem.getQuantity());
        } else {
            Item item = inventory.get(lineItem.getItemId());
            lineItem.setName(item.getName());
            lineItem.setPrice(item.getPrice());
            this.itemsInCart.put(lineItem.getItemId(), lineItem);

        }
    }

    public int totalNumberOfItems() {

        int totalItem = 0;
        for (LineItem lineItem : itemsInCart.values()) {
            totalItem += lineItem.getQuantity();
        }
        return totalItem;
    }

    public void remove(LineItem lineItemToRemove) {
        boolean deleteLineItem = false;

        for (LineItem itemsInCart : itemsInCart.values()) {
            if (Objects.equals(itemsInCart.getItemId(), lineItemToRemove.getItemId())) {
                if (lineItemToRemove.getQuantity() == itemsInCart.getQuantity()) {
                    deleteLineItem = true;
                }

            else {
                itemsInCart.reduceQuantityBy(lineItemToRemove.getQuantity());
            }
        }
    }
        if(deleteLineItem)
        {
        this.itemsInCart.remove(lineItemToRemove.getItemId());
}
}

    public List<LineItem> listItemInCart() {
        return  Collections.unmodifiableList(new ArrayList<>(this.itemsInCart.values()));
    }
}