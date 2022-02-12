package com.thoughtworks.DDD.workshop.domain.shopping;

import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

public class CompetitorPrice {
    Map<String, Price> competitorPrice = new HashMap<>();
    public CompetitorPrice(){
        competitorPrice.put("Ipad", new Price(Currency.getInstance("INR"),40000F));
    }

    Price getPriceByProduct(String name) {
        return this.competitorPrice.get(name);
    }
}
