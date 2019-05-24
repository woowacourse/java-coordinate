package com.woowa.rentcar.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car> {
    private List<Car> cars;

    private Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars create() {
        return new Cars();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
