package RentCompany;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RentCompany {
    private final List<Car> cars = new ArrayList<Car>();

    public RentCompany() {
        cars.add(new Sonata(150));
        cars.add(new K5(260));
        cars.add(new Sonata(120));
        cars.add(new Avante(300));
        cars.add(new K5(390));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
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

    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.generateReport());
        }
        return sb.toString();
    }
}
