package rentcompany;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private List<Car> cars = new ArrayList<>();

    private RentCompany() {}

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
            stringBuilder.append((int) car.getChargeQuantity()); // type casting
            stringBuilder.append("리터\n");
        }

        return stringBuilder.toString();
    }
}
