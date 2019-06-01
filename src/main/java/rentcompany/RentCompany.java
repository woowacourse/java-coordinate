package rentcompany;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heebg
 * @version 1.0 2019-05-21
 */
public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");
    private List<Car> cars;

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
        StringBuilder expectedFuelInfo = new StringBuilder();
        for (Car car : cars) {
            expectedFuelInfo.append(car.getName());
            expectedFuelInfo.append(" : ");
            expectedFuelInfo.append((int)car.getChargeQuantity());
            expectedFuelInfo.append("리터");
            expectedFuelInfo.append(NEWLINE);
        }
        return expectedFuelInfo.toString();
    }
}
