package carcompany2;

public class Avante implements Car {
    private static final double DISTANCE_PRE_LITER = 15;

    private final double tripDistance;

    public Avante(final double tripDistance) {
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
