package rentcompany;

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
        String report = "";
        for (Car car : cars) {
            report += car.getName() + " : " + (int) car.getChargeQuantity() + "리터" + NEWLINE;
        }
        return report;
    }
}
