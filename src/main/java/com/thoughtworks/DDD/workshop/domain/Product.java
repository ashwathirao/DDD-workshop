package com.thoughtworks.DDD.workshop.domain;

import java.util.Currency;
import java.util.Objects;

public class Product {
    private final String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private Price price;

    public Product(String name, Price price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }


    public void setPrice(Price priceOfCompetitorProduct) {
        this.price = priceOfCompetitorProduct;
    }
}