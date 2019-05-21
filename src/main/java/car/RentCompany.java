package car;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private List<Car> cars = new ArrayList<>();

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        String report = "";
        for (Car car : cars) {
            report += car.getName() + " : " + car.getChargeQuantity() + "리터" + "\n";
        }
        return report;
    }
}
