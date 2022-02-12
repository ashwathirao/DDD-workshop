package com.thoughtworks.DDD.workshop.domain.shopping;

public interface PriceStrategy {
    float getDiscountPriceForProduct(Product product);
}
