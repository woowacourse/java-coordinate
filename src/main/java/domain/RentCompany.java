package domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private List<Car> cars;

    private RentCompany(List<Car> cars) {
        this.cars = cars;
    }


    public static RentCompany create() {
        return new RentCompany(new ArrayList<>());
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName() + " : " + car.getFuel() + "리터"+System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}
