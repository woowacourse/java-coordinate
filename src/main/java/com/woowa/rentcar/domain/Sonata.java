package com.woowa.rentcar.domain;

public class Sonata extends Car {
    private static final String NAME = "Sonata";

    public Sonata(int distance) {
        super(distance);
        super.mileage = 10;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
