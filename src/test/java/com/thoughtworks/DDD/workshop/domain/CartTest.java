package com.thoughtworks.DDD.workshop.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;


public class CartTest {

    @Test
    public void shouldAddAnIpadProToTheCart() {
        Cart cart = new Cart("cartId");
        cart.addItems(new Item(new Product("Ipad Pro",new Price(Currency.getInstance("INR"), 50000.0F)), 1));
        List<Item> allItems = cart.getAllItems();
        Assertions.assertEquals(1, allItems.size());
        Assertions.assertEquals(new Item(new Product("Ipad Pro",new Price(Currency.getInstance("INR"), 50000.0F)), 1), allItems.get(0));
    }

    @Test
    public void shouldAddAnHeroInkPenToTheCart() {

        Cart cart = new Cart("cartId");
        cart.addItems(new Item(new Product("Hero Ink Pen",new Price(Currency.getInstance("INR"), 50.0F)), 1));
        List<Item> allItems = cart.getAllItems();
        Assertions.assertEquals(1, allItems.size());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(new Product("Hero Ink Pen",new Price(Currency.getInstance("INR"), 50.0F)), 1));
        Assertions.assertEquals(expected, allItems);
    }

    @Test
    public void shouldAddTwoGMCricketBatToTheCart() {

        Cart cart = new Cart("cartId");
        cart.addItems(new Item(new Product("GM Cricket Bat",new Price(Currency.getInstance("INR"), 4000.0F)), 2));
        Assertions.assertEquals(1, cart.getTotalItemCount());
    }

    @Test
    public void shouldRemoveAnIpadProToTheCart() {
        Cart cart = new Cart("cartId");
        cart.addItems(new Item(new Product("Ipad Pro",new Price(Currency.getInstance("INR"), 50000.0F)), 1));
        cart.addItems(new Item(new Product("GM Cricket Bat",new Price(Currency.getInstance("INR"), 4000.0F)), 1));
        Assertions.assertEquals(2, cart.getTotalItemCount());
        cart.removeItem(new Item(new Product("Ipad Pro",new Price(Currency.getInstance("INR"), 50000.0F))));
        Assertions.assertEquals(1, cart.getTotalItemCount());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(new Product("GM Cricket Bat",new Price(Currency.getInstance("INR"), 4000.0F)), 1));
        Assertions.assertEquals(expected, cart.getAllItems());
    }

    @Test
    public void shouldFindListOfRemovedProductName() {
        Cart cart = new Cart("cartId");
        cart.addItems(new Item(new Product("Ipad Pro",new Price(Currency.getInstance("INR"), 50000.0F)), 1));
        cart.addItems(new Item(new Product("GM Cricket Bat",new Price(Currency.getInstance("INR"), 4000.0F)), 1));
        cart.removeItem(new Item(new Product("Ipad Pro", new Price(Currency.getInstance("INR"), 50000.0F))));
        List<Item> removedItems = cart.getRemovedItems();
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(new Product("Ipad Pro", new Price(Currency.getInstance("INR"), 50000.0F))));
        Assertions.assertEquals(expected, removedItems);
        Assertions.assertEquals(List.of("Ipad Pro"), removedItems.stream().map(item -> item.getProduct().getName()).collect(Collectors.toList()));
    }

    @Test
    public void shouldReturnFalseForTwoCartsWithSameItems() {
        Cart cart1 = new Cart("cartId1");
        Cart cart2 = new Cart("cartId2");
        Item item1 = new Item(new Product("Ipad", new Price(Currency.getInstance("INR"), 50000.0F)), 1);
        Item item2 = new  Item(new Product("Ipad", new Price(Currency.getInstance("INR"), 50000.0F)), 1);
        cart1.addItems(item1);
        cart2.addItems(item2);
        Assertions.assertFalse(cart1.equals(cart2));
    }

    @Test
    public void shouldAddPriceToTheProduct(){
        Cart cart1 = new Cart("cartId1");
        Item item1 = new Item(new Product("Ipad", new Price(Currency.getInstance("INR"), 50000.0F)), 1);
        cart1.addItems(item1);
//        Assertions.assertEquals(cart1.getProductPrice(),new Price(Currency.getInstance("INR"), 50000.0F));
    }

    @Test
    public void shouldCheckOutTheCartAndReturnTheListOfProducts(){
        Cart cart1 = new Cart("cartId1");
        Item item1 = new Item(new Product("Ipad", new Price(Currency.getInstance("INR"), 50000.0F)), 1);
        Item item2 = new Item(new Product("GM Cricket Bat", new Price(Currency.getInstance("INR"), 4000.0F)), 2);
        cart1.addItems(item1);
        cart1.addItems(item2);
        Order order = cart1.checkout();
        Assertions.assertEquals();

    }

}