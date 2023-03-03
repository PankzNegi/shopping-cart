package com.pankz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ShoppingCart {

    private final Inventory inventory;
    private List<LineItem> itemsInCart = new ArrayList<>();

    public ShoppingCart(Inventory inventory) {
        this.inventory = inventory;
    }


    public void addItem(LineItem lineItem) {
        Item item = inventory.get(lineItem.getItemId());
        lineItem.setName(item.getName());
        lineItem.setPrice(item.getPrice());
        this.itemsInCart.add(lineItem);

    }

    public int totalNumberOfItems() {

        int totalItem = 0;
        for (LineItem lineItem : itemsInCart) {
            totalItem += lineItem.getQuantity();
        }
        return totalItem;
    }

    public void remove(LineItem lineItemToRemove) {
        boolean deleteLineItem = false;

        for (LineItem itemsInCart : itemsInCart) {
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
        this.itemsInCart.remove(lineItemToRemove);
}
}

    public List<LineItem> listItemInCart() {
        return  Collections.unmodifiableList(this.itemsInCart);
    }
}