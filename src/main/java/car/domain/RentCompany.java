package car.domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");
    private List<AbstractCar> abstractCars = new ArrayList<>();

    private RentCompany() {
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(AbstractCar abstractCar) {
        abstractCars.add(abstractCar);
    }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        for (AbstractCar abstractCar : abstractCars) {
            sb.append(abstractCar.getName()).append(" : ").append((int) abstractCar.getChargeQuantity()).append("리터" + NEWLINE);
        }
        return sb.toString();
    }
}
