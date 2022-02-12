package com.thoughtworks.DDD.workshop.domain.shopping;

import java.util.Objects;

public class Product {
    private final String name;
    private final Weight weight;
    private Price price;


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

    public Product(String name, Price price, Weight weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public Product(String name, Price price) {
        this.name = name;
        this.price = price;
        this.weight = new Weight(500);
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

    public Weight getWeight() {
        return weight;
    }
}
