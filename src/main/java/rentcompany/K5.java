package rentcompany;

public class K5 extends Car {
    private static final String NAME = "K5";
    private static final double DISTANCE_PER_LITER = 13;

    K5(double tripDistance) {
        super(tripDistance);
    }

    @Override
    String getName() {
        return NAME;
    }

    @Override
    double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    double getTripDistance() {
        return tripDistance;
    }
}