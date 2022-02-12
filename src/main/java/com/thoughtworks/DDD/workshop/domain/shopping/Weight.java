package com.thoughtworks.DDD.workshop.domain.shopping;

enum WeightType {
    KG,GMS,MGS
}

public class Weight {
    private final WeightType type;
    private final float value;

    public Weight(float value) {
        this.type = WeightType.GMS;
        this.value = value;
    }
    public Weight(WeightType type, float value) {
        this.type = type;
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
