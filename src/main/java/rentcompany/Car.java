package rentcompany;

abstract class Car {
    private static final double MIN_DISTANCE = 1;
    double tripDistance;

    Car(double tripDistance) {
        validateDistance(tripDistance);
        this.tripDistance = tripDistance;
    }

    private void validateDistance(double tripDistance) {
        if (tripDistance < MIN_DISTANCE) {
            throw new IllegalArgumentException("양수를 입력해야 합니다");
        }
    }

    abstract String getName();

    abstract double getDistancePerLiter();

    abstract double getTripDistance();

    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
