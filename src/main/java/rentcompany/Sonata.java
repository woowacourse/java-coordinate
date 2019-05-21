package rentcompany;

public class Sonata {
    private static final double DISTANCE_PER_LITER = 10;
    private static final double MIN_DISTANCE = 1;
    private double tripDistance;

    public Sonata(double tripDistance) {
        validateDistance(tripDistance);
        this.tripDistance = tripDistance;
    }

    private void validateDistance(double tripDistance) {
        if (tripDistance < MIN_DISTANCE) {
            throw new IllegalArgumentException("양수를 입력해야 합니다");
        }
    }

    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }

    private double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    private double getTripDistance() {
        return tripDistance;
    }
}
