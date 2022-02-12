package com.thoughtworks.DDD.workshop.domain;

import java.util.Currency;

public class CompetitiveDiscountPriceStrategy implements PriceStrategy {

    CompetitorPrice competitorPrice = new CompetitorPrice();

    @Override
    public void getDiscountPriceForProduct(Product product) {
        Price priceOfCompetitorProduct = competitorPrice.getPriceByProduct(product.getName());

        float discountPrice = product.getPrice().getValue() - (0.1F * priceOfCompetitorProduct.getValue());
        Price discountPriceOfProduct = new Price(Currency.getInstance("INR"), discountPrice);

        product.setPrice(discountPriceOfProduct);
    }



}
