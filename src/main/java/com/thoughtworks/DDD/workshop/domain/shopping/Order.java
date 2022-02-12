package com.thoughtworks.DDD.workshop.domain.shopping;

import java.util.List;

public class Order {
    private final List<Product> productList;

    public Order(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
