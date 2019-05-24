package rentcar.car.impl;

import rentcar.car.Car;

public class K5 implements Car {
    private static final String NAME = "K5";
    private static final int DISTANCE_PER_LITTER = 13;

    private final int tripDistance;

    public K5(int tripDistance) {
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
