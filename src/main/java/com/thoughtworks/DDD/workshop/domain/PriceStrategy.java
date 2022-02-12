package com.thoughtworks.DDD.workshop.domain;

public interface PriceStrategy {
    void getDiscountPriceForProduct(Product product);
}
