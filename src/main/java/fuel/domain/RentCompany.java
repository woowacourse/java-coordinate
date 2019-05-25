package fuel.domain;

import java.util.ArrayList;
import java.util.List;

class RentCompany {
    private List<Car> cars;

    private RentCompany(List<Car> cars) {
        this.cars = cars;
    }

    static RentCompany create() {
        return new RentCompany(new ArrayList<>());
    }

    void addCar(Car car) {
        this.cars.add(car);
    }

    String generateReport() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName() + " : " + car.getFuel() + "리터" + System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}
