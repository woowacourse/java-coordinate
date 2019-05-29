package rantCar.domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");
    private List<Car> cars;

    RentCompany() {
        cars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(RentCar car) {
        cars.add(car);
    }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName())
                    .append(" : ")
                    .append((int) car.getChargeQuantity())
                    .append("리터")
                    .append(NEWLINE);
        }
        return sb.toString();
    }
}
