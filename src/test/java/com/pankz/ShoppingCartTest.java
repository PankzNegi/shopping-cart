package com.pankz;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ShoppingCartTest {

    @Test
    public  void should_add_an_item_to_a_cart()
    {
        ShoppingCart cart=new ShoppingCart();
        cart.addItem(new Item.Builder().withId("item-1").withItemType(ItemType.BOOK).withName("Effective Java").withPrice(BigDecimal.valueOf(4000)).build());
        int totalItemCount=cart.totalNumberOfItems();
        Assertions.assertThat(totalItemCount).isEqualTo(1);
    }
    @Test
    public void should_add_multiple_item_to_the_cart()
    {
        ShoppingCart cart=new ShoppingCart();
        cart.addItem(new Item.Builder().withId("item-1").withItemType(ItemType.BOOK).withName("Effective Java").withPrice(BigDecimal.valueOf(4000)).build());

        cart.addItem(new Item.Builder().withId("item-2").withItemType(ItemType.PEN).withName("Pen").withPrice(BigDecimal.valueOf(40)).build());
        int totalItemCount=cart.totalNumberOfItems();
        Assertions.assertThat(totalItemCount).isEqualTo(2);
    }
    @Test
    public void should_add_multiple_quantity_of_the_same_item_to_the_cart()
    {
        ShoppingCart cart=new ShoppingCart();
        cart.addItem(new Item.Builder().withId("item-1").withItemType(ItemType.PEN).withName("Pen").withPrice(BigDecimal.valueOf(40)).build());
        int totalItemCount=cart.totalNumberOfItems();
        Assertions.assertThat(totalItemCount).isEqualTo(2);
    }

}