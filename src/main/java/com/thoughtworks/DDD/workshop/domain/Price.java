package com.thoughtworks.DDD.workshop.domain;

import java.util.Currency;
import java.util.Objects;

public class Price {
    private final Currency currency;
    private final float value;

    public Price(Currency currency, float value){
        this.currency = currency;
        this.value  = value;
    }
    public float getValue() {
        return value;
    }
    public Currency getCurrency() {
        return currency;
    }



}
