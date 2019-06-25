package com.woowa.rentcar.domain;

public class Avante extends Car {
    private static final String NAME = "Avante";

    public Avante(Distance distance) {
        super(distance);
        super.mileage = 15;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
