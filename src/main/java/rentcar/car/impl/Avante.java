package rentcar.car.impl;

import rentcar.car.Car;

public class Avante implements Car {
    private static final String NAME = "Avante";
    private static final int DISTANCE_PER_LITTER = 15;

    private final int tripDistance;

    public Avante(int tripDistance) {
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
