package car;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private List<Car> cars = new ArrayList<>();

    public static RentCompany create() {
        return new RentCompany();
    }

    private RentCompany() {};

    public RentCompany addCar(Car car) {
        cars.add(car);
        return this;
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();
        cars.forEach(car -> {
            report.append(car.getName() + " : " + car.getChargeQuantity() + "리터\n");
        });
        return report.toString();
    }

}
