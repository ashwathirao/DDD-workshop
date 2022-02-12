package com.thoughtworks.DDD.workshop.domain.shopping;

import java.util.List;

public class Order {
    private final List<Product> productList;
    private Price cost;

    public Order(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Price getCost() {
        return cost;
    }

    public void setCost(Price cost) {
        this.cost = cost;
    }
}
