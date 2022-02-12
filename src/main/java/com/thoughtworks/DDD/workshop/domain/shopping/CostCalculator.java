package com.thoughtworks.DDD.workshop.domain.shopping;

import java.util.Currency;

public class CostCalculator {

    public Price calculate(Order order) {
        return new Price(Currency.getInstance("INR"), order.getProductList().stream().map(product -> {
            Price price = product.getPrice();
            double weightPrice = product.getWeight().getValue() * 0.01;
            price.increaseBy(Float.parseFloat(String.valueOf(weightPrice)));
            return price;
        }).mapToInt(value -> (int) value.getValue()).sum());
    }
}
