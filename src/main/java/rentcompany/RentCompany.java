package rentcompany;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RentCompany {
    private final List<Car> cars = new ArrayList<>();

    public static RentCompany newInstance() {
        return new RentCompany();
    }

    List<Car> getCars() {
        return cars;
    }

    void addCar(Car car) {
        this.cars.add(car);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentCompany that = (RentCompany) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    String generateReport() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.generateReport());
        }
        return sb.toString();
    }
}
