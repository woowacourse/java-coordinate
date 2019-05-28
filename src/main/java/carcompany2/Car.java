package carcompany2;

public interface Car {
    default String getName() {
        return getClass().getSimpleName();
    }

    double getDistancePerLiter();

    double getTripDistance();

    default double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
