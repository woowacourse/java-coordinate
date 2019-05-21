package rentcar.rentcompany;

import rentcar.car.Car;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String NEW_LINE = System.getProperty("line.separator");

    private List<Car> cars = new ArrayList<>();

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder();
        cars.stream().forEach(car -> stringBuilder.append(car).append(NEW_LINE));
        return stringBuilder.toString();
    }
}
