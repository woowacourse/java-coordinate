package rentcar.car;

public abstract class Car {
    public abstract double getDistancePerLitter();

    public abstract double getTripDistance();

    public abstract String getName();

    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLitter();
    }

    public String toString() {
        return getName() + " : " + (int) getChargeQuantity() + "리터";
    }
}
