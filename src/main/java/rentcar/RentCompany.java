package rentcar;

import rentcar.car.Car;

import java.util.ArrayList;
import java.util.List;

public class RentCompany implements Reportable {
    private static final String LITER = "리터";

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

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        cars.forEach(car -> report.append(car.getName() + " : " + (int) car.getChargeQuantity() + LITER + NEWLINE));
        return report.toString();
    }
}
