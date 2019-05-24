package com.woowa.rentcar;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");

    private List<Car> list;

    private RentCompany() {
        list = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        list.add(car);
    }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        for (Car aCar : list) {
            sb.append(aCar.getName()).append(" : ").append(aCar.calculateFuel()).append("리터").append(NEWLINE);
        }
        return sb.toString();
    }
}
