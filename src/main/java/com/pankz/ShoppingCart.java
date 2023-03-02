package com.pankz;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final Inventory inventory;
    private List<LineItem> itemsInCart=new ArrayList<>();
    public ShoppingCart(Inventory inventory)
    {
        this.inventory=inventory;
    }

    public void addItem(LineItem lineItem) {
        this.itemsInCart.add(lineItem);

    }

    public int totalNumberOfItems() {
        int totalItem=0;
        for(LineItem lineItem: itemsInCart)
        {
            totalItem+= lineItem.getQuantity();
        }
        return totalItem;
    }
}
