package rentcompany;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String COLON = " : ";
    private static final String LITER = "리터";
    private static final String NEXT_LINE = "\n";
    private List<Car> cars = new ArrayList<>();

    private RentCompany() {}

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(final Car car) {
        cars.add(car);
    }

    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Car car : cars) {
            stringBuilder.append(car.getName())
                    .append(COLON)
                    .append((int) car.getChargeQuantity())
                    .append(LITER)
                    .append(NEXT_LINE);
        }

        return stringBuilder.toString();
    }
}
