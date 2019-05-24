package com.woowa.rentcar;

public class Avante extends Car {
    private static final String NAME = "Avante";

    public Avante(int distance) {
        super(distance);
        super.mileage = 15;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
