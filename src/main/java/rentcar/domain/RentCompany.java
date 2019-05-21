package rentcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");

    private static List<Car> cars;
    private RentCompany() {
        cars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public static void addCar(Car car) {
        cars.add(car);
    }

    public static List<Car> getCars(){
        return cars;
    }

    public String generateReport(){
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.toString());
            sb.append(NEWLINE);
        }
        return sb.toString();
    }
}
