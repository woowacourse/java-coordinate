package com.woowa.rentcar.domain;

public abstract class Car {
    private int distance;
    protected int mileage;

    protected Car(int distance) {
        this.distance = distance;
    }

    public abstract String getName();

    public double calculateFuel() {
        return (double) distance / mileage;
    }
}
