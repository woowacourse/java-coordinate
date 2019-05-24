package com.woowa.rentcar;

public abstract class Car {
    private int distance;

    protected Car(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public abstract String getName();

    public abstract int getFuel();

    public abstract int caculateMileage();
}
