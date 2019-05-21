package rentcar.car.impl;

import rentcar.car.Car;

public class K5 extends Car {
    private static final String NAME = "K5";
    private static final int DISTANCE_PER_LITTER = 13;

    private final int tripDistance;

    public K5(int tripDistance) {
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
