package fuel.domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private final List<AbstractCar> cars;

    private RentCompany(final List<AbstractCar> cars) {
        this.cars = cars;
    }

    public static RentCompany create() {
        return new RentCompany(new ArrayList<>());
    }

    public void addCar(AbstractCar car) {
        this.cars.add(car);
    }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        for (AbstractCar car : cars) {
            sb.append(car.getName() + " : " + car.getFuelEfficiency() + "리터"+System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}
