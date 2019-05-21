package rentCar;

abstract class Car {
    private static final double MIN_TRIP_DISTANCE = 0;

    private final double tripDistance;
    private final String name;
    private final double distancePerLiter;

    Car(int tripDistance, String name, int distancePerLiter) {
        validateTripDistance(tripDistance);
        this.tripDistance = tripDistance;
        this.name = name;
        this.distancePerLiter = distancePerLiter;
    }

    private void validateTripDistance(int tripDistance) {
        if (tripDistance < MIN_TRIP_DISTANCE) {
            throw new IllegalArgumentException("0 이상의 이동거리가 필요합니다.");
        }
    }

    private double getDistancePerLiter() {
        return distancePerLiter;
    }

    private double getTripDistance() {
        return tripDistance;
    }

    String getName() {
        return name;
    }

    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}