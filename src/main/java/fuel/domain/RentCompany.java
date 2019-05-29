package fuel.domain;

import java.util.ArrayList;
import java.util.List;

class RentCompany {
    private List<AbstractCar> abstractCars;

    private RentCompany(List<AbstractCar> abstractCars) {
        this.abstractCars = abstractCars;
    }

    static RentCompany create() {
        return new RentCompany(new ArrayList<>());
    }

    void addCar(AbstractCar abstractCar) {
        this.abstractCars.add(abstractCar);
    }

    String generateReport() {
        StringBuilder sb = new StringBuilder();
        for (AbstractCar abstractCar : abstractCars) {
            sb.append(abstractCar.getName() + " : " + abstractCar.getFuel() + "리터" + System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}
