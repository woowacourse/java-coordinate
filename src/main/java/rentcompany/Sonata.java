package rentcompany;

public class Sonata extends Car {
    private static final String NAME = "Sonata";
    private static final double DISTANCE_PER_LITER = 10;

    Sonata(double tripDistance) {
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