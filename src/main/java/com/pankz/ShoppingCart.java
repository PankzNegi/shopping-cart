package com.pankz;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> itemsInCart=new ArrayList<>();

    public void addItem(Item item) {
        this.itemsInCart.add(item);

    }

    public int totalNumberOfItems() {
        return  itemsInCart.size();
    }
}
