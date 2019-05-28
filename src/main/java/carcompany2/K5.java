package carcompany2;

public class K5 implements Car {
    private static final double DISTANCE_PRE_LITER = 13;

    private final double tripDistance;

    public K5(final double tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    public double getDistancePerLiter() {
        return DISTANCE_PRE_LITER;
    }

    @Override
    public double getTripDistance() {
        return tripDistance;
    }
}
