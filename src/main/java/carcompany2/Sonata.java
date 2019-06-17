package carcompany2;

public class Sonata implements Car {
    private static final double DISTANCE_PRE_LITER = 10;

    private final double tripDistance;

    public Sonata(final double tripDistance) {
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
