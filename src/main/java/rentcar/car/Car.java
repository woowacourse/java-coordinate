package rentcar.car;

public abstract class Car implements Fuelable {
    private static final double MIN_TRIP_DISTANCE = 0;

    private final String name;
    private final double tripDistance;
    private final double distancePerLiter;

    Car(int tripDistance, String name, int distancePerLiter) {
        validateTripDistance(tripDistance);
        this.name = name;
        this.tripDistance = tripDistance;
        this.distancePerLiter = distancePerLiter;
    }

    private void validateTripDistance(int tripDistance) {
        if (tripDistance < MIN_TRIP_DISTANCE) {
            throw new IllegalArgumentException(MIN_TRIP_DISTANCE +" 이상의 이동거리가 필요합니다.");
        }
    }

    private double getDistancePerLiter() {
        return distancePerLiter;
    }

    private double getTripDistance() {
        return tripDistance;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}