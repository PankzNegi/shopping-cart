
package com.pankz;

import java.math.BigDecimal;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {
    private Inventory inventory;
    private ShoppingCart cart;



    @Before
    public void setUp() throws Exception {
        Item item1 = (new Item.Builder()).withId("item-1").withItemType(ItemType.BOOK).withName("Effective Java").withPrice(BigDecimal.valueOf(4000L)).build();
        Item item2 = (new Item.Builder()).withId("item-2").withItemType(ItemType.PEN).withName("Pen").withPrice(BigDecimal.valueOf(40L)).build();
        inventory = new Inventory();
        inventory.add(item1);
        inventory.add(item2);
        cart=new ShoppingCart(inventory);
    }

    @Test
    public void should_add_an_item_to_a_cart() {

        cart.addItem(new LineItem("item-1"));
        int totalItemCount = cart.totalNumberOfItems();
        Assertions.assertThat(totalItemCount).isEqualTo(1);
    }

    @Test
    public void should_add_multiple_item_to_the_cart() {

        cart.addItem(new LineItem("item-1"));
        cart.addItem(new LineItem("item-2"));
        int totalItemCount = cart.totalNumberOfItems();
        Assertions.assertThat(totalItemCount).isEqualTo(2);
    }

    @Test
    public void should_add_multiple_quantity_of_the_same_item_to_the_cart() {
       
        cart.addItem(new LineItem("item-1", 2));
        int totalItemCount = cart.totalNumberOfItems();
        Assertions.assertThat(totalItemCount).isEqualTo(2);
    }
}