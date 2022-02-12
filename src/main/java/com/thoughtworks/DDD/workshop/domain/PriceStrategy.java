package com.thoughtworks.DDD.workshop.domain;

public interface PriceStrategy {
    float getDiscountPriceForProduct(Product product);
}
