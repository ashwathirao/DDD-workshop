package com.thoughtworks.DDD.workshop.domain.shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Item {

    private final Product product;

    public Integer getQuantity() {
        return quantity;
    }

    private Integer quantity;

    public Item(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            products.add(product);
        }
        return products;
    }

    public Item(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(product, item.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}
