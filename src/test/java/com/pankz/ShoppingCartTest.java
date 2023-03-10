
package com.pankz;

import java.math.BigDecimal;
import java.util.List;

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
        cart = new ShoppingCart(inventory);
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

    @Test
    public void should_remove_an_item_from_cart() {
        cart.addItem(new LineItem("item-1"));
        cart.addItem(new LineItem("item-2"));
        cart.remove(new LineItem("item-1"));
        int totalItemCount = cart.totalNumberOfItems();
        Assertions.assertThat(totalItemCount).isEqualTo(1);

    }

    @Test
    public void should_remove_specific_quantity_of_an_item_from_cart() {
        cart.addItem(new LineItem("item-1", 4));
        cart.addItem(new LineItem("item-2", 3));
        cart.remove(new LineItem("item-1", 2));
        cart.remove(new LineItem("item-2", 1));
        int totalItemCount = cart.totalNumberOfItems();
        Assertions.assertThat(totalItemCount).isEqualTo(4);

    }
    @Test
    public  void should_vie_listing_of_items_in_the_cart()
    {
        cart.addItem(new LineItem("item-1",4));
        cart.addItem(new LineItem("item-2",3));
       List<LineItem> lineItems= cart.listItemInCart();
       Assertions.assertThat(lineItems.get(0).totalPrice()).isEqualTo(BigDecimal.valueOf(16000));
        Assertions.assertThat(lineItems.get(1).totalPrice()).isEqualTo(BigDecimal.valueOf(750));
    }
    @Test
    public void should_increase_quantity_of_the_item_when_same_is_added_multiple_time()
    {
        cart.addItem(new LineItem("item-1",4));
        cart.addItem(new LineItem("item-1",3));
        int totalItemCount=cart.totalNumberOfItems();
        Assertions.assertThat(totalItemCount).isEqualTo(7);
        cart.remove(new LineItem("item-1",6));
        totalItemCount=cart.totalNumberOfItems();
        Assertions.assertThat(totalItemCount).isEqualTo(1);

    }

}