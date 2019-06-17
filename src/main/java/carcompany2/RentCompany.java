package carcompany2;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final List<Car> cars;

    private RentCompany() {
        this.cars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        StringBuffer buffer = new StringBuffer();
        for (Car car : cars) {
            buffer.append(car.getName())
                    .append(" : ")
                    .append((int) car.getChargeQuantity() + "리터")
                    .append(NEWLINE);
        }

        return buffer.toString();
    }
}
