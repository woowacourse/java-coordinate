package com.woowa.rentcar;

public abstract class Car {
    private int distance;
    protected int mileage;

    protected Car(int distance) {
        this.distance = distance;
    }

    public abstract String getName();

    public int calculateFuel() {
        return distance / mileage;
    }
}
