package rentcar;

import rentcar.car.Car;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    private final List<Car> cars;

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
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.getName());
            stringBuilder.append(" : ");
            stringBuilder.append(DECIMAL_FORMAT.format(car.getChargeQuantity()));
            stringBuilder.append("리터");
            stringBuilder.append(NEWLINE);
        }
        return stringBuilder.toString();
    }
}
