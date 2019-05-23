package rent;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");

    private List<ICar> ICars;

    public RentCompany() {
        ICars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        for (ICar car : ICars) {
            sb.append(car.getName());
            sb.append(" : ");
            sb.append((int) car.getChargeQuantity());
            sb.append("리터");
            sb.append(NEWLINE);
        }
        return sb.toString();
    }

    public void addCar(ICar ICar) {
        ICars.add(ICar);
    }
}
