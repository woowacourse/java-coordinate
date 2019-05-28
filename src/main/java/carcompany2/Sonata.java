package carcompany2;

public class Sonata implements Car {
    private static final double DISTANCE_PRE_LITER = 10;
    private static final String CAR_NAME = "Sonata";

    private final double tripDistance;

    public Sonata(final double tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    public String getName() {
        return CAR_NAME;
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
