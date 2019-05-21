package rentcar.car.impl;

import rentcar.car.Car;

public class Sonata extends Car {
    private static final String NAME = "Sonata";
    private static final int DISTANCE_PER_LITTER = 10;

    private final int tripDistance;

    public Sonata(int tripDistance) {
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
