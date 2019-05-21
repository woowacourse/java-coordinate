package rentCar;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");
    private static final String LITER = "리터";

    private List<Car> cars;

    public static RentCompany create() {
        return new RentCompany();
    }

    private RentCompany() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();
        cars.forEach(car -> report.append(car.getName() + " : " + (int) car.getChargeQuantity() + LITER + NEWLINE));
        return report.toString();
    }
}
