package car.domain;

public abstract class AbstractCar {
    double distance;
    double fuelEfficiency;

    abstract String getName();

    double getChargeQuantity() {
        return distance / fuelEfficiency;
    }
}
