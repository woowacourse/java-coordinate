package com.woowa.rentcar.domain;

public class K5 extends Car {
    private static final String NAME = "K5";

    public K5(int distance) {
        super(distance);
        super.mileage = 13;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
