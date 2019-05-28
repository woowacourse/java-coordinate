package carcompany2;

public interface Car {
    String getName();

    double getDistancePerLiter();

    double getTripDistance();

    default double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
