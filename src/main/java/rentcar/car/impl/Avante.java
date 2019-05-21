package rentcar.car.impl;

import rentcar.car.Car;

public class Avante extends Car {
    private static final String NAME = "Avante";
    private static final int DISTANCE_PER_LITTER = 15;

    private final int tripDistance;

    public Avante(int tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    public double getDistancePerLitter() {
        return DISTANCE_PER_LITTER;
    }

    @Override
    public double getTripDistance() {
        return tripDistance;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
