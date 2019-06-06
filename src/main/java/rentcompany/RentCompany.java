package rentcompany;

import java.util.ArrayList;
import java.util.List;

class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");

    private List<Car> rentCars;

    private RentCompany() {
        rentCars = new ArrayList<>();
    }

    static RentCompany create() {
        return new RentCompany();
    }

    void addCar(Car car) {
        rentCars.add(car);
    }

    String generateReport() {
        StringBuilder report = new StringBuilder();
        for (Car rentCar : rentCars) {
            report.append(generateReportLine(rentCar));
        }
        return report.toString();
    }

    private String generateReportLine(Car rentCar) {
        return rentCar.getName() + " : " + (int) Math.ceil(rentCar.getChargeQuantity()) + "리터" + NEWLINE;
    }
}
