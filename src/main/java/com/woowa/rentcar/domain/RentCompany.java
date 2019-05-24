package com.woowa.rentcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");

    private List<Car> cars;

    private RentCompany() {
        cars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        for (Car aCar : cars) {
            sb.append(aCar.getName()).append(" : ").append((int) aCar.calculateFuel()).append("리터").append(NEWLINE);
        }
        return sb.toString();
    }
}
