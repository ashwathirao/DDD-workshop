package com.thoughtworks.DDD.workshop.domain.shopping;

import org.junit.jupiter.api.Test;

import java.util.Currency;

public class PriceStrategyTest {
    @Test
    public void shouldSetDiscountPriceToProduct(){
        Cart cart1 = new Cart("cartId1");
        Item item1 = new Item(new Product("Ipad", new Price(Currency.getInstance("INR"), 50000.0F)), 1);
        cart1.addItems(item1);
        new CompetitiveDiscountPriceStrategy().getDiscountPriceForProduct(new Product("Ipad", new Price(Currency.getInstance("INR"), 50000.0F)));
    }
}
