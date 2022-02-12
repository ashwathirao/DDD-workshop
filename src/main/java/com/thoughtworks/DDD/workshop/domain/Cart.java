package com.thoughtworks.DDD.workshop.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cart {

    private final List<Item> items;
    private final List<Item> removedItems;
    private final String cartId;
    private boolean checkout;

    public Cart(String cartId) {
        this.cartId = cartId;
        this.items = new ArrayList<>();
        this.removedItems = new ArrayList<>();
        this.checkout=false;
    }

    public void addItems(Item item) {
        this.items.add(item);
    }

    public Integer getTotalItemCount() {
        return this.items.size();
    }

    public List<Item> getAllItems() {
        return this.items;
    }

    public void removeItem(Item item) {
        this.items.remove(item);
        this.removedItems.add(item);
    }

    public List<Item> getRemovedItems() {
        return this.removedItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(cartId, cart.cartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId);
    }

    public Price getProductPrice() {
        return (Price) getAllItems().stream().map(item -> item.getProduct().getPrice());
    }

    public Order checkout() {
        this.checkout = true;

        List<Product> list = getAllItems().stream().flatMap(item ->
            item.getProducts().stream()
        ).collect(Collectors.toList());
        return new Order(list);

    }
}

