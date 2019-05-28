package rentcar.car.impl;

import rentcar.car.Car;

public class Sonata implements Car {
    private static final String NAME = "Sonata";
    private static final int DISTANCE_PER_LITTER = 10;

    private final int tripDistance;

    public Sonata(int tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    public double getTripDistance() {
        return tripDistance;
    }

    @Override
    public double getChargeQuantity() {
        return getTripDistance() / DISTANCE_PER_LITTER;
    }

    @Override
    public String toString() {
        return NAME + " : " + (int) getChargeQuantity() + "리터";
    }
}
