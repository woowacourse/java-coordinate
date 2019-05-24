package com.woowa.rentcar.domain;

public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");

    private Cars cars;

    private RentCompany() {
        cars = Cars.create();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.addCar(car);
    }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName()).append(" : ").append((int) car.calculateFuel()).append("리터").append(NEWLINE);
        }
        return sb.toString();
    }
}
