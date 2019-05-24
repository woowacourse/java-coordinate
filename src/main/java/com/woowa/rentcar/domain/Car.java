package com.woowa.rentcar.domain;

public abstract class Car {
    private Distance distance;
    protected int mileage;

    protected Car(Distance distance) {
        this.distance = distance;
    }

    public abstract String getName();

    public double calculateFuel() {
        return (double) distance.getDistance() / mileage;
    }
}
