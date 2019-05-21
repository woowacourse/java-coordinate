package rentcompany;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private List<Car> cars;

    private RentCompany(){
        this.cars=new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder();
        cars.forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

}
