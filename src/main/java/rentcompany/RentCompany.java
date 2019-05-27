package rentcompany;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private List<CarImpl> carImpls;

    private RentCompany() {
        this.carImpls = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(CarImpl carImpl) {
        carImpls.add(carImpl);
    }

    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder();
        carImpls.forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

}
